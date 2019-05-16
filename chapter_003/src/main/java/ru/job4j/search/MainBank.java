package ru.job4j.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainBank {
    private Map<BankUser, List<BankAccount>> accountList = new HashMap<>();


    public static void main(String[] args) {

    }

    public void addUser(BankUser bankUser) {
        if (accountList.get(bankUser).isEmpty()) {
            accountList.put(bankUser, new ArrayList<>());
        }
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
        List<BankAccount> tmpAccountList = new ArrayList<>();
        for (BankUser bankUser : accountList.keySet()) {
            if (accountList != null && bankUser.getPassport().equalsIgnoreCase(passport)) {
                tmpAccountList = accountList.get(bankUser);
            }
        }
        return tmpAccountList;
    }

    public List<BankAccount> getUserAccountsByReq(String requisites) {
        List<BankAccount> tmpAccountList = new ArrayList<>();
        for (List<BankAccount> bankAccounts : accountList.values()) {
            for (BankAccount bankAccount : bankAccounts) {
                if (bankAccount != null && bankAccount.getRequisites().equalsIgnoreCase(requisites)) {
                    tmpAccountList.add(bankAccount);
                }
            }
        }
        return tmpAccountList;
    }

    private BankAccount getTransferAcc(String srcPassport, String srcRequisite) {
        List<BankAccount> srcAccountList = getUserAccounts(srcPassport);
        BankAccount result = null;
        for (int i = 0; i < srcAccountList.size(); i++) {
            BankAccount tmpAcc = srcAccountList.get(i);
            if (tmpAcc.getRequisites().equalsIgnoreCase(srcRequisite)) {
                result = tmpAcc;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        BankAccount srcAcc = getTransferAcc(srcPassport, srcRequisite);
        if (srcAcc != null && srcAcc.getValue() >= amount) {
            BankAccount destAcc = getTransferAcc(destPassport, dstRequisite);
            if (destAcc != null) {
                srcAcc.setValue(srcAcc.getValue() - amount);
                destAcc.setValue(amount);
                result = true;
            }
        }
        return result;
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
