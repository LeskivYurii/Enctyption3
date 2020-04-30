package com.company;

import java.util.Random;

public class VernamСipher {


    public void Encryption(String message){
        Random r = new Random();
        int length=message.length();
        char arr[]= new char[length];
        char arr2[]= new char[length];
        char key[]= new char[length];
        arr=message.toCharArray();
        for (int i = 0; i<length;i++){
            key[i]= (char) ((char)r.nextInt()%255);
        }
        System.out.println();

        for (int i = 0; i <length;i++){
            arr2[i]= (char) (arr[i] ^ key[i]);
        }
        System.out.println(arr2 );
    }
}

