package org.pjatk.homework.zad05;

import java.util.Scanner;

/*
    Napisz program obliczający iloczyn dowolnej pary
    liczb całkowitych, nie korzystając z operatora *.
    Do dyspozycji masz operatory + i --.
 */
public class NonStandardMultiplierProgram {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Podaj pierwszą liczbę całkowitą");
        int x = input.nextInt();

        System.out.println("Podaj drugą liczbę całkowitą");
        int y = input.nextInt();

        int sum=0;

        for(int i=0; i<y; i++) {
            for (int j = 0; j < x; j++) {
                sum++;
            }
        }
            System.out.println("Wynik to "+sum+"");

    }
}
