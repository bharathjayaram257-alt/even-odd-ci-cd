package com.example;

public class EvenOdd {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        int number = args.length > 0 ? Integer.parseInt(args[0]) : 7;
        System.out.println(number + (isEven(number) ? " is even." : " is odd."));
    }
}
