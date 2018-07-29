package utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class RandomizerTest {

    @Test
    public void weightedRandomFromArray_WithValidData_ShouldBePassed(){
        int array[] = {1, 4, 5, 2, 6};
        Radomizer radomizer = new Radomizer();
        ArrayList selectedItemIndexs = new ArrayList();
        for (int i = 0; i < 100 ; i++) {
            int selectedItemIndex = radomizer.weightedRandomFromArray(array);
            selectedItemIndexs.add(selectedItemIndex);
        }
        Assert.assertNotNull(selectedItemIndexs);
        Assert.assertEquals(selectedItemIndexs.size(), 100);
        Assert.assertEquals(selectedItemIndexs.contains(0), true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void randomIntInRange_MinGreaterThanMax_ShouldThrowException(){
        Radomizer radomizer = new Radomizer();
        radomizer.randomIntInRange(3,2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void randomIntInRange_MinIsEqualToMax_ShouldThrowException(){
        Radomizer radomizer = new Radomizer();
        radomizer.randomIntInRange(2,2);
    }

    @Test
    public void randomIntInRange_ValidData_ResultShouldBeInsideBounds(){
        Radomizer radomizer = new Radomizer();
        int random = radomizer.randomIntInRange(4,7);
        System.out.println("randomIntInRange_ValidData_ResultShouldBeInsideBounds" + random);
        Assert.assertEquals((random <= 7), true);
        Assert.assertEquals((random >= 4), true);

    }
}
