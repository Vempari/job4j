package ru.job4j.bank;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.*;

public class Main {
    HashMap<User, List<Account>> deposit = new HashMap<User, List<Account>>();

    public void addUser(User user) {
        ArrayList<Account> list = new ArrayList<>();
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
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (User user : deposit.keySet()) {
            if (user.getPassport().equals(passport)) {
                list = deposit.get(user);
            }
        }
        return list;
    }
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        User srcUser = findUser(srcPassport);
        User destUser = findUser(destPassport);
        int srcIndex = findIndex(srcRequisite, srcUser);
        int destIndex = findIndex(destRequisite, destUser);
        if (deposit.get(srcUser).get(srcIndex).getValue() > amount) {
            deposit.get(srcUser).get(srcIndex).setValue(deposit.get(srcUser).get(srcIndex).getValue() - amount);
            deposit.get(destUser).get(destIndex).setValue(deposit.get(destUser).get(destIndex).getValue() + amount);
            result = true;
        }
        return result;
    }
    public User findUser(String passport) {
        User result = null;
        for (User user : deposit.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }
    public int findIndex(String requisites, User user) {
        int result = 0;
        for (int i = 0; i < deposit.get(user).size(); i++) {
            if (deposit.get(user).get(i).getRequisites().equals(requisites)) {
                result = i;
            }
        }
        return result;
    }
}
