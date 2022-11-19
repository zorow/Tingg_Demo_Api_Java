package org.example;

import java.util.Random;

public class Utills {


    public static int generateRandomNumber(int max, int min){

        Random random = new Random();

        return random.nextInt(max - min)+ min;

    }
}
