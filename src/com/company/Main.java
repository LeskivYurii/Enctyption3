package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        String message;
        System.out.println("Введіть повідомлення");
        message=sc.nextLine();
        BigramCipher b = new BigramCipher();
        b.Encryption(message);
        VernamСipher v = new VernamСipher();
        v.Encryption(message);
    }
}
