insert into latabatra values(1, 'Table 1', 0);
insert into latabatra values(2, 'Table 2', 0);
insert into latabatra values(3, 'Table 3', 0);
insert into latabatra values(4, 'Table 4', 0);
insert into latabatra values(5, 'Table 5', 0);

insert into commande values(1, '2022-05-26 11:12:00', 0, 1);
insert into commande values(2, '2022-05-26 11:12:00', 0, 2);
insert into commande values(3, '2022-05-26 11:12:00', 1, 3);
insert into commande values(4, '2022-05-26 11:12:00', 1, 4);
insert into commande values(5, '2022-05-26 11:12:00', 1, 5);

insert into categoriePlat values(1, 'dessert');

insert into plat values(1, 'tarte', 3500, 1);

insert into detailCommande values(1, 3, 1, 1);
insert into detailCommande values(2, 4, 1, 2);
insert into detailCommande values(3, 5, 1, 3);

insert into client values(1, 'Ravo');
insert into client values(2, 'Nomena');
insert into client values(3, 'Kiady');

insert into clientcommande values(1, 1,3);
insert into clientcommande values(2, 2,4);
insert into clientcommande values(3, 3,5);