Create database sakafo;
\c sakafo
Create table latabatra(
    idLatabatra INTEGER NOT NULL,
    numero VARCHAR(40),
    isTaken smallint default 0,
    primary key(idLatabatra)
);

Create table categoriePlat(
    idCategorie INTEGER NOT NULL,
    designation VARCHAR(40),
    primary key(idCategorie)
);

Create table plat(
    idPlat INTEGER NOT NULL,
    designation VARCHAR(50),
    prix double precision,
    idCategorie INTEGER,
    primary key(idPlat),
    foreign key(idCategorie) REFERENCES categoriePlat(idCategorie)
);

Create table commande(
    idCommande INTEGER NOT NULL,
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
    idClient INTEGER NOT NULL,
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