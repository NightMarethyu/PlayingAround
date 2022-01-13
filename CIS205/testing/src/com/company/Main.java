package com.company;

public class Main {

    public static void main(String[] args) {
        double[] vals = {1.0, 5.1, 2.4, 7.2, 5.3};
        for(int i = 1; i < 6; i++) {
            double x = vals[i-1];
            if ((x < 5.0) && (2 * x < 10.7) || Math.pow((5 * x), .5) > 5.1) {
                System.out.println(x);
            }
        }
    }
}
