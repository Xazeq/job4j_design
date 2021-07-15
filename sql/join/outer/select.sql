select * from employees e left join departments d on e.department_id = d.id;

select * from employees e right join departments d on e.department_id = d.id;

select * from employees e full join departments d on e.department_id = d.id;

select e.name, d.name, (e.department_id = d.id) as "Works here?" from employees e cross join departments d;

select * from departments d left join employees e on d.id = e.department_id
where e.department_id is null;

select e.name, d.name from employees e left join departments d on e.department_id = d.id;
select e.name, d.name from departments d right join employees e on d.id = e.department_id;