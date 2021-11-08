USE sql_hr;
INSERT INTO
    offices (address, city, state)
VALUES
    ('03 Reinke Trail','Cincinnati','OH'),
    ('5507 Becker Terrace','New York City','NY'),
    ('54 Northland Court','Richmond','VA'),
    ('08 South Crossing','Cincinnati','OH'),
    ('553 Maple Drive','Minneapolis','MN'),
    ('23 North Plaza','Aurora','CO'),
    ('9658 Wayridge Court','Boise','ID'),
    ('9 Grayhawk Trail','New York City','NY'),
    ('16862 Westend Hill','Knoxville','TN'),
    ('4 Bluestem Parkway','Savannah','GA');


INSERT INTO
    employees(employee_id, first_name, last_name, job_title, salary, reports_to, office_id)
VALUES
    (37270,'Yovonnda','Magrannell','Executive Secretary',63996,NULL,10),
    (33391,'Darcy','Nortunen','Account Executive',62871,37270,1),
    (37851,'Sayer','Matterson','Statistician III',98926,37270,1),
    (40448,'Mindy','Crissil','Staff Scientist',94860,37270,1),
    (56274,'Keriann','Alloisi','VP Marketing',110150,37270,1),
    (63196,'Alaster','Scutchin','Assistant Professor',32179,37270,2),
    (67009,'North','de Clerc','VP Product Management',114257,37270,2),
    (67370,'Elladine','Rising','Social Worker',96767,37270,2),
    (68249,'Nisse','Voysey','Financial Advisor',52832,37270,2),
    (72540,'Guthrey','Iacopetti','Office Assistant I',117690,37270,3),
    (72913,'Kass','Hefferan','Computer Systems Analyst IV',96401,37270,3),
    (75900,'Virge','Goodrum','Information Systems Manager',54578,37270,3),
    (76196,'Mirilla','Janowski','Cost Accountant',119241,37270,3),
    (80529,'Lynde','Aronson','Junior Executive',77182,37270,4),
    (80679,'Mildrid','Sokale','Geologist II',67987,37270,4),
    (84791,'Hazel','Tarbert','General Manager',93760,37270,4),
    (95213,'Cole','Kesterton','Pharmacist',86119,37270,4),
    (96513,'Theresa','Binney','Food Chemist',47354,37270,5),
    (98374,'Estrellita','Daleman','Staff Accountant IV',70187,37270,5),
    (115357,'Ivy','Fearey','Structural Engineer',92710,37270,5);

INSERT INTO
     products(name, quantity_in_stock, unit_price)
VALUES
    ('Foam Dinner Plate',70,1.21),
    ('Pork - Bacon,back Peameal',49,4.65),
    ('Lettuce - Romaine, Heart',38,3.35),
    ('Brocolinni - Gaylan, Chinese',90,4.53),
    ('Sauce - Ranch Dressing',94,1.63),
    ('Petit Baguette',14,2.39),
    ('Sweet Pea Sprouts',98,3.29),
    ('Island Oasis - Raspberry',26,0.74),
    ('Longan',67,2.26),
    ('Broom - Push',6,1.09);

INSERT INTO
     shippers(name)
VALUES
    ('Hettinger LLC'),
    ('Schinner-Predovic'),
    ('Satterfield LLC'),
    ('Mraz, Renner and Nolan'),
    ('Waters, Mayert and Prohaska');

INSERT INTO
     customers(first_name, last_name, birth_date, phone, address, city, state, points)
VALUES
('Babara','MacCaffrey','1986-03-28','781-932-9754','0 Sage Terrace','Waltham','MA',2273),
('Ines','Brushfield','1986-04-13','804-427-9456','14187 Commercial Trail','Hampton','VA',947),
('Freddi','Boagey','1985-02-07','719-724-7869','251 Springs Junction','Colorado Springs','CO',2967),
('Ambur','Roseburgh','1974-04-14','407-231-8017','30 Arapahoe Terrace','Orlando','FL',457),
('Clemmie','Betchley','1973-11-07',NULL,'5 Spohn Circle','Arlington','TX',3675),
('Elka','Twiddell','1991-09-04','312-480-8498','7 Manley Drive','Chicago','IL',3073),
('Ilene','Dowson','1964-08-30','615-641-4759','50 Lillian Crossing','Nashville','TN',1672),
('Thacher','Naseby','1993-07-17','941-527-3977','538 Mosinee Center','Sarasota','FL',205),
('Romola','Rumgay','1992-05-23','559-181-3744','3520 Ohio Trail','Visalia','CA',1486),
('Levy','Mynett','1969-10-13','404-246-3370','68 Lawn Avenue','Atlanta','GA',796);

INSERT INTO
     orders(customer_id, order_date, status, comments, shipped_date, shipper_id)
VALUES
(6,'2019-01-30',default,NULL,NULL,NULL),
(7,'2018-08-02','SHIPPED',NULL,'2018-08-03',4),
(8,'2017-12-01',default,NULL,NULL,NULL),
(2,'2017-01-22',default,NULL,NULL,NULL),
(5,'2017-08-25','SHIPPED','','2017-08-26',3),
(10,'2018-11-18',default,'Aliquam erat volutpat. In congue.',NULL,NULL),
(2,'2018-09-22','SHIPPED',NULL,'2018-09-23',4),
(5,'2018-06-08',default,'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.',NULL,NULL),
(10,'2017-07-05','SHIPPED','Nulla mollis molestie lorem. Quisque ut erat.','2017-07-06',1),
(6,'2018-04-22','SHIPPED',NULL,'2018-04-23',2);

INSERT INTO
     order_items(order_id, product_id, quantity)
VALUES
    (1,4,4),
    (2,1,2),
    (2,4,4),
    (2,6,2),
    (3,3,10),
    (4,3,7),
    (4,10,7),
    (5,2,3),
    (6,1,4),
    (6,2,4),
    (6,3,4),
    (6,5,1),
    (7,3,7),
    (8,5,2),
    (8,8,2),
    (9,6,5),
    (10,1,10),
    (10,9,9);
--    (1,4,4,3.74),
--    (2,1,2,9.10),
--    (2,4,4,1.66),
--    (2,6,2,2.94),
--    (3,3,10,9.12),
--    (4,3,7,6.99),
--    (4,10,7,6.40),
--    (5,2,3,9.89),
--    (6,1,4,8.65),
--    (6,2,4,3.28),
--    (6,3,4,7.46),
--    (6,5,1,3.45),
--    (7,3,7,9.17),
--    (8,5,2,6.94),
--    (8,8,2,8.59),
--    (9,6,5,7.28),
--    (10,1,10,6.01),
--    (10,9,9,4.28);

