package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankTest {
    @Test
    public void whenAddUserThenFind() {
        Main main = new Main();
        User user = new User("Juk", "1234");
        main.addUser(user);
        assertThat(main.deposit.containsKey(user), is(true));
    }
    @Test
    public void whenAddThenDelete() {
        Main main = new Main();
        User user = new User("Juk", "1234");
        main.addUser(user);
        main.deleteUser(user);
        assertThat(main.deposit.containsKey(user), is(false));
    }
    @Test
    public void whenAddAccountGetValue() {
        Main main = new Main();
        User user = new User("Juk", "1234");
        Account account = new Account(555.55, "555332");
        main.addUser(user);
        main.addAccountToUser("1234", account);
        assertThat(main.deposit.get(user).get(0).getValue(), is(555.55));
    }
    @Test
    public void whenAddTwoThenDelete() {
        Main main = new Main();
        User user = new User("Juk", "1234");
        Account account1 = new Account(555.55, "555332");
        Account account2 = new Account(123.0, "8907");
        main.addUser(user);
        main.addAccountToUser("1234", account1);
        main.addAccountToUser("1234", account2);
        main.deleteAccountFromUser("1234", account1);
        assertThat(main.deposit.get(user).get(0).getValue(), is(123.0));
    }
    @Test
    public void whenGetAccount() {
        Main main = new Main();
        User user = new User("Juk", "1234");
        Account account1 = new Account(555.55, "555332");
        Account account2 = new Account(123.0, "8907");
        main.addUser(user);
        main.addAccountToUser("1234", account1);
        main.addAccountToUser("1234", account2);
        List<Account> result = main.getUserAccounts("1234");
        assertThat(result.size(), is(2));
    }
    @Test
    public void whenTransferTrue() {
        Main main = new Main();
        User user1 = new User("Juk", "1234");
        User user2 = new User("Pauk", "4321");
        Account account1 = new Account(555.55, "555332");
        Account account2 = new Account(123.0, "8907");
        Account account3 = new Account(888.55, "1234");
        Account account4 = new Account(100.0, "4321");
        main.addUser(user1);
        main.addUser(user2);
        main.addAccountToUser("1234", account1);
        main.addAccountToUser("1234", account2);
        main.addAccountToUser("4321", account3);
        main.addAccountToUser("4321", account4);
        boolean result = main.transferMoney("1234", "8907", "4321", "1234", 12.0);
        assertThat(result, is(true));
    }
    @Test
    public void whenTransferFalse() {
        Main main = new Main();
        User user1 = new User("Juk", "1234");
        User user2 = new User("Pauk", "4321");
        Account account1 = new Account(555.55, "555332");
        Account account2 = new Account(123.0, "8907");
        Account account3 = new Account(888.55, "1234");
        Account account4 = new Account(100.0, "4321");
        main.addUser(user1);
        main.addUser(user2);
        main.addAccountToUser("1234", account1);
        main.addAccountToUser("1234", account2);
        main.addAccountToUser("4321", account3);
        main.addAccountToUser("4321", account4);
        boolean result = main.transferMoney("1234", "8907", "4321", "1234", 9000.00);
        assertThat(result, is(false));
    }
}
