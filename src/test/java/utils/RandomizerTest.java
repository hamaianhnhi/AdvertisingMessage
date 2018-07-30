package utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class RandomizerTest {

    @Test
    public void testGetWeightedRandomFromArray_WithValidData_ShouldBePassed(){
        int array[] = {1, 4, 5, 2, 6};
        Radomizer radomizer = new Radomizer();
        ArrayList selectedItemIndexs = new ArrayList();
        for (int i = 0; i < 100 ; i++) {
            int selectedItemIndex = radomizer.getWeightedRandomFromArray(array);
            selectedItemIndexs.add(selectedItemIndex);
        }
        Assert.assertEquals(selectedItemIndexs.size(), 100);
        Assert.assertEquals(selectedItemIndexs.contains(0), true);//TODO: need improvement
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
