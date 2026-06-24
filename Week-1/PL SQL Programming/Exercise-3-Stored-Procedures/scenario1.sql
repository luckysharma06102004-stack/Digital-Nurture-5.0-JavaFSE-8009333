-- Create Accounts table (run once)
CREATE TABLE Accounts (
    AccountID   NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    AccountType VARCHAR2(20),
    Balance     NUMBER(10,2)
);

INSERT INTO Accounts VALUES (1, 'Ramesh Patel',  'Savings', 15000);
INSERT INTO Accounts VALUES (2, 'Sunita Sharma', 'Savings', 8000);
INSERT INTO Accounts VALUES (3, 'Arvind Mehta',  'Savings', 12000);
INSERT INTO Accounts VALUES (4, 'Priya Singh',   'Current', 3000);
COMMIT;

-- Stored Procedure
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('--- Monthly Interest Applied ---');

    FOR rec IN (SELECT CustomerName, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        DBMS_OUTPUT.PUT_LINE('Updated -> ' || rec.CustomerName || ' | New Balance: $' || rec.Balance);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('--- Processing Complete ---');
END;
/

-- Execute
SET SERVEROUTPUT ON;
EXEC ProcessMonthlyInterest;