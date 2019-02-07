// samma syfte som Min men mer effektiv

package min;

public class memoryEfficient {

    public static int memMin (int[] element) {
        
	int[]   minNum = element;
        int minValue = minNum[0];
        int i;
        
        for (i = 1; i < minNum.length; i++) {
            
            if(minValue > minNum[i]) {
                minValue = minNum[i];
            }
        }
        
        System.out.println("minsta värdet är " + minValue);
        return minValue;
        
    }
}
