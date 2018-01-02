create table annual_holiday_regulation (annual_holiday_regulation_id bigint not null auto_increment, business_year integer not null, num_of_days integer not null, employee_id bigint, primary key (annual_holiday_regulation_id))
create table city (city_id bigint not null auto_increment, city_name VARCHAR(30) not null, zip_code integer not null, primary key (city_id))
create table company (company_id bigint not null auto_increment, address VARCHAR(30), email VARCHAR(30), is_ours tinyint(1) default 0 not null, name VARCHAR(30) not null, phone_number VARCHAR(15), vat bigint not null, city_id bigint not null, primary key (company_id))
create table employee (employee_id bigint not null auto_increment, address VARCHAR(30) not null, birth_date date not null, email VARCHAR(30), first_name VARCHAR(30) not null, last_name VARCHAR(30) not null, maden_name VARCHAR(30), parent_name VARCHAR(30) not null, phone_number VARCHAR(15), sex VARCHAR(6) not null, city_id bigint not null, company_id bigint, primary key (employee_id))
create table employee_child (employee_child_id bigint not null auto_increment, birth_date date not null, last_name VARCHAR(30) not null, name VARCHAR(30) not null, sex VARCHAR(6) not null, employee_id bigint, primary key (employee_child_id))
create table employee_professional_qualification (epqid bigint not null auto_increment, date_of_graduation date not null, educational_institution VARCHAR(30) not null, profession VARCHAR(30) not null, employee_id bigint not null, pqid bigint not null, primary key (epqid))
create table nonworking_day (non_working_day_id bigint not null auto_increment, date date not null, description VARCHAR(30) not null, primary key (non_working_day_id))
create table professional_qualification (pqid bigint not null auto_increment, name VARCHAR(30) not null, qualification_degree VARCHAR(30) not null, primary key (pqid))
create table vacation_request (vrid bigint not null auto_increment, end_date date not null, num_of_days integer not null, str_date date not null, annual_holiday_regulation_id bigint, primary key (vrid))
create table work_history (work_history_id bigint not null auto_increment, company_name VARCHAR(30), end_date date, start_date date not null, employee_id bigint, work_place_id bigint, primary key (work_history_id))
create table work_place (work_place_id bigint not null auto_increment, coefficient double precision not null, extra_vacation_days integer, name VARCHAR(30) not null, primary key (work_place_id))
alter table annual_holiday_regulation add constraint FKpyamr0vjp5371ijsrpfnrsp02 foreign key (employee_id) references employee (employee_id)
alter table company add constraint FK11ll1ewpdxjg9bm3jtg858qn8 foreign key (city_id) references city (city_id)
alter table employee add constraint FK289qfli0oe8ae3qcuafi4q3tf foreign key (city_id) references city (city_id)
alter table employee add constraint FK5v50ed2bjh60n1gc7ifuxmgf4 foreign key (company_id) references company (company_id)
alter table employee_child add constraint FKj8ebgo9jjhrs1fgr5moy3a5i3 foreign key (employee_id) references employee (employee_id)
alter table employee_professional_qualification add constraint FKn2s71tsrmg1oxwhco4r9iuong foreign key (employee_id) references employee (employee_id)
alter table employee_professional_qualification add constraint FKrmkknf3mbh2rysop8u5jvd21c foreign key (pqid) references professional_qualification (pqid)
alter table vacation_request add constraint FK80lf7yu9jwb6p5lb8n9b3fy6y foreign key (annual_holiday_regulation_id) references annual_holiday_regulation (annual_holiday_regulation_id)
alter table work_history add constraint FK15x6d9ck2h75t4xhx0dabqkn foreign key (employee_id) references employee (employee_id)
alter table work_history add constraint FK8i4p9akikkm84jvw0wnl8widi foreign key (work_place_id) references work_place (work_place_id)
