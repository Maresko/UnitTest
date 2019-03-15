import funcPackage.CustomException;
import funcPackage.TestObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

public class SatisfiedConditions {

    private int[] testData;
    TestObject val = new TestObject();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testZeroMass() throws CustomException {
        int w0 = 0;
        int w1 = 0;
        int w2 = 0;
        int[] result = new int[1400];
        for (int i = 0; i < result.length; i++){
            testData = new int[]{50,30,60};
            result[i] = val.f(testData);
        }
        for (int i = 0; i < result.length; i++){
            if(result[i] == 0)
                w0++;
            if(result[i] == 1)
                w1++;
            if(result[i] == 2)
                w2++;
        }
        if(w0 > 550 || w0 < 450 ||
                (w1 > 350) || (w1 < 250) ||
                (w2 > 650) || (w2 < 550)){
            Assert.fail("wrong result" + w0 + " " + w1 + " " + w2);
        }

    }
}
