package org.pjatk.homework.zad06;

import java.util.Scanner;

/*
    Napisz program który sprawdzi, czy wprowadzone zdanie
    jest palindromem, czyli brzmi tak samo czytane od strony lewej do prawej
    i od prawej do lewej.
    Przykład zdania-palindromu jest 'Kobyła ma mały bok' (bez rozróźniania wielkości
    liter i uwzględniania odstępów miedzy słowami)
 */
public class PalindromProgram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Podaj zdanie do sprawdzenia");
        String line = input.nextLine();

        line = line.replaceAll("\\s+", "").toLowerCase();
        char[] charArray = line.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                System.out.println("Zdanie nie jest palindromem");
                break;
            } else if (i == charArray.length - 1) {
                System.out.println("Zdanie jest palindromem");
            }

        }

    }
}
