package org.example.myWater;

public class myWater {

    public static int large=2;
    public static int medium=1;
    public static double smallL=0.5;

    public static void addLarge(int l, int[] arr) {
        arr[0] += l;
    }

    public static void addMedium(int m, int[] arr) {
        arr[1] += m;
    }

    public static void addSmall(int s, int[] arr) {
        arr[2] += s;
    }
}


