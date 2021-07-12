create table airplanes(
	id serial primary key,
	manufacturer text,
	model varchar(255),
	cruise_speed integer,
	creation_date date
);