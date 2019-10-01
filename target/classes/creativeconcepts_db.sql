-- Project 1: TRMS Creative Concepts database
-- Leah Medina
--set schema 'creativeconcepts';
set schema 'public';

--drop table employee;
--drop table reimburesment_form;
--drop table role;
--drop table role_employee_jt;
--drop table document;
--drop table event;
--drop table reimbursement_form_event_jt;
--drop table reimbursement_form_document_jt;

--Creating tables
CREATE TABLE employee(
  	id_employee serial PRIMARY KEY,
  	fname varchar (50),
  	lname varchar (50),
   	username varchar (50),
   	password varchar (50),
   	available numeric(8,2),
  	pending numeric(8,2),
  	awarded numeric(8,2)
);

CREATE TABLE event(
  	id_event serial PRIMARY KEY,
  	coverage_name varchar (50),
  	percentage int
);

CREATE TABLE reimbursement_form(
  	id_reimbursement_form serial PRIMARY KEY,
  	campus varchar (50),
  	date_received date NOT NULL DEFAULT CURRENT_DATE,
  	grading_format varchar (50),
   	reason varchar (500),
   	description varchar (500),
   	cost numeric,
   	supporting_document bytea,
   	timeOfAbsence_FROM date,
   	timeOfAbsence_TO date,
   	exceeding_funds boolean,
   	urgent boolean,
   	approved_by_sup boolean,
   	approved_by_dh boolean,
   	approved_by_benco boolean,
   	event_type varchar (50),
   	username varchar (50),
);

CREATE TABLE form(
  	id_reimbursement_form serial PRIMARY KEY,
  	campus varchar (50),
  	date_received date NOT NULL DEFAULT CURRENT_DATE,
  	grading_format varchar (50),
   	reason varchar (500),
   	description varchar (500),
   	cost numeric,
   	supporting_document bytea,
   	timeOfAbsence_FROM date,
   	timeOfAbsence_TO date,
   	exceeding_funds boolean,
   	urgent boolean,
   	approved_by_sup int,
   	approved_by_dh int,
   	approved_by_benco int,
   	event_type varchar (50),
   	username varchar (50)
);

insert into form values(default, 'UTA, TX', '2019-09-17', 'Passed', 'Certification', 'Java Cert.', 250.00, null, '2019-10-01', '2019-10-07', false, true, 0, 0, 0,'Certification', 'emp_username');
insert into form values(default, 'UTA, TX', '2019-09-16', 'Failed', 'Certification', 'AWS Cert.', 100.00, null, '2019-08-20', '2019-10-27', false, false, 0, 0, 0,'Certification', 'emp_username');
insert into form values(default, 'Tampa, FL', '2019-09-17', 'Passed', 'Certification', 'Direct Head Seminar', 50.00, null, '2019-08-20', '2019-10-27', false, false, 0, 0, 0,'Seminar', 'dh_username');
insert into form values(default, 'New York, NY', '2019-01-21', 'Failed', 'Technical Training', 'Servlets & Angular', 500.00, null, '2019-10-20', '2019-11-27', false, false, 0, 0, 0,'Technical Training', 'super_username');

select * from form;
--delete from form where id_reimbursement_form = 1;

CREATE TABLE reimbursement_form_event_jt(
  	fk_id_reimbursement_form int REFERENCES reimbursement_form(id_reimbursement_form) not null,
  	fk_id_event int REFERENCES event(id_event) not null
);

CREATE TABLE document(
  	id_document serial PRIMARY KEY,
  	document_type varchar (50),
  	document_upload bytea,
  	approved boolean
);

CREATE TABLE reimbursement_form_document_jt(
  	fk_id_reimbursement_form int REFERENCES reimbursement_form(id_reimbursement_form) not null,
  	fk_id_document int REFERENCES document(id_document) not null
);

CREATE TABLE role(
  	id_role serial PRIMARY KEY,
  	role_type varchar (50)
);

CREATE TABLE role_employee_jt(
  	id_role_employee_jt serial PRIMARY KEY,
  	fk_id_role int REFERENCES role(id_role) not null,
  	fk_id_employee int REFERENCES employee(id_employee) not null
);

select * from employee;
select *from event;
select * from reimbursement_form;
select * from reimbursement_form_event_jt;
select * from document;
select * from reimbursement_form_document_jt;
select * from role;
select * from role_employee_jt;

-- populating employee table with employees of creative concepts
insert into employee values(default, 'Kayla', 'Tate', 'emp_username', 'password', 1000.00, 0.00, 0.00);
insert into employee values(default, 'Paco', 'Abrazado', 'super_username', 'password', 1000.00, 0.00, 0.00);
insert into employee values(default, 'Stuart', 'Hurley', 'directhead_username', 'password', 1000.00, 0.00, 0.00);
insert into employee values(default, 'Janina', 'Medina', 'benco_username', 'password', 1000.00, 0.00, 0.00);

-- populating role table with positions
insert into role values(default, 'Regular-Employee');
insert into role values(default, 'Supervisor');
insert into role values(default, 'Direct-Head');
insert into role values(default, 'Benifits-Coordinator');

-- assigning concrete roles to the 4 employees
insert into role_employee_jt values(default, 1, 1);
insert into role_employee_jt values(default, 2, 2);
insert into role_employee_jt values(default, 3, 3);
insert into role_employee_jt values(default, 4, 4);

-- populating pre-filled reimbursement forms
insert into reimbursement_form values(default, 'UTA, TX', '2019-09-17', 'Passed', 'Certification', 'Java Cert.', 250.00, null, '2019-10-01', '2019-10-07', false, true, false, false, false,'Certification', 'emp_username');
insert into reimbursement_form values(default, 'UTA, TX', '2019-09-16', 'Failed', 'Certification', 'AWS Cert.', 100.00, null, '2019-08-20', '2019-10-27', false, false, false, false, false,'Certification', 'emp_username');
insert into reimbursement_form values(default, 'Tampa, FL', '2019-09-17', 'Passed', 'Certification', 'Direct Head Seminar', 50.00, null, '2019-08-20', '2019-10-27', false, false, false, false, false,'Seminar', 'dh_username');
insert into reimbursement_form values(default, 'New York, NY', '2019-01-21', 'Failed', 'Technical Training', 'Servlets & Angular', 500.00, null, '2019-10-20', '2019-11-27', false, false, false, false, false,'Technical Training', 'super_username');

-- assigning concrete event types
insert into event values(default, 'Certification', 100);
insert into event values(default, 'Technical Training', 90);
insert into event values(default, 'University Course', 80);
insert into event values(default, 'Certification Preparation Class', 75);
insert into event values(default, 'Seminar', 60);
insert into event values(default, 'Other', 30);

-- assigning concrete roles to the 4 employees
insert into reimbursement_form_event_jt values(1, 1);
insert into reimbursement_form_event_jt values(1, 1);
insert into reimbursement_form_event_jt values(2, 1);