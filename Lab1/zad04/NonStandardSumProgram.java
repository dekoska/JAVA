package org.pjatk.homework.zad04;

import java.util.Scanner;

public class NonStandardSumProgram {

    /*
        Użytkownik wprowadza z klawiatury dwie liczby całkowite.
        Napisz program obliczający sumę tych liczb, korzystając
        z operatorów inkrementacji (++) i dekrementacji (--).
        Użycie operatora dodawania (+) jest zabronione.
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Wpisz pierwszą liczbę całkowitą");
        int x = input.nextInt();

        System.out.println("Wpisz drugą liczbę całkowitą");
        int y = input.nextInt();

        int sum=0;

        for(int i=0; i<=y; i++){
            sum=x++;
        }

        System.out.println("Wynik to "+sum+"");
    }
}