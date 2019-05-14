package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainBank {
    private Map<BankUser, List<BankAccount>> accountList;


    public static void main(String[] args) {

    }

    public void addUser(BankUser bankUser) {
        accountList.put(bankUser, new ArrayList<>());
    }

    public void deleteUser(BankUser bankUser) {

        if (accountList.remove(bankUser, null)) {
            deleteAccountsOfUser(bankUser);
            System.out.println("User deleted.");
        }
    }

    public boolean deleteAccountsOfUser(BankUser bankUser) {
        boolean result = true;
        result = accountList.remove(bankUser, accountList.get(bankUser));
        return result;
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
        for (BankUser bankUser : accountList.keySet()) {
            if (accountList != null && bankUser.getPassport().equalsIgnoreCase(passport)) {
                tmpAccountList = accountList.get(bankUser);
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
