select c.name as car_name, b.name as body, t.name as transmission,
t.type as t_type, e.name as engine, e.type as e_type
from car c 
join body b on c.body_id = b.id
join transmission t on c.transmission_id = t.id
join engine e on c.engine_id = e.id;

select b.name, b.color from body b left join car c on b.id = c.body_id
where c.id is null;

select t.name, t.type from transmission t left join car c on t.id = c.transmission_id
where c.id is null;

select e.name, e.type from car c right join engine e on c.engine_id = e.id
where c.id is null;