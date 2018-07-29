package utils;

import java.util.Random;

public class Radomizer {

    public int weightedRandomFromArray(int weightArray[]){
        int totalWeight = 0;
        // we calculate the totalWeight
        for (int i = 0; i < weightArray.length; i++) {
            totalWeight = totalWeight + weightArray[i];
        }

        // we pick a random number: 0 < random number < totalWeight
        double randomWeight = Math.random() * totalWeight;
        for (int i = 0; i < weightArray.length; i++) {

            if(randomWeight < weightArray[i]){
                System.out.println(weightArray[i]);
                return i;// this is selected item
            }
            randomWeight = randomWeight - weightArray[i];
        }
        return 0; // it will never reach here
    }

    public int randomIntInRange(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
