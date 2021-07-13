create table role(
	id serial primary key,
	name varchar(255)
);

create table rules(
	id serial primary key,
	create_item boolean,
	delete_item boolean,
	edit_item boolean
);

create table role_rules(
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table users(
	id serial primary key,
	name varchar(255),
	role_id int references role(id)
);

create table category(
	id serial primary key,
	category_name varchar(255)
);

create table state(
	id serial primary key,
	state_name varchar(255)
);

create table item(
	id serial primary key,
	item_name varchar(255),
	user_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table comments(
	id serial primary key,
	comment text,
	item_id int references item(id)
);

create table attachs(
	id serial primary key,
	attach text,
	item_id int references item(id)
);