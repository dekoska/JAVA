package com.pjatk.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<Address> addresses = new ArrayList<>();

    public Person(int id, String name, LocalDate dateOfBirth) {
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
    }

    public ArrayList<Address> getAddresses(){
        return addresses;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public Person copy(){
        return new Person(this.getId(), this.getName(), this.getDateOfBirth());
    }
    public boolean equals(Person person){
        if(person.id==this.id && person.name==this.name && person.dateOfBirth==this.dateOfBirth && person.addresses.equals(this.addresses))
            return true;
        else return false;
    }
    @Override
    public String toString() {
        String string = "("+id+","+name+","+dateOfBirth+")\nAdresy:\n";
        for(Address adres : addresses){
            string += adres.toString();
        }
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses);
    }
}


