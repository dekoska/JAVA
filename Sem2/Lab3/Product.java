package org.pjatk.products;

public class Product {
    public String name;
    public double price;
    
    public Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
