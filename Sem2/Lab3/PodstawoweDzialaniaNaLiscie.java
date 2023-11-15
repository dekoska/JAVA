package org.pjatk.products;

import java.util.ArrayList;

public class PodstawoweDzialaniaNaLiscie {

    public static void main(String[] args){

        ArrayList<String> names = new ArrayList<String>();

        names.add("Jan");
        names.add("Adam");
        names.add("Ola");
        names.add("Ania");
        names.add("Maciej");
        names.add("Krzysztof");

        System.out.println("Ola znajduje się na indeksie: " + names.indexOf("Ola"));

        names.remove("Jan");
                //Adam, Ola, Ania, Maciej, Krzysztof

        names.remove(2);
                // usunie Anię, bo nastąpi przeindeksowanie - Jan już jest usunięty, więc na indeksie będzie Ania
                //Adam, Ola, Maciej, Krzysztof
        names.add(3, "Mateusz");
                // wstawi Mateusza przed Krzysztofa
                //Adam, Ola, Maciej, Mateusz, Krzysztof

        System.out.println("Ilość imion: "+ names.size()+"\noto one:");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("Na indeksie 2 jest "+ names.get(2));
        if(names.size()>0)
            System.out.println("Ostatni na liście jest "+ names.get(names.size()-1));

    }
}
