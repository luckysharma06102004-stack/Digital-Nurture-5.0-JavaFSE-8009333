-- scenario2.sql
SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, CustomerName, Balance
        FROM   Customers;
BEGIN
    FOR rec IN c_customers LOOP

        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET    IsVIP = 'TRUE'
            WHERE  CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'VIP Promoted  -> ' || rec.CustomerName ||
                ' | Balance: $'     || rec.Balance
            );
        ELSE
            DBMS_OUTPUT.PUT_LINE(
                'Not Eligible  -> ' || rec.CustomerName ||
                ' | Balance: $'     || rec.Balance
            );
        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('--- VIP Status Update Complete ---');
END;
/