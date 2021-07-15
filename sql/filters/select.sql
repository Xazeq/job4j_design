select p.name, p.expired_date, p.price 
from product as p join type as t on p.type_id = t.id 
where t.name = 'СЫР';

select * from product where name like '%мороженое%';

select * from product where current_date > expired_date;

select * from product where price = (select max(price) from product);

select t.name, count(p.name) 
from product as p join type as t on p.type_id = t.id 
group by t.name;

select p.name, p.expired_date, p.price, t.name
from product as p join type as t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(p.name) from product as p join type as t on p.type_id = t.id
group by t.name
having count(p.name) < 10;

select p.name, t.name from product as p join type as t on p.type_id = t.id;