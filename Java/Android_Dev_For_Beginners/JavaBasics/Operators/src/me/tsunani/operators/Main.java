package me.tsunani.operators;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String name = "Ammon";
//        for(int i = 0, len = name.length(); i < len; i++) {
//            System.out.print(name.charAt(i));
//        }
//        System.out.println("");
//        int a = 5;
//        do {
//            System.out.println("hello");
//            a++;
//        } while (a < 5);

//        System.out.println("Please Enter a Number: ");
//        Scanner scanner = new Scanner(System.in);
//        int answer = scanner.nextInt();
//        System.out.println("Answer was " + answer);
//        System.out.println("Please Enter your name: ");
//        String name = scanner.next();
//        System.out.println("Hello " + name);

        Random random = new Random();
        double number = random.nextDouble();
        System.out.println(number);
    }
}
