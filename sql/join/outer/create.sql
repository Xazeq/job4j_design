create table departments (
	id serial primary key,
	name varchar(255)
);

create table employees (
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments (name)
values ('dep1'), ('dep2'), ('dep3'), ('dep4');

insert into employees (name, department_id)
values ('Vasya', 1),
	   ('Petya', 2),
	   ('Kolya', 3),
	   ('Vanya', null),
	   ('Maksim', 2),
	   ('Oleg', 1);