package org.pjatk.homework.zad03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RingFieldProgram {

    /*
        Napisz program obliczający pole powierzchni pierścienia kołowego
        o promieniu zewnętrznym R i wewnętrznym r. Długości promieni użytkownik
        wprowadza z klawiatury. Program powinien zasygnalizować błędne dane
        i ponownie zapytać o potrzebną wartość.
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        double fieldR=0;
        double fieldr=0;

        try {
            System.out.println("Podaj promień zewnętrzny");
            double R = input.nextInt();
            fieldR = 3.14*R*R;

        }catch(InputMismatchException e) {
            System.out.println("Niepoprawny znak, wprowadź ponownie promień.");
            double R = input.nextInt();
        }

        try {
            System.out.println("Podaj promień wewnętrzny");
            double r = input.nextInt();
            fieldr = 3.14*r*r;

        }catch(InputMismatchException e) {
            System.out.println("Niepoprawny znak, wprowadź ponownie promień.");
            double r = input.nextInt();
        }

        double field= fieldR-fieldr;
        System.out.println("Pole powierzchni pieścienia kołowego to "+field+"");


    }
}
