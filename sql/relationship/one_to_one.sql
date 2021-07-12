create table pilots_licenses(
	id serial primary key,
	number int,
	ratings text
);

create table pilots(
	id serial primary key,
	name varchar(255),
	airplane_raid int,
	license_id int references pilots_licenses(id) unique
);