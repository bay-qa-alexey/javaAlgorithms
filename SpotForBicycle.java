

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class SpotForBicycle {

    static public void main(String[] args) {
        SpotForBicycle spotForBicycle = new SpotForBicycle();
        int[] spots = {10,0,8,2,-1,12,11,3};
        System.out.println(spotForBicycle.calculate(spots));

    }


    public int calculate(int[] A){

        // 1. array -> list
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : A)
        {
            intList.add(i);
        }

        System.out.println(intList);
        // 2. sorting the list
        Collections.sort(intList);

        System.out.println(intList);

        // 3. run through list by analizing each node:
        int rezult=0;
        int tmp=0;
        for(int i=0; i<intList.size() - 1; i++){
            tmp = intList.get(i+1)-intList.get(i);
            if( tmp > rezult) {
                rezult = tmp;
            }
        }
        return rezult/2;
    }
}
