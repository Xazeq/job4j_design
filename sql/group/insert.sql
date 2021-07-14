insert into devices(name, price)
values ('iPhone X', 10000), ('Samsung s20', 8000), ('Huawei p40', 3000), ('Xiaomi mi11', 2500);

insert into people(name) values ('Вася'), ('Гена'), ('Коля');

insert into devices_people(device_id, people_id) values (1, 2), (1, 3), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3), (4, 1), (4, 3);