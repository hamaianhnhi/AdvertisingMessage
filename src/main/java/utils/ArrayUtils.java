package utils;

import java.util.ArrayList;

public class ArrayUtils {

    /**
     * This returns list of occurrence's index of an item from a given ArrayList
     * @param item an object to be used to find occurrences
     * @param arrayList list of items to be loop
     * @return list of occurrence's index
     */
    public ArrayList indexOfAll(Object item, ArrayList arrayList){
        ArrayList indexListToReturn = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if(item.equals(arrayList.get(i))){
                indexListToReturn.add(i);
            }
        }
        return indexListToReturn;
    }

    /**
     * This returns number of occurrences of an object from given ArrayList
     * @param objectToFind an object to be used to find occurrences
     * @param arrayList list of items to be loop
     * @return number of occurrences
     */
    public int findOccurrencesInArray(Object objectToFind, ArrayList arrayList){
        ArrayList indexOfOccurrences = indexOfAll(objectToFind, arrayList);
        return indexOfOccurrences.size();
    }
}
