package com.pjatk.objects;

import java.util.ArrayList;

public class Address {
    private ArrayList<String> addressLines = new ArrayList<>();
    private int id;
    private String city;
    private String postalCode;

    public Address(int id, String city, String postalCode) {
        this.id = id;
        this.city = city;
        this.postalCode = postalCode;
    }

    public ArrayList<String> getAddressLines() {
        return addressLines;
    }

    @Override
    public String toString() {
        String string = "(" + id + "," + city + "," + postalCode + ",{";
        for (String adres : addressLines) {
            string += adres.toString();
        }
        string += "})";
        return string;
    }
}


