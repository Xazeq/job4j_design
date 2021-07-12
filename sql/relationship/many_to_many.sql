create table airplane_pilots(
	id serial primary key,
	airplane_id int references airplanes(id),
	pilot_id int references pilots(id)
);