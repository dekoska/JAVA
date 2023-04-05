package com.pjatk.example;

import com.pjatk.example.mathutils.MathUtils;

public class MathApplication {


    public static void main(String[] args){

        /**
         * Napisz funkcję która obliczy n!
         */
        int result = MathUtils.factorial(5);
        if(result!=120)
            throw new RuntimeException("Poprawny wynik 5! to 120, a tutaj wyszło "+ result);
        result = MathUtils.factorialRecursive(6);
        if(result!=720)
            throw new RuntimeException("Poprawny wynik 6! to 720, a tutaj wyszło "+ result);
        result = MathUtils.factorialRecursive(5);
        if(result!=120)
            throw new RuntimeException("(przez rekurencje)Poprawny wynik 5! to 120, a tutaj wyszło "+ result);

        result = MathUtils.factorialRecursive(6);
        if(result!=720)
            throw new RuntimeException("(przez rekurencje)Poprawny wynik 6! to 720, a tutaj wyszło "+ result);

        /**
         * napisz funkcję która skróci ułamki i zwróci je w postaci String
         */

        String result2 = MathUtils.simplifyFractionInString(1,2);
        if(!result2.equals("1/2"))
            throw new RuntimeException("poprawny wynik to 1/2, a tutaj wyszło "+ result2);
        result2 = MathUtils.simplifyFractionInString(15,20);
        if(!result2.equals("3/4"))
            throw new RuntimeException("poprawny wynik to 3/4, a tutaj wyszło "+ result2);
        result2 = MathUtils.simplifyFractionInString(120,5);
        if(!result2.equals("24"))
        throw new RuntimeException("poprawny wynik to 24, a tutaj wyszło "+ result2);
        result2 = MathUtils.simplifyFractionInString(6,4);
        if(!result2.equals("3/2"))
            throw new RuntimeException("poprawny wynik to 3/2, a tutaj wyszło "+ result2);

        /**
         * napisz funkcję która policzy wartość całki oznaczonej na wielomianie
         */

        double[] polynomial = new double[3];
        /*
            zapis wielomianu: a0 + a1x + a2x^2 + ... + anx^n
            np. dla a0=1, a1=0, a2=1
            będzie: 1-x^2

            całka z wielomianu to:
            ,/'a0+a1x+a2x^2+...anx^n dx = a0x + a1x^2/2 + a2x^3/3 + ...+ anx^(n+1)/(n+1)
         */

        polynomial[0] = 1;
        polynomial[1] = 0;
        polynomial[2] = -1;

        double result3 = MathUtils.integralOfPolynomial(polynomial, -1,1);

        if (!(result3<1.34&&result3>1.33))
            throw new RuntimeException("poprawny wynik to 4/3, a tutaj wyszło "+ result3);

    }

}
