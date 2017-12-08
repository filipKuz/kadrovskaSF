INSERT INTO city (city_name, zip_code) VALUES('Prijedor',79101);

INSERT INTO work_place (coefficient, name) VALUES(1, 'Work place 1');

INSERT INTO professional_qualification (name, qualification_degree) VALUES('Srednja strucna sprema', 'SSS');

INSERT INTO company (name, vat, address, email, phone_number, city_id) VALUES ('Company 1', '0123456789', 'Adress 2', 'firma@gmail.com', '0038165565',1);

INSERT INTO employee (last_name, first_name, parent_name, maden_name, birth_date, sex, address, number_of_vacation_days_left,company_id,city_id) VALUES ('Ilic', 'Vladimir', 'Sasa', '', '1996-08-20', 'M', 'Address 1', 15,1,1);

INSERT INTO employee_child (name,last_name,birth_date,sex,employee_id) VALUES('Kuzmanovic','Filip','1994-05-14','Z',1);

INSERT INTO employee_professional_qualification (date_of_graduation,educational_institution,profession,pqid,employee_id) VALUES('2010-05-05','FTN','Inzinjer necega',1,1);

INSERT INTO vacation_request (num_of_days,approved,employee_id) VALUES(5,true,1);

INSERT INTO work_history (previous_company,start_date,end_date,employee_id,wpid) VALUES('Company 2','1996-05-29','2010-05-10',1,1);

