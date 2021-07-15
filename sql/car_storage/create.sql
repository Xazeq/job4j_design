create table body(
	id serial primary key,
	name varchar(255),
	color varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255),
	type varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255),
	type varchar(255),
	power real
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	transmission_id int references transmission(id),
	engine_id int references engine(id)
);

insert into body (name, color)
values ('sedan', 'black'),
	   ('hatchback', 'white'),
	   ('universal', 'blue'),
	   ('sedan', 'yellow');
	   
insert into transmission (name, type)
values ('t1', 'auto'),
	   ('t2', 'manual'),
	   ('t3', 'robot');
	   
insert into engine(name, type, power)
values ('e1', 'gas', 150),
	   ('e2', 'diesel', 200),
	   ('e3', 'electric', 100),
	   ('e4', 'gas', 160);
	   
insert into car (name, body_id, transmission_id, engine_id)
values ('car1', 1, 1, 1),
	   ('car2', 3, 3, 3);