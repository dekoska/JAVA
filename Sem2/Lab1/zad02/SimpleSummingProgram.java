package org.pjatk.homework.zad02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleSummingProgram {

    /*
        Użytkownik wprowadza z klawiatury serię liczb różnych od zero,
        zero natomiast jest sygnałem zakończenia wprowadzania danych.
        Napisz program, który obliczy sumę tych liczb
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int sum=0;
        int x;
        boolean exit=false;


        while(!exit){
            System.out.println("Podaj liczbe");
            x=input.nextInt();
            sum+=x;

            if(x==0){
                exit=true;
            }
        }
        System.out.println("Suma liczb to "+sum+"");
    }
}
