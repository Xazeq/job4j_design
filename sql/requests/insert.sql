insert into role (name) values ('admin'), ('user');

insert into rules (create_item, delete_item, edit_item)
values ('true', 'true', 'true'), ('true', 'false', 'false');

insert into role_rules (role_id, rules_id)
values (1, 1), (2, 2);

insert into users (name, role_id)
values ('Ivan', 1), ('Petr', 2);

insert into category (category_name)
values ('error'), ('other');

insert into state (state_name)
values ('created'), ('rewieved'), ('complited');

insert into item (item_name, user_id, category_id, state_id)
values ('Nothing doesnt work', 2, 1, 1), 
	   ('update soft', 2, 2, 2);
	   
insert into comments (comment, item_id)
values ('Program does not start', 1),
	   ('New version of the program has been released', 2);
	   
insert into attachs (attach, item_id)
values ('https://prnt.sc/19hed33', 1),
	   ('https://prnt.sc/19hed35', 2);