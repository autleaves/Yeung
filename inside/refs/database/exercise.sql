select distinct T.name, T.dept_name
from instructor as T, instructor as S
where T.salary > S.salary and S.dept_name = 'Biology';

select dept_name, building from department
where building like '_atson%';

select name from instructor where dept_name='Physics' order by name asc;

select name, salary from instructor 
where salary between 90000 and 100000 order by salary desc;

select name, course_id, dept_name from instructor, teaches 
where (instructor.ID, dept_name) = (teaches.ID, 'Biology');

(select course_id from section where semester='Fall' and year=2017)
union
(select course_id from section where semester='Spring' and year=2018);

select course_id from section where semester='Fall' and year=2017
 and course_id in (select course_id from section where semester='Spring' and year=2018);
 
--  (select course_id from section where semester='Fall' and year=2017)
-- except
-- (select course_id from section where semester='Spring' and year=2018);

select course_id from section where semester='Fall' and year=2017
 and course_id not in (select course_id from section where semester='Spring' and year=2018);
 
 select course_id from section where semester='Fall' and year=2017;
 
 select * from takes where grade is null;
 
 select dept_name, avg(salary) as avg_salary
 from instructor
 group by dept_name
 having avg_salary > 61000;
 
 select  ID from teaches where semester='Spring' and year=2018;
 
 select course_id,semester,year,sec_id, avg(tot_cred)
 from student S, takes T
 where S.ID = T.ID and year = 2017
 group by course_id, semester, year, sec_id 
 having count(T.ID) >= 2;
 
 select min(salary) from instructor;
 select  name from instructor where name not in ('Mozart', 'Einstein');
 select count(distinct ID) from takes
	where (course_id, sec_id, semester, year) 
	in (select course_id, sec_id, semester, year from teaches where teaches.ID='10101');
    
select name, salary from instructor 
where salary > all(select salary from instructor where dept_name='Biology');

select dept_name, avg(salary) from instructor group by dept_name
having avg(salary) >= all
(select avg(salary) from instructor group by dept_name);

select course_id from section as S
where semester='Fall' and year=2017 and exists
	(select * from section as T where semester='Spring' and year='2018' 
		and S.course_id=T.course_id);
        
select course_id, title from section as S where semester='Fall' and year=2017 and 
	exists (select * from section as T where semester='Spring' and year=2018 and S.course_id = T.course_id);


select S.ID, S.name from student as S where
not exists(
select course_id from course where dept_name='Biology' 
	not in (select course_id from takes as T where S.ID = T.ID));

select count(distinct ID) from takes where (course_id, sec_id, semester, year) in 
(select course_id, sec_id, semester, year from teaches where ID='10101');

select count(distinct ID) from takes as TA where exists 
(select * from teaches as TE 
		where TE.ID = '10101'
        and TA.course_id = TE.course_id
        and TA.sec_id = TE.sec_id
        and TA.semester = TE.semester
        and TA.year = TE.year);

select T.course_id from course as T where 
 1< (select count(course_id) from section as R where R.year ='2017' and T.course_id = R.course_id);
 
 select dept_name, avg(salary) as avg_salary from instructor 
	group by dept_name
    having avg_salary > 60000; 
    
select dept_name, avg_salary 
	from (select dept_name, avg(salary)
			from instructor 
            group by dept_name) as T(dept_name,avg_salary)
    where T.avg_salary > 60000;

select max(tot_salary) 
	from (select dept_name, sum(salary) 
			from instructor 
            group by dept_name) as T(dept_name, tot_salary);

select name, salary, avg_salary, dept_name
	from instructor I1, lateral(select avg(salary) as avg_salary
								from instructor I2
                                where I2.dept_name = I1.dept_name) as T;

with max_budget(value) as (select max(budget) from department)
select budget from department, max_budget where department.budget = max_budget.value;

select (select count(*) from teaches)/(select count(*) from instructor) from dual;

delete from instructor where dept_name='Finance';

select dept_name, 
	(select count(*) 
		from instructor 
		where department.dept_name = instructor.dept_name)
	from department;
    
insert into instructor 
	select ID,name, dept_name, 180000
    from student
    where dept_name='Biology' and tot_cred > 110;
insert into student select * from student;
insert into student values('3003', 'Green', 'Finance', null);
update instructor set salary=38000 where ID='98988';
update instructor set salary=salary*1.05 where salary<70000;


update instructor set salary=salary*1.05 where salary<(select avg(salary) from instructor);

with avg_salary(value) as (select avg(salary) from instructor)
update instructor set salary=salary*1.05 where salary<avg_salary.value;

update instructor set salary=case
			when salary <= 100000 then salary*1.05
            else salary * 1.03
            end;
            
update student set tot_cred = (
		select sum(credits) from takes, course
        where student.ID=takes.ID and 
				takes.course_id=course.course_id and
                takes.grade<>'F' and
                takes.grade is not null
        );
update student set tot_cred = (
		select case
				when sum(credits) is not null then sum(credits)
                else 0
                end
        from takes, course
        where student.ID=takes.ID and 
				takes.course_id=course.course_id and
                takes.grade<>'F' and
                takes.grade is not null
        );
select * from student natural left outer join takes
		where course_id is null;       
select name, course_id from student natural join takes;

select name, title from student natural join takes, course
	where takes.course_id = course.course_id;
select name, title from student natural join takes natural join course;
select name, title from (student natural join takes) join course using (course_id);
select * from takes natural left outer join student;
select * from section;
select * from student natural left outer join takes 
union 
select * from student natural right outer join takes;
select * from student left outer join takes using(ID);
select * from student left outer join takes on true
	where student.ID=takes.ID;
create view faculty as 
	select ID, name, dept_name
    from instructor;
select * from faculty;
