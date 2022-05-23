Create database sakafo;
\c sakafo
Create table latabatra(
    id INTEGER NOT NULL,
    numero VARCHAR(40),
    isTaken smallint default 0,
    primary key(idLatabatra)
);

Create table categoriePlat(
    id INTEGER NOT NULL,
    designation VARCHAR(40),
    primary key(idCategorie)
);

Create table plat(
    id INTEGER NOT NULL,
    designation VARCHAR(50),
    prix double precision,
    idCategorie INTEGER,
    primary key(idPlat),
    foreign key(idCategorie) REFERENCES categoriePlat(idCategorie)
);

Create table commande(
    id INTEGER NOT NULL,
    dateCom timestamp,
    status smallint default 0,
    primary key(idCommande)
);

Create table detailCommande(
    idCommande INTEGER,
    idPlat INTEGER,
    qte INTEGER,
    foreign key(idCommande) REFERENCES commande(idCommande),
    foreign key(idPlat) REFERENCES plat(idPlat)
);

Create table client(
    id INTEGER NOT NULL,
    idLatabatra INTEGER,
    primary key(idClient),
    foreign key(idLatabatra) REFERENCES latabatra(idLatabatra)
);

Create table clientCommande(
    idClient INTEGER,
    idCommande INTEGER,
    foreign key(idClient) REFERENCES client(idClient),
    foreign key(idCommande) REFERENCES commande(idCommande)
); 

Create sequence seqLatabatra start with 1 increment by 1;
Create sequence seqCategoriePlat start with 1 increment by 1;
Create sequence seqPlat start with 1 increment by 1;
Create sequence seqCommande start with 1 increment by 1;
Create sequence seqClient start with 1 increment by 1;