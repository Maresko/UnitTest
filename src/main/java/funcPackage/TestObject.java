package funcPackage;

import java.util.Random;

public class TestObject {

    public int f(int w[]) throws CustomException {

        Random rand = new Random();

        long sumW = 0;
        long currentSumW = 0;
        long randLong = 0;
        int maxValue = (int)Math.pow(10,9);
        int minValue = 0;
        Integer itr = null;

        if(w.length == 0){
            throw new CustomException("input array is empty");
        }

        if(w.length == 1){
            return 0;
        }

        if( w.length > 100 ){
            throw new CustomException("Length of w more than 100, length= " + w.length);
        }

        for (int i = 0; i < w.length ; i++) {
            if (w[i] > maxValue )
                throw new CustomException("Element value is more than acceptable, value = " + w[i] + " number = " + i);
            if (w[i] < minValue)
                throw new CustomException("Element value is less than acceptable, value = " + w[i] + " number = " + i);

            sumW = sumW + (long)w[i];

            if (i == w.length-1 && sumW == 0) // i don't know correct make this
                return 0;

        }

        randLong = Math.abs (rand.nextLong ())% sumW;

        for (int i = 0; i < w.length ; i++){
            currentSumW = currentSumW + (long)w[i];
            if(randLong <= currentSumW){
                return i;
            }
        }

        return itr;
    }
}
