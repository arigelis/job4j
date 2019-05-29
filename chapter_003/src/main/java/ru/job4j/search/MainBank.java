package ru.job4j.search;

//import sun.security.pkcs11.wrapper.Functions;

import java.util.*;
import java.util.stream.Collectors;

public class MainBank {
    private Map<BankUser, List<BankAccount>> accountList = new HashMap<BankUser, List<BankAccount>>();

    public static void main(String[] args) {

    }

    public void addUser(BankUser bankUser) {
        if (accountList.get(bankUser).isEmpty()) {
            accountList.put(bankUser, new ArrayList<BankAccount>());
        }
    }

    public void deleteUser(BankUser bankUser) {
//        accountList = Stream.of(accountList).filter(e -> !e.equals(bankUser))
//                .collect(Collectors.toMap(Functions.identity(), s->s));
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

    public List<BankAccount> getUserAccounts(final String passport) {
//        List<BankAccount> tmpAccountList = new ArrayList<BankAccount>();
//        for (BankUser bankUser : accountList.keySet()) {
//            if (accountList != null && bankUser.getPassport().equalsIgnoreCase(passport)) {
//                tmpAccountList = accountList.get(bankUser);
//            }
//        }
//        return tmpAccountList;
        return this.accountList.entrySet().stream()
                .filter(e -> e.getKey().getPassport().equalsIgnoreCase(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>());
    }

    public List<BankAccount> getUserAccountsByReq(String requisites) {
        List<BankAccount> tmpAccountList = new ArrayList<BankAccount>();
        for (List<BankAccount> bankAccounts : accountList.values()) {
            for (BankAccount bankAccount : bankAccounts) {
                if (bankAccount != null && bankAccount.getRequisites().equalsIgnoreCase(requisites)) {
                    tmpAccountList.add(bankAccount);
                }
            }
        }
//        return tmpAccountList;

//        return this.accountList.entrySet().stream()
//       //V1     .map(Map.Entry::getValue)
//                .forEach(z -> z.stream().filter(v -> v.getRequisites().equalsIgnoreCase(requisites)).findFirst()
//                        .orElse(new ArrayList<BankAccount>());//map(Map.Entry::getValue));

//     //V2   return this.accountList.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList()).forEach(v -> v.stream()
//                .filter(q -> q.getRequisites().equalsIgnoreCase(requisites)).findFirst());


//    //V3    return this.accountList.entrySet().stream()
//                .forEach(e->e.getValue().stream().filter(z->z.getRequisites().equalsIgnoreCase(requisites)))
//                .=================;
        return this.accountList.entrySet().stream()
                .map(u -> accountList.get(u).stream()
                        .filter(a -> a.getRequisites().equals(requisites))
                        .findFirst()
                        .orElse(null)).collect(Collectors.toList());
    }

    private BankAccount getTransferAcc(String srcPassport, String srcRequisite) {
        return this.accountList.keySet().stream()
                .filter(u -> u.getPassport().equals(srcPassport))
                .findFirst()
                .map(u -> accountList.get(u).stream()
                        .filter(a -> a.getRequisites().equals(srcRequisite))
                        .findFirst()
                        .orElse(null))
                .orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        BankAccount srcAcc = getTransferAcc(srcPassport, srcRequisite);
        if (srcAcc != null && srcAcc.getValue() >= amount) {
            BankAccount destAcc = getTransferAcc(destPassport, dstRequisite);
            if (destAcc != null) {
                srcAcc.setValue(srcAcc.getValue() - amount);
                destAcc.setValue(destAcc.getValue() + amount);
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
