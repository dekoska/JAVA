package org.pjatk.products;

import java.util.ArrayList;

public class MainProgram {

    public static void main(String args[]){

        /**
         * Przygotowanie obiektów
         */
        ArrayList<Product> products;
        DiscountCalculator calculator;
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.price=300;
        p2.price=200;
        p3.price=100;
        p4.price=500;
        products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        /**
         * Napisz metodę, która sortuje produkty po cenie, od najmniejszej do największej
         */
        ArrayList<Product> sortedProducts = ProductsSorter.sort(products);
        if(!checkSortedProducts(sortedProducts)){
            System.out.println("produkty nie są poprawnie posortowane");
            return;
        }

        /**
         * Napisz metodę która będzie znajdować najdroższy produkt
         */
        if(!ProductsSorter.mostExpensive(products).equals(p4)){
            System.out.println("najdroższy produktem powinien być 'p4'");
            return;
        }

        /**
         * Napisz metodę która wyszuka najtańszy produkt
         */
        if(!ProductsSorter.theCheapest(products).equals(p3)){
            System.out.println("najtańszym produktem powinien być 'p3'");
            return;
        }

        /**
         * Napisz metodę która zwróci n najtanszych produktów
         */
        if(!(ProductsSorter.theCheapest(products,2).contains(p3)&&ProductsSorter.theCheapest(products,2).contains(p2))){
            System.out.println("2 najtańsze produkty to 'p3' i 'p2'");
            return;
        }



        calculator = new DiscountCalculator();
        calculator.products = products;
        /**
         * Napisz metodę która do kolekcji produktów doda darmowy kubek,
         * o ile suma cen produktów przekracza zadaną wartość
         */
        calculator.addFreeCompanyGlass(10000.0);
        if(products.size()!=4){
            System.out.println("Cena produktów nie jest wyższa niż 10000 - kubek nie powinień zostać dodany");
            return;
        }

        calculator.addFreeCompanyGlass(1000.0);
        if(products.size() != 5){
            System.out.println("Cena produktów jest wyższa niż 1000 - kubek powinień zostać dodany");
            return;
        }

        /**
         * Napisz metodę, która obniży cenę wszystkich produktów o zadany procent (liczba od 0 do 1),
         * o ile suma cen w produktów przekracza zadaną wartość
         */
        calculator.discountByPercentage(1000.0, 0.1);

        if(p1.price!=90
                ||p2.price!=180
                ||p3.price!=270
                ||p4.price!=450){
            System.out.println("Ceny produktów powinny być obniżona o 10%");
            return;
        }

        /**
         * Napisz metodę, która będzie wyzerowywać cenę najtańszego z trzech produktów.
         * Produkty, które zostały dodane jako darmowe mają zostać pominięte (np. darmowy kubek).
         */
        calculator.threeForPriceOfTwo();
        if(p3.price>0){
            System.out.println("produkt 'p3' powinien być za darmo.");
            return;
        }

        System.out.println("Wygląda na to że jest ok. Koniec.");
    }

    static boolean checkSortedProducts(ArrayList<Product> sortedProducts) {
        return sortedProducts.get(0).price==100
                &&sortedProducts.get(1).price==200
                &&sortedProducts.get(2).price==300
                &&sortedProducts.get(3).price==500;
    }
}
