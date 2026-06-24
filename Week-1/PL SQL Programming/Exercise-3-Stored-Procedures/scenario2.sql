-- Create Employees table (run once)
CREATE TABLE Employees (
    EmployeeID   NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    Department   VARCHAR2(50),
    Salary       NUMBER(10,2)
);

INSERT INTO Employees VALUES (1, 'Ramesh Patel',  'IT',      50000);
INSERT INTO Employees VALUES (2, 'Sunita Sharma', 'HR',      40000);
INSERT INTO Employees VALUES (3, 'Arvind Mehta',  'IT',      60000);
INSERT INTO Employees VALUES (4, 'Priya Singh',   'Finance', 45000);
COMMIT;

-- Stored Procedure
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department  IN VARCHAR2,
    p_bonus_pct   IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('--- Bonus Applied to ' || p_department || ' Department ---');

    FOR rec IN (SELECT EmployeeName, Salary FROM Employees WHERE Department = p_department) LOOP
        DBMS_OUTPUT.PUT_LINE('Updated -> ' || rec.EmployeeName || ' | New Salary: $' || rec.Salary);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('--- Bonus Processing Complete ---');
END;
/

-- Execute (IT department, 10% bonus)
SET SERVEROUTPUT ON;
EXEC UpdateEmployeeBonus('IT', 10);