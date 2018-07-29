import com.google.common.primitives.Ints;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Radomizer;
import java.util.ArrayList;

public class MessageActionsTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void randomMessageToPublic_WithN_GreaterThan100_ShouldThrowException() throws IllegalArgumentException{
        ArrayList randomList = new ArrayList();
        for (int i = 0; i < 101; i++) {
            Radomizer radomizer = new Radomizer();
            randomList.add(radomizer.randomIntInRange(1, 100));
        }
        int[] randomArray = Ints.toArray(randomList);
        MessageActions message = new MessageActions();
        message.weightedRandomMessageToPublic(randomArray);
    }

    @Test
    public void randomMessageToPublic_WithN_is100_ShouldThrowException() throws IllegalArgumentException{
        ArrayList randomList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            Radomizer radomizer = new Radomizer();
            randomList.add(radomizer.randomIntInRange(1, 100));
        }
        int[] randomArray = Ints.toArray(randomList);
        MessageActions message = new MessageActions();
        Assert.assertNotNull(message.weightedRandomMessageToPublic(randomArray));
    }

    @Test
    public void randomMessageToPublic_WithN_is1_ShouldThrowException() throws IllegalArgumentException{
        int[] oneMemberArray = {8};
        MessageActions message = new MessageActions();
        Assert.assertNotNull(message.weightedRandomMessageToPublic(oneMemberArray));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void randomMessageToPublic_WithN_LessThan1_ShouldThrowException() throws IllegalArgumentException{
        int array[] = {};
        MessageActions messageActions = new MessageActions();
        messageActions.weightedRandomMessageToPublic(array);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void randomMessageToPublic_WeightGreaterThan10Pow9_ShouldThrowException() throws IllegalArgumentException{
        int tenPow9 = (int)Math.pow(10, 9);
        int array[] = {tenPow9 + 1};
        MessageActions messageActions = new MessageActions();
        messageActions.weightedRandomMessageToPublic(array);
    }

    @Test()
    public void randomMessageToPublic_WeightIs10Pow9_ShouldBePassed() throws IllegalArgumentException{
        int tenPow9 = (int)Math.pow(10, 9);
        int array[] = {tenPow9};
        MessageActions messageActions = new MessageActions();
        Assert.assertEquals(array[messageActions.weightedRandomMessageToPublic(array)], tenPow9);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void randomMessageToPublic_WeightLessThan0_ShouldThrowException() throws IllegalArgumentException{
        int array[] = {-1, 5, 6};
        MessageActions messageActions = new MessageActions();
        messageActions.weightedRandomMessageToPublic(array);
    }

    @Test()
    public void randomMessageToPublic_WeightIs0_ShouldBePassed() throws IllegalArgumentException{
        int array[] = {0};
        MessageActions messageActions = new MessageActions();
        Assert.assertEquals(array[messageActions.weightedRandomMessageToPublic(array)], 0);
    }
}
