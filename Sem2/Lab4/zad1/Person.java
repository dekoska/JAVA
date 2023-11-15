package com.pjatk.pesel;

import com.pjatk.pesel.model.PeselValidator;

import java.time.LocalDate;

public class Person {
    private String peselNumber;
    private String name;
    private String surname;
    private String gender;
    private LocalDate dateOfBirth;

    public Person(String pesel) {

        if(PeselValidator.isValid(pesel)) {
            this.peselNumber = pesel;
            this.gender=getGender();
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){

        this.name=name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String lastName){

        this.surname=lastName;
    }
    public String getPeselNumber(){

        return peselNumber;
    }
    public String getGender(){
        char[] peselArray = peselNumber.toCharArray();
        if(Character.getNumericValue(peselArray[9])%2==0) gender="kobieta";
        else gender = "mężczyzna";
        return gender;
    }
    public LocalDate getDateOfBirth(){
        char[] peselArray = peselNumber.toCharArray();
        int year;
        int month;
        int day;
        year = 10 * Character.getNumericValue(peselArray[0]);
        year += Character.getNumericValue(peselArray[1]);
        month = 10 * Character.getNumericValue(peselArray[2]);
        month += Character.getNumericValue(peselArray[3]);
        if (month > 80 && month < 93) {
            year += 1800;
            month-=80;
        }
        else if (month > 0 && month < 13) {
            year += 1900;
        }
        else if (month > 20 && month < 33) {
            year += 2000;
            month-=20;
        }
        else if (month > 40 && month < 53) {
            year += 2100;
            month-=40;
        }
        else if (month > 60 && month < 73) {
            year += 2200;
            month-=60;
        }
        day = 10 * Character.getNumericValue(peselArray[4]);
        day += Character.getNumericValue(peselArray[5]);

        LocalDate date = LocalDate.of(year, month, day);
        dateOfBirth=date;

        return dateOfBirth;
    }

}
