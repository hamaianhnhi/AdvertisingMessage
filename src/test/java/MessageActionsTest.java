import com.google.common.primitives.Ints;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Radomizer;
import java.util.ArrayList;

public class MessageActionsTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRandomMessageToPublic_WithN_GreaterThan100_ShouldThrowException() throws IllegalArgumentException{
        ArrayList randomList = new ArrayList();
        for (int i = 0; i < 101; i++) {
            Radomizer radomizer = new Radomizer();
            randomList.add(radomizer.randomIntInRange(1, 100));
        }
        int[] randomArray = Ints.toArray(randomList);
        MessageActions messageActions = new MessageActions();
        messageActions.getWeightedRandomMessageToPublic(randomArray);
    }

    @Test
    public void testRandomMessageToPublic_WithN_is100_ShouldThrowException() throws IllegalArgumentException{
        ArrayList randomList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            Radomizer radomizer = new Radomizer();
            randomList.add(radomizer.randomIntInRange(1, 100));
        }
        int[] randomArray = Ints.toArray(randomList);
        MessageActions messageActions = new MessageActions();
        Assert.assertNotNull(messageActions.getWeightedRandomMessageToPublic(randomArray));
    }

    @Test
    public void testRandomMessageToPublic_WithN_is1_ShouldThrowException() throws IllegalArgumentException{
        int[] oneMemberArray = {8};
        MessageActions messageActions = new MessageActions();
        Assert.assertNotNull(messageActions.getWeightedRandomMessageToPublic(oneMemberArray));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRandomMessageToPublic_WithN_LessThan1_ShouldThrowException() throws IllegalArgumentException{
        int weightArray[] = {};
        MessageActions messageActions = new MessageActions();
        messageActions.getWeightedRandomMessageToPublic(weightArray);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRandomMessageToPublic_WeightGreaterThan10Pow9_ShouldThrowException() throws IllegalArgumentException{
        int tenPow9 = (int)Math.pow(10, 9);
        int weightArray[] = {tenPow9 + 1};
        MessageActions messageActions = new MessageActions();
        messageActions.getWeightedRandomMessageToPublic(weightArray);
    }

    @Test
    public void testRandomMessageToPublic_WeightIs10Pow9_ShouldBePassed() throws IllegalArgumentException{
        int tenPow9 = (int)Math.pow(10, 9);
        int weightArray[] = {tenPow9};
        MessageActions messageActions = new MessageActions();
        Assert.assertEquals(weightArray[messageActions.getWeightedRandomMessageToPublic(weightArray)], tenPow9);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRandomMessageToPublic_WeightLessThan0_ShouldThrowException() throws IllegalArgumentException{
        int weightArray[] = {-1, 5, 6};
        MessageActions messageActions = new MessageActions();
        messageActions.getWeightedRandomMessageToPublic(weightArray);
    }

    @Test()
    public void testRandomMessageToPublic_WeightIs0_ShouldBePassed() throws IllegalArgumentException{
        int weightArray[] = {0};
        MessageActions messageActions = new MessageActions();
        Assert.assertEquals(weightArray[messageActions.getWeightedRandomMessageToPublic(weightArray)], 0);
    }
}
