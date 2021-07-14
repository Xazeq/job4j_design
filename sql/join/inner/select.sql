select o.product, o.count, cl.name from orders o join clients cl on o.client_id = cl.id;

select o.product as Товар, o.count as Количество, cl.name as Имя, cl.address as Адрес
from orders o join clients cl on o.client_id = cl.id;

select * from orders o join clients cl on o.client_id = cl.id;