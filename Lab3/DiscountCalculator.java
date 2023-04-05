package org.pjatk.products;

import java.util.ArrayList;

public class DiscountCalculator {

    public ArrayList<Product> products;

    /*
        minimumPrice - cena minimalna, od której zaczyna się naliczanie rabatu
        percentage - liczba od 0 do 1, określająca jaki procent rabatu jest przyznany, np 0.1 to 10%
     */
    public void discountByPercentage(double minimumPrice,double percentage){
        double sumPrice=0;
        for(int i=0; i<products.size(); i++){
            sumPrice+=products.get(i).price;
        }
        for(int i=0; i< products.size(); i++){
            if(sumPrice>=minimumPrice)
                products.get(i).price=(products.get(i).price)*(1-percentage);
        }
    }

    public void addFreeCompanyGlass(double minimumPrice){
        double sumPrice=0;
        for(int i=0; i<products.size(); i++){
            sumPrice+=products.get(i).price;
        }
        if(sumPrice>=minimumPrice){
            Product glass = new Product();
            glass.price=0;
            products.add(glass);
        }
    }

    public void threeForPriceOfTwo() {
        ArrayList<Product> sortedProducts = ProductsSorter.sort(products);
        if(products.get(0).price==0)
            products.get(1).price=0;
        else products.get(0).price=0;
    }
    //Nie wiedziałam jakie 3 produkty wziąć skoro mamy 4+kubek, więc wyzerowałam najtańszy z 4 wykluczając kubek:)
}
