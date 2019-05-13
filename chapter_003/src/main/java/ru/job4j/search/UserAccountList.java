package ru.job4j.search;

import java.util.List;
import java.util.Map;

public class UserAccountList {
    private Map<BankUser, List<BankAccount>> accountList;
    private BankUser bankUser;

    public UserAccountList(Map<BankUser, List<BankAccount>> accountList, BankUser bankUser) {
        this.accountList = accountList;
        this.bankUser = bankUser;
    }

    public Map<BankUser, List<BankAccount>> getAccountList() {
        return accountList;
    }

    public void setAccountList(Map<BankUser, List<BankAccount>> accountList) {
        this.accountList = accountList;
    }

    public BankUser getBankUser() {
        return bankUser;
    }

    public void setBankUser(BankUser bankUser) {
        this.bankUser = bankUser;
    }

    public boolean deleteAccountsOfUser(BankUser bankUser) {
        boolean result = true;
        result = accountList.remove(bankUser, accountList.get(bankUser));
        return result;
    }


}
