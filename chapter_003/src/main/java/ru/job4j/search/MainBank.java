package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainBank {
    private ArrayList<BankUser> bankUsers;
    private UserAccountList userAccountList;

    public static void main(String[] args) {

    }

    public void addUser(BankUser bankUser) {
        bankUsers.add(bankUser);
    }

    public void deleteUser(BankUser bankUser) {
        if (bankUsers.remove(bankUser)) {
            userAccountList.deleteAccountsOfUser(bankUser);
            System.out.println("User deleted.");
        }
    }

    public void addAccountToUser(String passport, BankAccount account) {
        List<BankAccount> tmpAccountList = getUserAccounts(passport);
        tmpAccountList.add(account);
    }

    public void deleteAccountFromUser(String passport, BankAccount account) {
        List<BankAccount> tmpAccountList = getUserAccounts(passport);
        tmpAccountList.remove(account);
    }

    public List<BankAccount> getUserAccounts(String passport) {
        List<BankAccount> tmpAccountList = null;
        for (BankUser bankUser : bankUsers) {
            if (userAccountList != null && bankUser.getPassport().equalsIgnoreCase(passport)) {
                tmpAccountList = userAccountList.getAccountList().get(bankUser);
            }
        }
        return tmpAccountList;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean from = false;
        boolean to = false;
        BankAccount srcAcc;
        List<BankAccount> srcAccountList = getUserAccounts(srcPassport);
        for (int i = 0; i < srcAccountList.size(); i++) {
            BankAccount tmpAcc = srcAccountList.get(i);
            if (tmpAcc.getRequisites().equalsIgnoreCase(srcRequisite)
                    && tmpAcc.getValue() >= amount) {
                tmpAcc.setValue(tmpAcc.getValue() - amount);
                srcAcc = tmpAcc;
                from = true;
            }
        }


        srcAccountList = getUserAccounts(destPassport);
        for (int i = 0; i < srcAccountList.size(); i++) {
            BankAccount tmpAcc = srcAccountList.get(i);
            if (tmpAcc.getRequisites().equalsIgnoreCase(dstRequisite)) {
                tmpAcc.setValue(amount);
                to = true;
            }
        }

        return from & to;
    }

}
