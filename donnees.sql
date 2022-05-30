
insert into utilisateur values(nextval('seqUtilisateur'),'Kiady','kiady','serveur');
insert into utilisateur values(nextval('seqUtilisateur'),'ravo','ravo','Cuisine');
insert into utilisateur values(nextval('seqUtilisateur'),'Dawood','qwerty','admin');


insert into latabatra values(nextval('seqTable'), 'Table 1', 0);
insert into latabatra values(nextval('seqTable'), 'Table 2', 0);
insert into latabatra values(nextval('seqTable'), 'Table 3', 0);
insert into latabatra values(nextval('seqTable'), 'Table 4', 0);
insert into latabatra values(nextval('seqTable'), 'Table 5', 0);

insert into serveur values(nextval('seqServeur'), 'Kiady', 0.02,1);

insert into commande values(nextval('seqCommande'), '2022-05-26 11:12:00', 0, 1,1);
insert into commande values(nextval('seqCommande'), '2022-05-26 11:12:00', 0, 2,1);
insert into commande values(nextval('seqCommande'), '2022-05-26 11:12:00', 1, 3,1);
insert into commande values(nextval('seqCommande'), '2022-05-26 11:12:00', 1, 4,1);
insert into commande values(nextval('seqCommande'), '2022-05-26 11:12:00', 1, 5,1);

insert into categoriePlat values(1, 'dessert');

insert into plat values(1, 'tarte', 3500, 1);

insert into ingredient values(1, 'farine', 2000, 1, 'kg');
insert into ingredient values(2, 'citron', 3000, 1, 'kg');

insert into stockIngredient values(nextval('seqStockIngredient'), 1, 200, 0, '2022-05-29 16:00:00');
insert into stockIngredient values(nextval('seqStockIngredient'), 2, 200, 0, '2022-05-29 16:00:00');

insert into stockIngredient values(nextval('seqStockIngredient'), 1, 0, 100, '2022-05-29 16:00:00');
insert into stockIngredient values(nextval('seqStockIngredient'), 2, 0, 100, '2022-05-29 16:00:00');

insert into detailPlat values(nextval('seqDetailPlat'), 1, 1, 0.5, 'kg');
insert into detailPlat values(nextval('seqDetailPlat'), 1, 2, 0.5, 'kg');

insert into detailCommande values(nextval('seqDetailCommande'),1,1,null,2);
insert into detailCommande values(nextval('seqDetailCommande'),2,1,null,1);
insert into detailCommande values(nextval('seqDetailCommande'),3,1,null,2);
insert into detailCommande values(nextval('seqDetailCommande'),4,1,null,2);
insert into detailCommande values(nextval('seqDetailCommande'),5,1,null,1);

insert into client values(nextval('seqClient'), 'Ravo');
insert into client values(nextval('seqClient'), 'Nomena');
insert into client values(nextval('seqClient'), 'Kiady');

insert into clientcommande values(nextval('seqClientCommande'), 1,1);
insert into clientcommande values(nextval('seqClientCommande'), 2,2);
insert into clientcommande values(nextval('seqClientCommande'), 1,3);
insert into clientcommande values(nextval('seqClientCommande'), 2,4);
insert into clientcommande values(nextval('seqClientCommande'), 3,5);

insert into marge values(nextval('seqMarge'), 0, 5, 200);
insert into marge values(nextval('seqMarge'), 5, 10, 100);

insert into payement values(nextval('seqPayement'), 3, '2022-05-27');
insert into payement values(nextval('seqPayement'), 4, '2022-05-27');
insert into payement values(nextval('seqPayement'), 5, '2022-05-27');

insert into typePayement values(nextval('seqTypePayement'), 'Espece');
insert into typePayement values(nextval('seqTypePayement'), 'Carte');

insert into detailPayement values(nextval('seqDetailPayement'), 1, 1, 500);
insert into detailPayement values(nextval('seqDetailPayement'), 2, 2, 1000);
insert into detailPayement values(nextval('seqDetailPayement'), 3, 1, 900);