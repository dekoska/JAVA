package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Invoices {
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
    public void interest(){
        for (Invoice i : invoices) {
            if (LocalDate.now().isBefore(i.getDeadline())) {
                 i.addInterest(DAYS.between(i.getDeadline(), LocalDate.now()));
            }
            System.out.println(i.getFullAmount());
        }
    }
}


