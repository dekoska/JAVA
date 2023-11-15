package org.example;

import java.time.LocalDate;
import java.util.ArrayList;


public class Invoice {
    private LocalDate invoiceDate;
    private LocalDate deadline;
    private double fullAmount;
    private Buyer buyer;
    private ArrayList<InvoicePosition> positions = new ArrayList<>();


    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public double getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount() {
        for(InvoicePosition position : positions){
            fullAmount+=position.getGrossPrice();
        }
    }

    public void addInterest(long days){
        this.fullAmount += Math.round(getFullAmount()*(days*(0.08/365)));
    }

    public ArrayList<InvoicePosition> getPositions() {
        return positions;
    }
    public void addPosition(InvoicePosition position){
        positions.add(position);
    }

    public void addPosition(Product product){
        InvoicePosition position = positionWithProduct(product);
        if(position == null){
            addPosition(new InvoicePosition(product));
            return;
        }
        position.setCount(position.getCount()+1);
    }
    private InvoicePosition positionWithProduct(Product product){
        for(InvoicePosition position:positions){
            if(position.getProduct().getCode().equals(product.getCode()))
                return position;
        }
        return null;
    }

}
