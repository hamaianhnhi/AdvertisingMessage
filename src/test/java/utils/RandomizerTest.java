package utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class RandomizerTest {

    @Test
    public void testGetWeightedRandomFromArray_WithValidData_ShouldBePassed(){
        int array[] = {50, 30, 60};
        Radomizer radomizer = new Radomizer();
        ArrayList selectedItemIndexs = new ArrayList();
        for (int i = 0; i < 280 ; i++) {
            int selectedItemIndex = radomizer.getWeightedRandomFromArray(array);
            selectedItemIndexs.add(selectedItemIndex);
        }

        // we count occurrences of each item in array
        ArrayUtils arrayUtils = new ArrayUtils();
        int occ0 = arrayUtils.findOccurrencesInArray(0, selectedItemIndexs);
        int occ1 = arrayUtils.findOccurrencesInArray(1, selectedItemIndexs);
        int occ2 = arrayUtils.findOccurrencesInArray(2, selectedItemIndexs);

        double acceptableDiff = 0.1;

        int e0 = 100; //expected of occ0
        int e1 = 60;  //expected of occ1
        int e2 = 120; //expected of occ2

        // verify that occ should be in bounds [e - acceptableDiff; e + acceptableDiff]
        Assert.assertEquals((( occ0 >= (e0 - (e0 * acceptableDiff)))  &&  (occ0  <=  (e0 + (e0 * acceptableDiff)))), true);
        Assert.assertEquals((( occ1 >= (e1 - (e1 * acceptableDiff)))  &&  (occ1  <=  (e1 + (e1 * acceptableDiff)))), true);
        Assert.assertEquals((( occ2 >= (e2 - (e2 * acceptableDiff)))  &&  (occ2  <=  (e2 + (e2 * acceptableDiff)))), true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRandomIntInRange_MinGreaterThanMax_ShouldThrowException(){
        Radomizer radomizer = new Radomizer();
        radomizer.randomIntInRange(3,2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRandomIntInRange_MinEqualToMax_ShouldThrowException(){
        Radomizer radomizer = new Radomizer();
        radomizer.randomIntInRange(2,2);
    }

    @Test
    public void TestRandomIntInRange_WithValidInput_ResultShouldBeInsideBounds(){
        Radomizer radomizer = new Radomizer();
        int random = radomizer.randomIntInRange(4,7);
        Assert.assertEquals((random <= 7), true);
        Assert.assertEquals((random >= 4), true);

    }
}
