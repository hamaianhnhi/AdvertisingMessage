package utils;

import java.util.Random;

public class Radomizer {

    /**
     * This returns an integer number that referring to selected item's index.
     * @param weightArray the integer array which contains member's weight
     * @return the index of the item which is selected from weightArray
     */
    public int getWeightedRandomFromArray(int weightArray[]){
        int totalWeight = 0;
        // we calculate the totalWeight
        for (int i = 0; i < weightArray.length; i++) {
            totalWeight += weightArray[i];
        }

        // we pick a random number: 0 < random number < totalWeight
        double randomWeight = Math.random() * totalWeight;
        for (int i = 0; i < weightArray.length; i++) {
            if(randomWeight < weightArray[i]){
                System.out.println(weightArray[i]);//TODO: remove this
                return i;// this is selected item
            }
            randomWeight -= weightArray[i];
        }
        return 0; // it will never reach here
    }

    /**
     * This returns an integer number which greater than or equal to min; and less than or equal to max
     * @param min the minimum value of the range in integer
     * @param max the maximum value of the range in integer
     * @return the integer number which greater than or equal to min; and less than or equal to max
     */
    public int randomIntInRange(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
