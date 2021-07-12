create table engines(
	id serial primary key,
	manufacturer varchar(255),
	model varchar(255),
	power_output int
);

create table airplanes(
	id serial primary key,
	manufacturer varchar(255),
	model varchar(255),
	cruise_speed int,
	creation_date date,
	engine_id int references engines(id)
);