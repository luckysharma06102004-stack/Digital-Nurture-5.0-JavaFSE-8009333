-- scenario1.sql
SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, c.CustomerName, c.DOB,
               l.LoanID, l.InterestRate
        FROM   Customers c
        JOIN   Loans l ON c.CustomerID = l.CustomerID;

    v_age NUMBER;
BEGIN
    FOR rec IN c_customers LOOP

        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET    InterestRate = InterestRate - 1
            WHERE  LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount Applied -> ' || rec.CustomerName ||
                ' | Age: '            || v_age            ||
                ' | New Rate: '       || (rec.InterestRate - 1) || '%'
            );
        ELSE
            DBMS_OUTPUT.PUT_LINE(
                'No Change -> ' || rec.CustomerName ||
                ' | Age: '      || v_age
            );
        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('--- Senior Discount Processing Complete ---');
END;
/