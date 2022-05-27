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
d
Create table plat(
    id INTEGER NOT NULL,
    designation VARCHAR(50),
    prix double precision,
    idCategorie INTEGER,
    primary key(id),
    foreign key(idCategorie) REFERENCES categoriePlat(id)
);

Create table commande(
    id INTEGER NOT NULL,
    dateCom timestamp,
    status smallint default 0,
    idTable INTEGER,
    primary key(id),
    foreign key(idTable) REFERENCES latabatra(id)
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
    nom VARCHAR(255),
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

Create sequence seqLatabatra start with 1 increment by 1;
Create sequence seqCategoriePlat start with 1 increment by 1;
Create sequence seqPlat start with 1 increment by 1;
Create sequence seqCommande start with 1 increment by 1;
Create sequence seqDetailCommande start with 1 increment by 1;
Create sequence seqClient start with 1 increment by 1;
Create sequence seqUtilisateur start with 1 increment by 1;

CREATE UNIQUE INDEX username ON utilisateur(username);

insert into latabatra values(nextval('seqLatabatra'),1,0);
insert into latabatra values(nextval('seqLatabatra'),2,0);
insert into latabatra values(nextval('seqLatabatra'),3,0);
insert into latabatra values(nextval('seqLatabatra'),4,0);


insert into commande values(nextval('seqCommande'),'2022-05-26 17:10:40.169059+03',1,1);

insert into categoriePlat values(nextval('seqCategoriePlat'), 'pate seche');
insert into categoriePlat values(nextval('seqCategoriePlat'), 'soupe');
insert into categoriePlat values(nextval('seqCategoriePlat'), 'boisson');
insert into categoriePlat values(nextval('seqCategoriePlat'), 'dessert');

insert into plat values(nextval('seqPlat'),'Mine sao',10000,1);
insert into plat values(nextval('seqPlat'),'Mine sao special',12000,1);
insert into plat values(nextval('seqPlat'),'Pate sautee',11500,1);
insert into plat values(nextval('seqPlat'),'mine',10000,1);

insert into plat values(nextval('seqPlat'),'Van tan mine',12000,2);
insert into plat values(nextval('seqPlat'),'Van tan mine garnie',14000,2);
insert into plat values(nextval('seqPlat'),'Tsock',10000,2);
insert into plat values(nextval('seqPlat'),'Tsock special',14000,2);

insert into plat values(nextval('seqPlat'),'Coca - cola',3000,3);
insert into plat values(nextval('seqPlat'),'sprite',3000,3);
insert into plat values(nextval('seqPlat'),'fanta',3500,3);
insert into plat values(nextval('seqPlat'),'bonbon anglais',3000,3);

insert into plat values(nextval('seqPlat'),'banane flambee',8000,4);
insert into plat values(nextval('seqPlat'),'ile flottante',10000,4);
insert into plat values(nextval('seqPlat'),'glace',8000,4);
insert into plat values(nextval('seqPlat'),'cafe gourmand',10000,4);


insert into detailCommande values(nextval('seqDetailCommande'),1,1,null,2);
insert into detailCommande values(nextval('seqDetailCommande'),1,2,null,1);

insert into utilisateur values(nextval('seqUtilisateur'),'kiady','qwerty','serveur');