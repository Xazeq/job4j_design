create table clients (
	id serial primary key,
	name varchar(255),
	address text
);

create table orders (
	id serial primary key,
	product varchar(255),
	count int,
	client_id int references clients(id)
);

insert into clients(name, address)
values ('Ivan', 'Moscow, Pushkina, 15'),
	   ('Petr', 'Orel, Lenina, 24');
	   
insert into orders (product, count, client_id)
values ('pen', 7, 2),
	   ('pencil', 4, 1);