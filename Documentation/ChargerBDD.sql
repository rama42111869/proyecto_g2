/*
DROP DATABASE IF EXISTS eCommerce;
CREATE DATABASE IF NOT EXISTS eCommerce;
*/

/**CHARGED DATABASE FROM PRESENTATION***/
Use eCommerce;

/**CATEGORIES**/
INSERT INTO Category VALUES (0,'Remera','M');/*1*/
INSERT INTO Category VALUES (0,'Chomba','M');/*2*/
INSERT INTO Category VALUES (0,'Camisa','M');/*3*/
INSERT INTO Category VALUES (0,'Buzo','M');/*4*/
INSERT INTO Category VALUES (0,'Campera','M');/*5*/
INSERT INTO Category VALUES (0,'Joggin','M');/*6*/
INSERT INTO Category VALUES (0,'Jean','M');/*7*/
INSERT INTO Category VALUES (0,'Bermuda','M');/*8*/


/**PRODUCTS**/

/*REMERAS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/PrK1RV0/a.jpg','Passion-R',1500,1);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/gg60RvJ/b.jpg','Poisonous-R',1500,1);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/Rzf385M/c.jpg','Pegasus-R',2000,1);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/s6kBx6s/d.jpg','SpeedLight-R',2000,1);

/*CHOMBAS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/x16d9Z0/E-PCH1.jpg','Passion-CH',1500,2);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/SyrYYb1/W-PCH1.jpg','Poisonous-CH',1500,2);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/RCDpk5k/S-PCH1.jpg','Pegasus-CH',2000,2);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/1Z3tx01/T-SCH1.jpg','SpeedLight-CH',2000,2);

/*CAMISAS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/h9pbr5N/E-PCA1.jpg','Passion-CA',1500,3);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/7X4jHDH/W-PCA1.jpg','Poisonous-CA',1500,3);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/KFwsKRv/S-PCA1.jpg','Pegasus-CA',2000,3);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/ZXfbgN5/T-SCA1.jpg','SpeedLight-CA',2000,3);

/*BUZOS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/47tcBfj/i.jpg','Passion-BU',7000,4);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/M6wSzN7/j.jpg','Poisonous-BU',8000,4);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/vsGcXjr/k.jpg','Pegasus-BU',7500,4);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/5K76zgL/l.jpg','SpeedLight-BU',9000,4);

/*CAMPERAS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/p3P5RkB/m.jpg','Passion-CA',5000,5);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/NVNFmQC/n.jpg','Poisonous-CA',5500,5);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/YRhXYWK/o.jpg','Pegasus-CA',6000,5);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/fSZtdLk/p.jpg','SpeedLight-CA',6500,5);                             

/*JOGGINS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/PD85mwX/e.jpg','Passion-JO',4000,6);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/4tXvB5Q/imagen-2022-10-07-155608945.png','Poisonous-JO',3000,6);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/F0Qdn0q/S-PJO1.png','Pegasus-JO',3500,6);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/kQTq89Q/h.jpg','SpeedLight-JO',2500,6);

/*JEANS*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/j6mz5th/E-PJE1.jpg','Passion-JE',4000,7);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/pQM60cy/W-PJE1.jpg','Poisonous-JE',3000,7);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/NK5f0Wy/g.jpg','Pegasus-JE',3500,6);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/99jgwWQ/T-SJE1.jpg','SpeedLight-JE',2500,7);

/*BERMUDA*/
INSERT INTO Product VALUES (0,'Ezyone','Elegancia de Venezia a NY'
                             ,'https://i.ibb.co/SN7dVnQ/E-PBE1.jpg','Passion-BE',4000,8);
INSERT INTO Product VALUES (0,'Wyvern','Agresivo desde el olvido'
                             ,'https://i.ibb.co/ZfJYjmB/W-PBE1.jpg','Poisonous-BE',3000,8);
INSERT INTO Product VALUES (0,'Speedwagon','Permítete elucidarte'
                             ,'https://i.ibb.co/hm8Hdf2/S-PBE1.webp','Pegasus-BE',3500,8);
INSERT INTO Product VALUES (0,'Thunder','Se tu leyenda mas alla de las estrellas'
                             ,'https://i.ibb.co/xHcZs1S/T-SBE1.jpg','SpeedLight-BE',2500,8);


/**USERS**/
INSERT INTO User VALUES (0,"lamadridpablo@gmail.com","Pablo","Lamadrid");
INSERT INTO User VALUES (0,"ramirosg_@hotmail.com","Ramiro","Gonzales");
INSERT INTO User VALUES (0,"lucaspalomodev@gmail.com","Lucas","Palomo");
INSERT INTO User VALUES (0,"vallejomaira218@gmail.com","Maira","Vallejo");
INSERT INTO User VALUES (0,"misaelflores4190@gmail.com","Misael","Flores");
INSERT INTO User VALUES (0,"velazquezsergio714@gmail.com","Sergio","Velazquez");
INSERT INTO User VALUES (0,"adrian.canobbio.it@gmail.com","Adrian","Canobbio");
INSERT INTO User VALUES (0,"liloiascott@gmail.com","Nicolas","Scott");


/**CREDIT CARDS**/
/*INSERT INTO User VALUES (0,numTarj,fechaExp,codSeg,userID);*/
INSERT INTO Credit_cards VALUES (0,FLOOR(4500000000000000 + RAND()*(4599999999999999-4500000000000000))
                                  ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2026'),'%m-%d-%Y')
                                  ,FLOOR(1 + RAND()*(999-1)),1);
INSERT INTO Credit_cards VALUES (0,"4514-4964-2981-3836","2025-06-10",559,2);
INSERT INTO Credit_cards VALUES (0,"4564-2245-5348-6131","2025-02-18",750,3);
INSERT INTO Credit_cards VALUES (0,"4976-5666-5679-5111","2024-08-25",964,4);
INSERT INTO Credit_cards VALUES (0,FLOOR(4500000000000000 + RAND()*(4599999999999999-4500000000000000))
                                  ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2026'),'%m-%d-%Y')
                                  ,FLOOR(1 + RAND()*(999-1)),5);
INSERT INTO Credit_cards VALUES (0,"4157-4394-9778-7427","2024-09-10",010,6);
INSERT INTO Credit_cards VALUES (0,"4805-1179-2903-4438","2027-12-02",524,7);
INSERT INTO Credit_cards VALUES (0,"4742-8956-6891-1819","2024-01-30",635,8);


/**PURCHASES**/

/*PABLO*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),1);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),1);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),1);

/*RAMA*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),2);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),2);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),2);

/*LUCAS*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),3);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),3);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),3);

/*MAI*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),4);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),4);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),4);

/*MISA*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),5);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),5);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),5);

/*SERGIO*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),6);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),6);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),6);

/*ADRI*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),7);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),7);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),7);

/*NICO*/
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),8);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),8);
INSERT INTO Purchase VALUES (0,FLOOR(1 + RAND()*(30-1))
                              ,str_to_date(concat(
                                        floor(1 + rand() * (12-1)), /*Generate a random month*/ '-',
                                        floor(1 + rand() * (28-1)), /*Generate a random day*/ '-',
                                        '2022'),'%m-%d-%Y')
                              ,FLOOR(1 + RAND()*(30-1)),8);


/**SHOPPING CART ITEMS**/

/*PABLO*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),1);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),1);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),1);

/*RAMA*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),2);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),2);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),2);

/*LUCAS*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),3);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),3);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),3);

/*MAI*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),4);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),4);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),4);

/*MISA*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),5);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),5);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),5);

/*SERGIO*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),6);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),6);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),6);

/*ADRI*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),7);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),7);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),7);

/*NICO*/
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),8);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),8);
INSERT INTO Shopping_carts VALUES (0,FLOOR(1 + RAND()*(30-1)),8);


/**WISH LIST ITEMS**/

/*PABLO*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),1);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),1);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),1);

/*RAMA*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),2);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),2);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),2);

/*LUCAS*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),3);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),3);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),3);

/*MAI*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),4);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),4);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),4);

/*MISA*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),5);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),5);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),5);

/*SERGIO*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),6);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),6);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),6);

/*ADRI*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),7);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),7);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),7);

/*NICO*/
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),8);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),8);
INSERT INTO Wish_lists VALUES (0,FLOOR(1 + RAND()*(30-1)),8);