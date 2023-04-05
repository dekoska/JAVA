package com.pjatk.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Main {

     public static void main(String[] args){

         /**
          * Utwórz klasę Person z kontruktorem który uzupełnia podstawowe pola
          */
         Person jan = new Person(1, "jan", LocalDate.of(1990,01,01));

         /**
          * dodaj do klasy metodę do kopiowania obiektów
          */
         Person jan_kopia = jan.copy();

         /**
          * nadpisz metodę 'equals' dziedziczoną po klasie 'Object'
          */
         if(!jan.equals(jan_kopia) && jan!=jan_kopia){
             System.out.println("Kopie obiektu powinny być sobie równe. Powinny to być różne referencje.");
             System.out.println("Należy nadpisać metodę 'equals' odziedziczoną po klasie 'Object'");
             return;
         }


         Person zdzislaw = jan.copy();
         zdzislaw.setName("zdzislaw");
         zdzislaw.setId(2);
         zdzislaw.setDateOfBirth(jan.getDateOfBirth().plusMonths(2));

         if(zdzislaw.equals(jan)){
             System.out.println("obiekty NIE powinny być sobie równe");
             System.out.println("Należy nadpisać metodę 'equals' odziedziczoną po klasie 'Object', " +
                     "tak aby jakakolwiek różnica w polach obiektów powodowała zwrot 'false'");
             return;
         }

         /**
          * Dodaj klasę 'Address' która w konstruktorze przyjmuje id, city oraz postalCode.
          * Ma także pole addressLines które jest typu 'ArrayList<String>',
          * do którego jest jedynie zdefiniowana właściwość odczytu (getter)
          */
         Address adresJana = new Address(1, "Gdansk", "80-001");
         adresJana.getAddressLines().add("Brzegi 55");
         Address adresKopiiJana = new Address(1, "Gdynia", "80-002");
         adresKopiiJana.getAddressLines().add("Brzegi 55");

         /**
          * Dodaj możliwość dodawania adresów do poszczególnych osób.
          * Czyli należy dodać pole o nazwie 'addresses'
          * z właściwością odczytu (getter)
          * w klasie 'Person'
          */
         jan.getAddresses().add(adresJana);
         jan_kopia.getAddresses().add(adresKopiiJana);

         /**
          * zmodyfikuj metodę 'equals' tak, aby uwzględniała także różnice w adresach
          */
         if(jan.equals(jan_kopia)){
             System.out.println("jan i jego kopia mają różne adresy ! - metoda 'equals' powinna to uwzględniać");
             return;
         }

         adresJana.getAddressLines().add("dziekanat szkoly");
         /**
          * kiedy wprowadzę obiekt typu Person jako parametr do System.out.println(jan)
          * to chcę dostać wynik w postaci:
          * (id, name, dateOfBirth)
          * Adresy:
          * (id, city, postalCode, { addressLine1, addressLine2 })
          *
          * Na przykład:
          * (1, jan, 1990-01-01)
          * Adresy:
          * (1, Gdansk, 80-001, {Brzegi 55, dziekanat szkoly})
          * 
          * W tym celu należy nadpisać metodę 'toString' dziedziczoną po klasie 'Object'
          */
         System.out.println(jan);

         /**
          * Chcę aby program przechowywał adresy w postaci HashMapy,
          * gdzie kluczem jest obiekt typu 'Person'
          */
         HashMap<Person, ArrayList<Address>> addressesByPerson = new HashMap<>();


         addressesByPerson.put(jan, jan.getAddresses());
         addressesByPerson.put(jan_kopia, jan_kopia.getAddresses());
         addressesByPerson.put(zdzislaw, jan.getAddresses());

         Person drugaKopiaJana = jan.copy();

         addressesByPerson.put(drugaKopiaJana, drugaKopiaJana.getAddresses());

         /**
          * NIE chcę aby obiekt, który jest identyczny jak jakiś wcześniej dodany element
          * był dodany w nowe miejsce HashMapy.
          * W tym celu należy nadpisać metodę 'hashCode' dziedziczoną po klasie 'Object'
          */
         if(addressesByPerson.keySet().size()>3){
             System.out.println("druga kopia jana powinna wejść na miejsce jana, więc rozmiar kolekcji nie powinien być większy od 3 ");
             System.out.println("w tym celu nalezy nadpisać metodę 'hashCode' odziedziczoną z klasy 'Object'");
         return;
         }

         Person trzeciaKopiaJana = jan.copy();
         trzeciaKopiaJana.getAddresses().add(new Address(2, "Sopot", "80-003"));
         addressesByPerson.put(trzeciaKopiaJana, trzeciaKopiaJana.getAddresses());

         /**
          * koelejny obiekt dodawany do hasmapy jest już inny (ma inny adres),
          * więc powinna się dla niego utworzyć nowa pozycja w HashMapie
          */
         if(addressesByPerson.keySet().size()!=4){
             System.out.println("dodanie adresu do trzeciej kopii jana powinno zmienić wynik metody 'hashCode' " +
                     "- stąd nowy element powinien móc być dodany do kolekcji");
             return;
         }

         System.out.println("wszystko dziala");

     }

}
