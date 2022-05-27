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

Create table commande(
    id INTEGER NOT NULL,
    dateCom timestamp,
    status smallint default 0,
    idTable int,
    primary key(id),
    foreign key(idTable) REFERENCES latabatra(id)
);

Create table detailCommande(
    id INTEGER not null,
    idCommande int,
    idPlat INTEGER,
    qte INTEGER,
    primary key(id),
    foreign key(idCommande) REFERENCES commande(id),
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

Create sequence seqLatabatra start with 1 increment by 1;
Create sequence seqCategoriePlat start with 1 increment by 1;
Create sequence seqPlat start with 1 increment by 1;
Create sequence seqCommande start with 1 increment by 1;
Create sequence seqClient start with 1 increment by 1;
Create sequence seqUtilisateur start with 1 increment by 1;
Create sequence seqMarge start with 1 increment by 1;
Create sequence seqDetailPlat start with 1 increment by 1;
Create sequence seqIngredient start with 1 increment by 1;

CREATE UNIQUE INDEX username ON utilisateur(username);

CREATE VIEW ingredientPlat as select d.qte as quantite,idPlat,i.nom as ingredient,i.prix as prix,i.unite as unite from detailPlat as d JOIN ingredient as i ON (d.idIngredient=i.id);