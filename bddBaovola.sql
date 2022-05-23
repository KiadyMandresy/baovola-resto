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
    primary key(id)
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
    idLatabatra INTEGER,
    primary key(id),
    foreign key(idLatabatra) REFERENCES latabatra(id)
);

Create table clientCommande(
    id INTEGER NOT NULL,
    idClient int,
    idCommande INTEGER,
    foreign key(idClient) REFERENCES client(id),
    foreign key(idCommande) REFERENCES commande(id)
); 

Create sequence seqLatabatra start with 1 increment by 1;
Create sequence seqCategoriePlat start with 1 increment by 1;
Create sequence seqPlat start with 1 increment by 1;
Create sequence seqCommande start with 1 increment by 1;
Create sequence seqClient start with 1 increment by 1;