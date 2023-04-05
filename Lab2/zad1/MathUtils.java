package com.pjatk.example.mathutils;
import java.lang.Math;

public class MathUtils {

    public static int factorial(int n) {
        int silnia = 1;
        for (int i = n; i > 1; i--) {
            silnia *= i;
        }
        return silnia;
    }

    public static int factorialRecursive(int n) {
            if(n<2) {
                return 1;
            }
            else {
                return n*factorialRecursive(n-1);
        }
    }
     public static double integralOfPolynomial(double[] coefficients, double a, double b) {
        double x=0,y=0;
         for (int i =0; i<3; i++){
             x+=coefficients[i]*(Math.pow(b,(i+1))/(i+1));
             y+=coefficients[i]*(Math.pow(a,(i+1))/(i+1));
         }
         return x-y;

     }


    public static String simplifyFractionInString(int meter, int denominator) {

        int pierwsza = meter, druga = denominator;
        while (pierwsza != druga) {
            if (pierwsza > druga) {
                pierwsza = pierwsza - druga;
            } else {
                druga = druga - pierwsza;
            }
        }
        int newMeter = meter / pierwsza;
        int newDenominator = denominator / pierwsza;

        if (newDenominator==1) {
            return newMeter+"";
        }
        else if (newMeter != newDenominator) {
            return newMeter+"/"+newDenominator;
        }

    return "";
    }
}





