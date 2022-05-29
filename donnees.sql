
insert into utilisateur values(1, 'dawood', '1234', 'admin');

insert into latabatra values(1, 'Table 1', 0);
insert into latabatra values(2, 'Table 2', 0);
insert into latabatra values(3, 'Table 3', 0);
insert into latabatra values(4, 'Table 4', 0);
insert into latabatra values(5, 'Table 5', 0);


insert into serveur values(1, 'Jean', 0.02);

insert into commande values(1, '2022-05-26 11:12:00', 0, 1,1);
insert into commande values(2, '2022-05-26 11:12:00', 0, 2,1);
insert into commande values(3, '2022-05-26 11:12:00', 1, 3,1);
insert into commande values(4, '2022-05-26 11:12:00', 1, 4,1);
insert into commande values(5, '2022-05-26 11:12:00', 1, 5,1);

insert into commande values(nextval('seqCommande'),'2022-05-26 17:10:40.169059+03',1,1,1);

insert into categoriePlat values(1, 'dessert');

insert into plat values(1, 'tarte', 3500, 1);

insert into ingredient values(1, 'farine', 2000, 1, 'kg');
insert into ingredient values(2, 'citron', 3000, 1, 'kg');

insert into stockIngredient values(1, 1, 200, 0, '2022-05-29 16:00:00');
insert into stockIngredient values(2, 2, 200, 0, '2022-05-29 16:00:00');

insert into stockIngredient values(3, 1, 0, 100, '2022-05-29 16:00:00');
insert into stockIngredient values(4, 2, 0, 100, '2022-05-29 16:00:00');

insert into detailPlat values(1, 1, 1, 0.5, 'kg');
insert into detailPlat values(2, 1, 2, 0.5, 'kg');

insert into detailCommande values(1, 3, 1, 1);
insert into detailCommande values(2, 4, 1, 2);
insert into detailCommande values(3, 5, 1, 3);

insert into detailCommande values(nextval('seqDetailCommande'),1,1,null,2);
insert into detailCommande values(nextval('seqDetailCommande'),1,2,null,1);
insert into detailCommande values(nextval('seqDetailCommande'),1,1,null,2);

insert into client values(1, 'Ravo');
insert into client values(2, 'Nomena');
insert into client values(3, 'Kiady');

insert into clientcommande values(1, 1,3);
insert into clientcommande values(2, 2,4);
insert into clientcommande values(3, 3,5);

insert into marge values(1, 0, 5, 200);
insert into marge values(2, 5, 10, 100);

insert into payement values(1, 3, '2022-05-27');
insert into payement values(2, 4, '2022-05-27');
insert into payement values(3, 5, '2022-05-27');

insert into typePayement values(1, 'Espece');
insert into typePayement values(2, 'Carte');

insert into detailPayement values(1, 1, 1, 500);
insert into detailPayement values(2, 2, 2, 1000);
insert into detailPayement values(3, 3, 1, 900);