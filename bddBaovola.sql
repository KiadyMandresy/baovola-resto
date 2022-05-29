Create database sakafo;
\c sakafo
Create table latabatra(
    id INTEGER NOT NULL,
    numero VARCHAR(40),
    isTaken smallint default 0,
    primary key(id)
);

Create table categoriePlat(
    id INTEGER NOT NULL,
    designation VARCHAR(40),
    primary key(id)
);

Create table plat(
    id INTEGER NOT NULL,
    designation VARCHAR(50),
    prix double precision,
    idCategorie INTEGER,
    primary key(id),
    foreign key(idCategorie) REFERENCES categoriePlat(id)
);

Create table ingredient(
    id INTEGER NOT NULL,
    nom VARCHAR(50),
    prix double precision,
    qte INTEGER,
    unite VARCHAR(10),
    primary key(id)
);

Create table detailPlat(
    id INTEGER NOT NULL,
    idPlat INTEGER,
    idIngredient INTEGER,
    qte double precision,
    unite VARCHAR(10),
    primary key(id),
    foreign key(idPlat) REFERENCES plat(id),
    foreign key(idIngredient) REFERENCES ingredient(id)
);

Create table serveur(
    id INTEGER NOT NULL,
    nom varchar(50),
    marge double precision,
    primary key(id)
);

Create table commande(
    id INTEGER NOT NULL,
    dateCom timestamp,
    status smallint default 0,
    idTable int,
    idServeur int,
    primary key(id),
    foreign key(idTable) REFERENCES latabatra(id),
    foreign key(idServeur) REFERENCES serveur(id)
);

Create table detailCommande(
    id INTEGER not null,
    idCommande int,
    idPlat INTEGER,
    idServeur INTEGER,
    qte INTEGER,
    primary key(id),
    foreign key(idCommande) REFERENCES commande(id),
    foreign key(idServeur) REFERENCES utilisateur(id),
    foreign key(idPlat) REFERENCES plat(id)
);

Create table client(
    id INTEGER NOT NULL,
    nom VARCHAR(100),
    primary key(id)
);

Create table clientCommande(
    id INTEGER NOT NULL,
    idClient int,
    idCommande INTEGER,
    foreign key(idClient) REFERENCES client(id),
    foreign key(idCommande) REFERENCES commande(id)
); 

Create table utilisateur(
    id INTEGER NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    roleUser VARCHAR(50),
    primary key(id)
);

create table marge(
    id Integer NOT NULL,
    prixMin double precision,
    prixMax double precision,
    pourcentage double precision,
    primary key(id)
);

create table payement(
    id INTEGER NOT NULL,
    idTable int,
    date timestamp,
    primary key(id),
    foreign key(idTable) REFERENCES latabatra(id)
);

create table typePayement(
    id INTEGER NOT NULL,
    nom varchar(50),
    primary key(id)
);

create table detailPayement(
    id INTEGER NOT NULL,
    idpayement int,
    idTypepayement int,
    montant double precision,
    primary key(id),
    foreign key(idpayement) REFERENCES payement(id),
    foreign key(idTypepayement) REFERENCES typePayement(id)
);

Create sequence seqLatabatra start with 1 increment by 1;
Create sequence seqCategoriePlat start with 1 increment by 1;
Create sequence seqPlat start with 1 increment by 1;
Create sequence seqCommande start with 1 increment by 1;
Create sequence seqDetailCommande start with 1 increment by 1;
Create sequence seqClient start with 1 increment by 1;
Create sequence seqUtilisateur start with 1 increment by 1;
Create sequence seqMarge start with 1 increment by 1;
Create sequence seqDetailPlat start with 1 increment by 1;
Create sequence seqIngredient start with 1 increment by 1;
Create sequence seqPayement start with 1 increment by 1;
Create sequence seqTypePayement start with 1 increment by 1;
Create sequence seqDetailPayement start with 1 increment by 1;
Create sequence seqServeur start with 1 increment by 1;

CREATE UNIQUE INDEX username ON utilisateur(username);


CREATE VIEW ingredientPlat as select d.qte as quantite,idPlat,i.nom as ingredient,i.prix as prix,i.unite as unite from detailPlat as d JOIN ingredient as i ON (d.idIngredient=i.id);

CREATE VIEW vuePayement AS SELECT t.numero AS numerotable,
    tp.nom AS typepayement,
    dp.montant,
    p.date
   FROM detailpayement dp
     JOIN payement p ON p.id = dp.idpayement
     JOIN typepayement tp ON tp.id = dp.idtypepayement
     JOIN latabatra t ON t.id = p.idtable;

CREATE VIEW ingredientPlat as select d.qte as quantite,idPlat,i.nom as ingredient,i.prix as prix,i.unite as unite from detailPlat as d JOIN ingredient as i ON (d.idIngredient=i.id);

CREATE view listePlatCommande as select p.designation,c.datecom as date,d.id,d.qte as quantite from detailCommande as d JOIN commande as c ON (d.idCommande=c.id) JOIN plat as p ON (d.idPlat=p.id) where d.idServeur is null and c.status=1 order by d.id;

insert into utilisateur values(nextval('seqUtilisateur'),'Kiady','kiady','serveur');
insert into utilisateur values(nextval('seqUtilisateur'),'ravo','ravo','Cuisine');
insert into utilisateur values(nextval('seqUtilisateur'),'Dawood','qwerty','admin');

insert into latabatra values(nextval('seqLatabatra'),1,0);

insert into commande values(nextval('seqCommande'),'2022-05-26 17:10:40.169059+03',1,1);

insert into categoriePlat values(nextval('seqCategoriePlat'), 'pate seche');
insert into categoriePlat values(nextval('seqCategoriePlat'), 'soupe');

insert into plat values(nextval('seqPlat'),'Mine sao',10000,1);
insert into plat values(nextval('seqPlat'),'Van Tan Mine',15000,2);

insert into detailCommande values(nextval('seqDetailCommande'),1,1,null,2);
insert into detailCommande values(nextval('seqDetailCommande'),1,2,null,1);

Create view pourboireCommande as 
    select s.id as idserveur,s.nom as serveur, c.dateCom as date, p.prix * dc.qte as prixTotal, s.marge as margeServeur from commande c
        join detailCommande dc 
            ON (c.id=dc.idCommande)
        join plat p 
            ON (dc.idPlat=p.id)
        join serveur s
            ON (c.idServeur=s.id);