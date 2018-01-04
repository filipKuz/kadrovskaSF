INSERT INTO city (city_name, zip_code) VALUES('Prijedor',79101);
INSERT INTO city (city_name, zip_code) VALUES('Los Angeles',33002);

INSERT INTO work_place (coefficient, name, extra_vacation_days) VALUES(1, 'Work place 1',2);
INSERT INTO work_place (coefficient, name, extra_vacation_days) VALUES(2, 'Work place 2',3);

INSERT INTO professional_qualification (name, qualification_degree) VALUES('Srednja strucna sprema', 'SSS');
INSERT INTO professional_qualification (name, qualification_degree) VALUES('Visoka strucna sprema', 'VSS');
INSERT INTO professional_qualification (name, qualification_degree) VALUES('Osnovna skola', 'II Stepen');
INSERT INTO professional_qualification (name, qualification_degree) VALUES('Magistratura', 'VII-2 Stepen');

INSERT INTO company (name, vat, address, email, phone_number, city_id, is_ours) VALUES ('SF', '0123456789', 'Adress 2', 'firma@gmail.com', '0038165565',2, 1);
INSERT INTO company (name, vat, address, email, phone_number, city_id) VALUES ('Company 2', '0123456789', 'Adress 2', 'firma@gmail.com', '0038165565',1);
INSERT INTO company (name, vat, address, email, phone_number, city_id) VALUES ('Company 3', '0123456789', 'Adress 2', 'firma@gmail.com', '0038165565',1);

INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Ilic', 'Vladimir', 'Sasa', '', '1996-8-20', 'M', 'Address 1',1,1);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Messi', 'Lionel', 'Milenko', '', '1980-8-20', 'M', 'Address 2',1,2);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Ronaldo', 'Cristiano', 'Marko', '', '1982-8-20', 'M', 'Address 3',1,2);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Neymar', 'Junior', 'Sasa', '', '1993-8-20', 'M', 'Address 12',1,1);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Asensio', 'Marco', 'Marko', '', '1980-8-20', 'M', 'Address 22',1,2);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Alves', 'Dani', 'Stefan', '', '1982-8-20', 'M', 'Address 5',1,2);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Lewandowski', 'Robert', 'Mirko', '', '1996-8-20', 'M', 'Address 24',1,1);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Muller', 'Thomas', 'Milos', '', '1980-8-20', 'M', 'Address 23',1,2);
INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address,company_id,city_id) VALUES ('Suarez', 'Luis', 'Janko', '', '1982-8-20', 'M', 'Address 13',1,2);

INSERT INTO annual_holiday_regulation(business_year, num_of_days, employee_id ) VALUES(2018,30,1);
INSERT INTO annual_holiday_regulation(business_year, num_of_days, employee_id ) VALUES(2018,27,2);


INSERT INTO employee_child (name,last_name,birth_date,sex,employee_id) VALUES('Kuzmanovic','Filip','1994-05-14','Z',1);

INSERT INTO employee_professional_qualification (date_of_graduation,educational_institution,profession,pqid,employee_id) VALUES('2010-05-05','FTN','Inzenjer necega',1,1);
INSERT INTO employee_professional_qualification (date_of_graduation,educational_institution,profession,pqid,employee_id) VALUES('2009-05-05','FTN','Arhitekta',4,2);
INSERT INTO employee_professional_qualification (date_of_graduation,educational_institution,profession,pqid,employee_id) VALUES('2009-05-05','FTN','Programer',4,3);

INSERT INTO vacation_request (num_of_days,annual_holiday_regulation_id,str_date,end_date) VALUES(5,1,'2010-05-10','2010-06-10');

INSERT INTO work_history (company_name,start_date,end_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29','2010-05-10',1,1);
INSERT INTO work_history (company_name,start_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29',1,2);
INSERT INTO work_history (company_name,start_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29',2,1);
INSERT INTO work_history (company_name,start_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29',3,1);

INSERT INTO work_history (company_name,start_date,end_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29','2010-05-10',2,2);
INSERT INTO work_history (company_name,start_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29',6,2);
INSERT INTO work_history (company_name,start_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29',4,1);
INSERT INTO work_history (company_name,start_date,employee_id,work_place_id) VALUES('Company 2','1996-05-29',5,1);

INSERT INTO nonworking_day(nonworking_day_description, nonworking_day_date) VALUES('Nova godina', '2018-01-01')
