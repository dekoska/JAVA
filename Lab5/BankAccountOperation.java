package com.pjatk.bank;

import java.time.LocalDateTime;

public class BankAccountOperation {
   BankAccount sourceBankAccount;
   BankAccount targetBankAccount;
   double money;
   BankOperationType type;
   LocalDateTime date;

   public BankAccountOperation(BankOperationType type){
      this.type=type;
   }

   public BankAccount getSourceBankAccount(){
      return sourceBankAccount;
   }

   public void setSourceBankAccount(BankAccount account) {
      this.sourceBankAccount=account;
   }

   public BankAccount getTargetBankAccount() {
      return targetBankAccount;
   }

   public void setTargetBankAccount(BankAccount account){
      this.targetBankAccount=account;
   }

   public void setMoney(double money){
      this.money=money;
   }
   public double getMoney(){
      return money;
   }
   public void setDate(LocalDateTime now){
      this.date=now;
   }

   public LocalDateTime getDate() {
      return date;
   }

   public BankOperationType getType() {
      return type;
   }
}
