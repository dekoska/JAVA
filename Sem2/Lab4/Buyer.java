package org.example;
public class Buyer {
    public static final String Company = "Company";
    public static final String Person = "Person";
    private String name;
    private String type;
    private String address;
    private int NIP;

    public Buyer(String name, String type, String address,int NIP){
        this.name=name;
        setType(type);
        this.address=address;
        this.NIP=NIP;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        if(type.equals(Company))
            this.type=Company;
        else if(type.equals(Person))
            this.type=Person;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public int getNIP(){
        return NIP;
    }
    public void setNIP(int NIP){
        this.NIP=NIP;
    }


}
