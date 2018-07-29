import utils.Radomizer;

public class MessageActions {

    public int weightedRandomMessageToPublic(int w[])
            throws IllegalArgumentException{

        // we validate N: 1 ≤ N ≤ 100
        if (w.length < 1 || w.length > 100){
            throw new IllegalArgumentException("N should be 1 ≤ N ≤ 100");
        }

        // we validate weight: 0 ≤ w[i] ≤ 10^9
        for (int item: w) {
            if(item < 0 || item > (int) Math.pow(10, 9)){
                throw new IllegalArgumentException("Weight should be 0 ≤ w[i] ≤ 10^9");
            }
        }

        Radomizer radomizer = new Radomizer();
        int randomMessageVersion = radomizer.weightedRandomFromArray(w);
        return randomMessageVersion;// messageVersion is item's index
    }
}
