create table teens (
	id serial primary key,
	name varchar(255),
	gender varchar(6)
);

insert into teens (name, gender)
values ('Vasya', 'male'),
	   ('Olga', 'female'),
	   ('Anna', 'female'),
	   ('Inga', 'female'),
	   ('Egor', 'male'),
	   ('Petr', 'male'),
	   ('Alina', 'female');