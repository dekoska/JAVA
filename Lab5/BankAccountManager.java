package com.pjatk.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class BankAccountManager {

    HashMap<String, BankAccount> accounts=new HashMap<>();
    HashMap<BankOperationType, ArrayList<BankAccountOperation>> operations = new HashMap<>();


    public void registerOperation(BankAccountOperation operation){
        if(!operations.containsKey(operation.getType()))
            this.operations.put(operation.getType(), new ArrayList<>());
        this.operations.get(operation.getType()).add(operation);
    }

    public void performDeposits(){
        ArrayList<BankAccountOperation> deposits = operations.get(BankOperationType.DEPOSIT);
        for(BankAccountOperation deposit : deposits){
            for(BankAccount account : accounts.values()){
                if(account==deposit.getSourceBankAccount()){
                    account.setCurrentMoney(account.getCurrentMoney()+deposit.getMoney());
                }
            }
        }
        operations.clear();
    }

    public void performWithdrawals(){
        ArrayList<BankAccountOperation> withdrawals = operations.get(BankOperationType.WITHDRAWAL);
        for(BankAccountOperation withdrawal : withdrawals) {
            for (BankAccount account : accounts.values()) {
                if (account == withdrawal.getSourceBankAccount()) {
                    if (account.getCurrentMoney() >= withdrawal.getMoney())
                        if (account == withdrawal.getSourceBankAccount()) {
                            account.setCurrentMoney(account.getCurrentMoney() - withdrawal.getMoney());
                        }
                }
            }
        }
            operations.clear();
        }


    public void performTransfers() {
        LocalDateTime now = LocalDateTime.now();
        ArrayList<BankAccountOperation> transfers = operations.get(BankOperationType.TRANSFER);
        for (BankAccountOperation transfer : transfers) {
            for (BankAccount account : accounts.values()) {
                if (now.isBefore(transfer.getDate())) {
                    if(account==transfer.getSourceBankAccount()) {
                        if (account.getCurrentMoney() >= transfer.getMoney()) {
                            if (account == transfer.getSourceBankAccount()) {
                                account.setCurrentMoney(account.getCurrentMoney() - transfer.getMoney());
                            }
                        }
                    }
                }
            }
        }
        for (BankAccountOperation transfer : transfers) {
            for (BankAccount account : accounts.values()) {
                if (now.isBefore(transfer.getDate())) {
                    if (account == transfer.getTargetBankAccount()) {
                        account.setCurrentMoney(account.getCurrentMoney()+transfer.getMoney());
                    }
                }
            }
        }
        operations.clear();
    }


    public void addAccount(BankAccount account) {
        if(!accounts.containsKey(account.getAccountNumber()))
            this.accounts.put(account.getAccountNumber(),account);
    }
}
