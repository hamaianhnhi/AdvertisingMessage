package utils;

import java.util.ArrayList;

public class ArrayUtils {

    public ArrayList indexOfAll(Object item, ArrayList arrayList){
        ArrayList indexListToReturn = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if(item.equals(arrayList.get(i))){
                indexListToReturn.add(i);
            }
        }
        return indexListToReturn;
    }

    public int findOccurrencesInArray(int numberToFind, ArrayList arrayList){
        ArrayList indexOfOccurrences = indexOfAll(numberToFind, arrayList);
        return indexOfOccurrences.size();
    }
}
