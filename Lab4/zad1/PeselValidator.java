package com.pjatk.pesel.model;

public class PeselValidator{
    public static boolean isValid(String pesel) {

        /* Algorytm sprawdzający czy nr pesel jest prawidłowym numerem PESEL
        (sprawdzić poprzez wyrażenie regularne oraz sumę kontrolną) */

        char[] peselArray = pesel.toCharArray();
        int sum = (Character.getNumericValue(peselArray[0]) * 1)%10 + (Character.getNumericValue(peselArray[1]) * 3)%10 + (Character.getNumericValue(peselArray[2]) * 7)%10 + (Character.getNumericValue(peselArray[3]) * 9)%10 + (Character.getNumericValue(peselArray[4]) * 1)%10 + (Character.getNumericValue(peselArray[5]) * 3)%10 + (Character.getNumericValue(peselArray[6]) * 7)%10 + (Character.getNumericValue(peselArray[7]) * 9)%10 + (Character.getNumericValue(peselArray[8]) * 1)%10 + (Character.getNumericValue(peselArray[9]) * 3)%10;
        int controlNumber;
        if (sum >= 10) controlNumber = 10 - (sum % 10);
        else controlNumber = 10 - sum;
        if (controlNumber == Character.getNumericValue(peselArray[10])) return true;
        else return false;
    }
}
