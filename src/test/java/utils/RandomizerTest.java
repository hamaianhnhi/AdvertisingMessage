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

        ArrayUtils arrayUtils = new ArrayUtils();
        int a0 = arrayUtils.findOccurrencesInArray(0, selectedItemIndexs);
        int a1 = arrayUtils.findOccurrencesInArray(1, selectedItemIndexs);
        int a2 = arrayUtils.findOccurrencesInArray(2, selectedItemIndexs);

        double acceptableDiff = 0.1;

        int e0 = 100; //expected of a0
        int e1 = 60;  //expected of a1
        int e2 = 120; //expected of a2

        // verify that a should be in bounds [e - acceptableDiff; e + acceptableDiff]
        Assert.assertEquals((( a0 >= (e0 - (e0 * acceptableDiff)))  &&  (a0  <=  (e0 + (e0 * acceptableDiff)))), true);
        Assert.assertEquals((( a1 >= (e1 - (e1 * acceptableDiff)))  &&  (a1  <=  (e1 + (e1 * acceptableDiff)))), true);
        Assert.assertEquals((( a2 >= (e2 - (e2 * acceptableDiff)))  &&  (a2  <=  (e2 + (e2 * acceptableDiff)))), true);
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
