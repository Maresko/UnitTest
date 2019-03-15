import funcPackage.CustomException;
import funcPackage.TestObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;

public class EdgeConditions {

    private int[] testData;
    TestObject val = new TestObject();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testZeroMass() throws CustomException {
        testData = new int[]{};
        expectedException.expect(CustomException.class);
        expectedException.expectMessage("input array is empty");
        val.f(testData);
    }

    @Test
    public void testBigMass() throws CustomException {
        int massLenght = 101;
        testData = new int[massLenght];
        for (int i = 0; i < massLenght; i++){
            testData[i] = 1;
        }
        expectedException.expect(CustomException.class);
        expectedException.expectMessage("Length of w more than 100, length= 101");
        val.f(testData);
    }

    @Test
    public void testHighValue() throws CustomException {
        int y = 1;
        int x = (int)Math.pow(10, 9) + 1;
        testData = new int[]{x,y};
        expectedException.expect(CustomException.class);
        expectedException.expectMessage("Element value is more than acceptable, value = 1000000001 number = 0");
        val.f(testData);
    }

    @Test
    public void testLessValue() throws CustomException {
        int y = 1;
        int x = -1;
        testData = new int[]{x,y};
        expectedException.expect(CustomException.class);
        expectedException.expectMessage("Element value is less than acceptable, value = -1 number = 0");
        val.f(testData);
    }

    @Test
    public void testMaxWeightMass() throws CustomException {
        int massLenght = 100;
        testData = new int[massLenght];
        for (int i = 0; i < massLenght; i++){
            testData[i] = (int)Math.pow(10, 9);
        }
        System.out.println(val.f(testData));
    }

    @Test
    public void testMinWeightMass() throws CustomException {
        int massLenght = 100;
        testData = new int[massLenght];
        for (int i = 0; i < massLenght; i++){
            testData[i] = 0;
        }
        assertEquals(0, val.f(testData));
    }
}
