package ru.job4j.Bank;

import java.util.*;


public class Main {
    HashMap<User, List<Account>> deposit = new HashMap<User, List<Account>>();

    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        deposit.putIfAbsent(user, list);
    }
    public void deleteUser(User user) {
        deposit.remove(user);
    }
    public void addAccountToUser(String passport, Account account) {
        for (User user : deposit.keySet()) {
            if (user.getPassport().equals(passport)) {
                deposit.get(user).add(account);
            }
        }
    }
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : deposit.keySet()) {
            if (user.getPassport().equals(passport)) {
                deposit.get(user).remove(account);
            }
        }
    }
    public List<Account> getUserAccounts (String passport) {
        List<Account> list = new ArrayList<>();
        for (User user : deposit.keySet()) {
            if (user.getPassport().equals(passport)) {
                list = deposit.get(user);
            }
        }
        return list;
    }
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        User srcUser = null;
        User destUser = null;
        int srcIndex = 0;
        int destIndex = 0;
        for (User user : deposit.keySet()) {
            if (user.getPassport().equals(srcPassport)) {
                srcUser = user;
            }
            if (user.getPassport().equals(destPassport)) {
                destUser = user;
            }
        }
        for (int i = 0; i < deposit.get(srcUser).size(); i++) {
            if (deposit.get(srcUser).get(i).getRequisites().equals(srcRequisite)) {
                srcIndex = i;
            }
        }
        for (int i = 0; i < deposit.get(destUser).size(); i++) {
            if (deposit.get(destUser).get(i).getRequisites().equals(destRequisite)) {
                destIndex = i;
            }
        }
        if (deposit.get(srcUser).get(srcIndex).getValue() > amount) {
            deposit.get(srcUser).get(srcIndex).setValue(deposit.get(srcUser).get(srcIndex).getValue() - amount);
            deposit.get(destUser).get(destIndex).setValue(deposit.get(destUser).get(destIndex).getValue() + amount);
            result = true;
        }
        return result;
    }
}
