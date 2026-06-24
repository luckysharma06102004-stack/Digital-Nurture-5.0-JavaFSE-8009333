-- scenario3.sql
SET SERVEROUTPUT ON;

DECLARE
    v_days_left NUMBER;
BEGIN
    FOR rec IN (
        SELECT c.CustomerName, c.Email,
               l.LoanID, l.LoanAmount, l.DueDate
        FROM   Loans l
        JOIN   Customers c ON l.CustomerID = c.CustomerID
        WHERE  l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
        ORDER  BY l.DueDate ASC
    )
    LOOP
        v_days_left := TRUNC(rec.DueDate - SYSDATE);

        DBMS_OUTPUT.PUT_LINE('*** PAYMENT REMINDER ***');
        DBMS_OUTPUT.PUT_LINE('Customer  : ' || rec.CustomerName);
        DBMS_OUTPUT.PUT_LINE('Email     : ' || rec.Email);
        DBMS_OUTPUT.PUT_LINE('Loan ID   : ' || rec.LoanID);
        DBMS_OUTPUT.PUT_LINE('Amount Due: $' || TO_CHAR(rec.LoanAmount, '99,99,999.00'));
        DBMS_OUTPUT.PUT_LINE('Due Date  : ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Days Left : ' || v_days_left || ' days');
        DBMS_OUTPUT.PUT_LINE('----------------------------');
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('--- Reminder Processing Complete ---');
END;
/