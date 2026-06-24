CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN

    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Insufficient balance in Account ' || p_from_account);
    ELSE
    
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;
 
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('--- Fund Transfer Successful ---');
        DBMS_OUTPUT.PUT_LINE('Transferred: $' || p_amount);
        DBMS_OUTPUT.PUT_LINE('From Account: ' || p_from_account || ' | To Account: ' || p_to_account);
 
        FOR rec IN (SELECT AccountID, CustomerName, Balance FROM Accounts 
                    WHERE AccountID IN (p_from_account, p_to_account)) LOOP
            DBMS_OUTPUT.PUT_LINE('Account ' || rec.AccountID || ' -> ' || 
                                 rec.CustomerName || ' | Balance: $' || rec.Balance);
        END LOOP;

        DBMS_OUTPUT.PUT_LINE('--- Transfer Complete ---');
    END IF;
END;
/
 
SET SERVEROUTPUT ON;
EXEC TransferFunds(1, 2, 5000);