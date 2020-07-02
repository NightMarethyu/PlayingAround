package me.tsunani.helloworld;

public class Hello {
    public static void main(String[] args) {
//        System.out.print("Hello World\n");
//        System.out.println("Hello World");

        // int is up to 2^32 digits long
        int number = 42;
        System.out.println(number);

        // this is the superior floating point number, its more precise and easier to type
        double floating = 3.14;
        System.out.println(floating);

        // long is up to 2^64 digits long
        long myLong = 123456789;
        System.out.println(myLong);

        // float has less precision than double in java
        float myFloat = (float) 2.357;
        System.out.println(myFloat);

        // char is to store a single character
        char myChar = 'M';
        System.out.println(myChar);

        // String is to store multiple characters
        // String doesn't change color because it's a class and therefore has dot operators
        String myString = "This is my string";
        System.out.println(myString);

        // boolean are true/false values
        boolean myBool = true;
        System.out.println(myBool);



        int a = 6;
        int b = 2;
        int answer = a * b;
        System.out.println(answer);

    }
}
