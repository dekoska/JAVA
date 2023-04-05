package org.pjatk.products;

import java.util.ArrayList;

public class ProductsSorter {

    //można wykorzystać algorytm sortowania przez wstawiania
    public static ArrayList<Product> sort(ArrayList<Product> products){
        double price;
        String name;
        int j;
        for(int i=0;i<products.size();i++){
            price = products.get(i).price;
            name =  products.get(i).name;
            for(j = i - 1; j >= 0 && products.get(j).price > price; j-- ){
                products.get(j+1).price=products.get(j).price;
                products.get(j+1).name=products.get(j).name;
            }
            products.get(j+1).price = price;
            products.get(j+1).name = name;
        }
        return products;
    }

    public static Product mostExpensive(ArrayList<Product> products){
        int mostExpensive=0;
        for(int i=0; i<products.size()-1; i++) {
            if(products.get(i+1).price>products.get(i).price)
                mostExpensive=i+1;
            else mostExpensive=i;
        }
        return products.get(mostExpensive);
    }

    public static Product theCheapest(ArrayList<Product> products){
        int theCheapest=0;
        for(int i=0; i<products.size()-1; i++) {
            if(products.get(i+1).price<products.get(i).price)
                theCheapest=i+1;
            else theCheapest=i;
        }
        return products.get(theCheapest);
    }

    public static ArrayList<Product> theCheapest(ArrayList<Product> products, int n){
        ArrayList<Product> sortedProducts = ProductsSorter.sort(products);
        ArrayList<Product> theCheapestProducts=new ArrayList<>();

        for(int i=0; i<=n; i++){
            theCheapestProducts.add(products.get(i));
        }
        return theCheapestProducts;
    }
}
