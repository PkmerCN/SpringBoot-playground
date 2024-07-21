CREATE TABLE employees (
   employee_id INT PRIMARY KEY,
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   email VARCHAR(100),
   phone_number VARCHAR(20),
   hire_date DATE,
   job_id VARCHAR(10),
   salary DECIMAL(10, 2),
   commission_pct DECIMAL(5, 2),
   manager_id INT,
   department_id INT
);

INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES
    (1, 'John', 'Doe', 'john.doe@example.com', '555-1234', '2020-01-01', 'IT_PROG', 4000.00, NULL, 100, 10),
    (2, 'Jane', 'Smith', 'jane.smith@example.com', '555-5678', '2019-03-15', 'IT_PROG', 4500.00, NULL, 101, 20),
    (3, 'Emily', 'Jones', 'emily.jones@example.com', '555-8765', '2021-07-22', 'HR_REP', 4200.00, NULL, 102, 30);



UPDATE employees
SET salary = CASE
     WHEN employee_id = 1 THEN 5000
     WHEN employee_id = 2 THEN 6000
     WHEN employee_id = 3 THEN 7000
     ELSE salary
 END
WHERE employee_id IN (1, 2, 3);
