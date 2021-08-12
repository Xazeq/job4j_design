select p.name, c.name from person p join company c on c.id = p.company_id
where p.company_id != 5;

select  c.name,  count(p.id) as number_of_people from company c join person p ON c.id = p.company_id
group by c.id
order by number_of_people desc
limit 1;