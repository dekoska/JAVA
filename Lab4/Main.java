package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("ABC123","TV",1000);
        System.out.println("Code: "+product.getCode());
        System.out.println("Name: "+product.getName());
        System.out.println("Price: "+product.getPrice());

        System.out.println("Stawka VAT: "+ InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: "+ InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: "+ InvoicePosition.TAX_23);

        InvoicePosition position = new InvoicePosition(product);
        System.out.println(position.getNettoPrice());
        System.out.println(position.getGrossPrice());

        Invoice invoice1 = new Invoice();
        invoice1.addPosition(position);


        invoice1.addPosition(new Product("ABC123","TV",1000));
        invoice1.addPosition(new Product("ABC123","TV",1000));
        invoice1.addPosition(new Product("CBA321","Radio",500));
        invoice1.addPosition(new Product("ABC123","TV",1000));
        invoice1.addPosition(new Product("CBA321","Radio",500));
        printoutInvoice(invoice1);

        invoice1.setDeadline(LocalDate.of(2023,03,02));
        invoice1.setFullAmount();

        Invoices invoices1= new Invoices();
        invoices1.addInvoice(invoice1);
        invoices1.interest();


    }
    private static void printoutInvoice(Invoice invoice){
        System.out.println("|NAZWA\t|ILOŚĆ\t|CENA NETTO\t|CENA BRUTTO\t|STAWKA VAT\t|PODATEK");
        System.out.println("*******************************************************************");
        for(InvoicePosition p: invoice.getPositions()){
            System.out.println("|" + p.getProduct().getName() + "\t|");
            System.out.println(p.getCount() + "\t|");
            System.out.println(p.getNettoPrice() +"\t\t|");
            System.out.println(p.getGrossPrice() +"\t\t|");
            System.out.println(p.getTax() +"\t\t|");
            System.out.println(p.getTaxValue() +"\t\t|");
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
}