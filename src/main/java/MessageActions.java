import utils.Radomizer;

public class MessageActions {

    /**
     * This returns version of selected message.
     * @param weightArray contains weight of each message version.
     * @return an integer telling index of selected item from given weightArray.
     * @throws IllegalArgumentException
     */
    public int getWeightedRandomMessageToPublic(int weightArray[])
            throws IllegalArgumentException{

        // we validate N: 1 ≤ N ≤ 100
        if (weightArray.length < 1 || weightArray.length > 100){
            throw new IllegalArgumentException("N should be 1 ≤ N ≤ 100");
        }

        // we validate weight: 0 ≤ weightArray[i] ≤ 10^9
        for (int item: weightArray) {
            if(item < 0 || item > (int) Math.pow(10, 9)){
                throw new IllegalArgumentException("Weight should be 0 ≤ weightArray[i] ≤ 10^9");
            }
        }

        Radomizer radomizer = new Radomizer();
        int randomMessageVersion = radomizer.getWeightedRandomFromArray(weightArray);
        return randomMessageVersion;// messageVersion is item's index
    }
}
