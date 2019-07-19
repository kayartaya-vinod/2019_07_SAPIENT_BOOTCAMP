-- Command to create a new table
create table employees(
    empid int primary key, -- not null and unique implicitly
    name varchar(50) not null,
    email varchar(100) not null unique,
    phone varchar(15) unique,
    salary double
);

insert into employees (empid, name, email, phone, salary)
values (101, 'Kishore Kumar', 'kishore@example.com', null, 34500);

insert into employees 
values (102, 'Ramesh Rao', 'ramesh@example.com', '9888733145', 31500);

alter table employees
modify salary double default 20000;

-- salary = null
insert into employees
values (103, 'Krishna Kamath', 'kkamath@example.com', null, null);

insert into employees (empid, name, email)
values (104, 'Rajesh Kumar', 'rajeshkumar@example.com');

update employees set
    phone = '9876542345',
    salary = 25000
    where empid = 103;

select * from employees;

-- select <column-list> 
-- [ from <table-list> 
--      [where <condition-list>] 
--      [group by <columns> 
--          [having <conditions>]
--      ]
--      [order by <columns> [asc|desc]]
-- ] 
select * from employees; -- * means all columns
-- select with where condition --> selection
-- select few/specific columns --> projection
-- selecting data from more than one table --> join operation

select * from employees where salary>=30000;
select * from employees where salary<30000;
select * from employees where salary between 25000 and 35000;

select name, email from employees;

