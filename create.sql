create table city (city_id bigint not null auto_increment, city_name varchar(255) not null, zip_code integer not null, primary key (city_id))
create table company (company_id bigint not null auto_increment, address varchar(255), email varchar(255), name varchar(255) not null, phone_number varchar(255), vat bigint not null, city_id bigint, primary key (company_id))
create table employee (employee_id bigint not null auto_increment, address varchar(255) not null, birth_date date, email varchar(255), first_name varchar(255), last_name varchar(255), maden_name varchar(255), number_of_vacation_days_left integer, parent_name varchar(255), phone_number varchar(255), sex varchar(255), city_id bigint, company_id bigint, primary key (employee_id))
create table employee_child (employee_child_id bigint not null auto_increment, birth_date date not null, last_name varchar(255) not null, name varchar(255) not null, sex varchar(255) not null, employee_id bigint, primary key (employee_child_id))
create table employee_professional_qualification (epqid bigint not null auto_increment, date_of_graduation date not null, educational_institution varchar(255) not null, profession varchar(255) not null, employee_id bigint, pqid bigint, primary key (epqid))
create table professional_qualification (pqid bigint not null auto_increment, name varchar(255) not null, qualification_degree varchar(255) not null, primary key (pqid))
create table vacation_request (vrid bigint not null auto_increment, approved bit not null, num_of_days integer not null, employee_id bigint, primary key (vrid))
create table work_history (whid bigint not null auto_increment, end_date date, previous_company varchar(255), start_date date not null, employee_id bigint, wpid bigint, primary key (whid))
create table work_place (wpid bigint not null auto_increment, coefficient double precision not null, name varchar(255) not null, primary key (wpid))
alter table company add constraint FK11ll1ewpdxjg9bm3jtg858qn8 foreign key (city_id) references city (city_id)
alter table employee add constraint FK289qfli0oe8ae3qcuafi4q3tf foreign key (city_id) references city (city_id)
alter table employee add constraint FK5v50ed2bjh60n1gc7ifuxmgf4 foreign key (company_id) references company (company_id)
alter table employee_child add constraint FKj8ebgo9jjhrs1fgr5moy3a5i3 foreign key (employee_id) references employee (employee_id)
alter table employee_professional_qualification add constraint FKn2s71tsrmg1oxwhco4r9iuong foreign key (employee_id) references employee (employee_id)
alter table employee_professional_qualification add constraint FKrmkknf3mbh2rysop8u5jvd21c foreign key (pqid) references professional_qualification (pqid)
alter table vacation_request add constraint FKg33enciyxv9dbwdajxeyp1eh3 foreign key (employee_id) references employee (employee_id)
alter table work_history add constraint FK15x6d9ck2h75t4xhx0dabqkn foreign key (employee_id) references employee (employee_id)
alter table work_history add constraint FKaq9u1frn7o8iwt47830jkja2h foreign key (wpid) references work_place (wpid)