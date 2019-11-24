SET FOREIGN_KEY_CHECKS=0;

-- source 

-- Table structure for `t_employee`
drop table if exists t_employee;
create table t_employee(
id int not null auto_increment,
no varchar(30) unique,
name varchar(30),
gender varchar(30),
post varchar(30),
entryTime datetime,
tel varchar(30),
primary key(id)
);


insert into t_employee(id,no,name,gender,post,entryTime,tel) values(1,'TZ001','李强','男','初级销售员','2012-09-11','13822118289');

insert into t_employee(id,no,name,gender,post,entryTime,tel) values(2,'TZ002','刘晗','女','中级销售员','2011-04-22','15877665552');

insert into t_employee(id,no,name,gender,post,entryTime,tel) values(3,'TZ003','林欣','女','高级销售员','2009-10-14','18657722987');

insert into t_employee(id,no,name,gender,post,entryTime,tel) values(4,'TZ004','赵海','男','部门经理','2009-01-15','15188090091');


-- Table structure for `t_salary`
drop table if exists t_salary;
create table t_salary(
id int not null auto_increment,
employee_no varchar(30),
salary_date dateTime,
salary int,
sales int,
primary key(id)

);

-- foreign key(employee_no) references t_employee(no)

insert into t_salary (id,employee_no,salary_date,salary,sales) values(1,'TZ001','2013-06-10',3000,20000); 

insert into t_salary (id,employee_no,salary_date,salary,sales) values(2,'TZ001','2013-07-10',3000,35000); 

insert into t_salary (id,employee_no,salary_date,salary,sales) values(3,'TZ001','2013-08-10',3000,39000); 