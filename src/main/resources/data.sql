

INSERT INTO department
	(depart_code, dept_name)
VALUES
	('D101','DEPT1'),
	('D102','DEPT2'),
	('D103','DEPT3'),
	('D104','DEPT4'),
	('D105','DEPT5');


INSERT INTO project
    (proj_code, project_name)
VALUES
    ('P1001', 'Project1'),
    ('P1002', 'Project2'),
    ('P1003', 'Project3'),
    ('P1004', 'Project4'),
    ('P1005', 'Project5');
    
INSERT INTO department_project
	(depart_code, proj_code)
VALUES
	('D101','P1001'),
	('D102','P1001'),
	('D101','P1002'),
	('D102','P1002'),
	('D103','P1003'),
	('D104','P1004'),
	('D105','P1005');

INSERT INTO employee 
	(emp_code,name,salary)
VALUES
	('E10001','EMPLOYEE-1',10000),
	('E10002','EMPLOYEE-2',20000),
	('E10003','EMPLOYEE-3',30000),
	('E10004','EMPLOYEE-4',40000),
	('E10005','EMPLOYEE-5',50000);


INSERT INTO employee_department
	(emp_code, depart_code)
VALUES
	('E10001','D101'),
	('E10002','D101'),
	('E10002','D102'),
	('E10003','D103'),
	('E10003','D102'),
	('E10004','D101'),
	('E10005','D102');


INSERT INTO employee_project
	(emp_code, proj_code)
VALUES
	('E10001','P1001'),
	('E10002','P1001'),
	('E10002','P1002'),
	('E10003','P1003'),
	('E10003','P1001'),
	('E10004','P1001'),
	('E10005','P1002');
    