package ui;

import expense.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testAccount {

    Account moneyAccount;
    Account noMoneyAccount;

    @BeforeEach
    public void runBefore() {
        moneyAccount = new Account(324,1200, "reddit");
        noMoneyAccount = new Account(82, 0,"bronze");
    }

    @Test
    public void testPassword() {
        assertEquals(moneyAccount.accessAccount("reddit") ,1200);
        assertEquals(moneyAccount.accessAccount("bro") ,0);
    }


}
