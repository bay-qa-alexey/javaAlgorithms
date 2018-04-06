//1. Two Sum (easy)
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.


import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static public void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 8, 11, 2,  15, 7};
        int[] rez = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(rez));

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] rezult = {0, 0};
        for(int i =0; i< nums.length; i++) {
            if (hm.isEmpty()) {
                hm.put(nums[i], i);
            } else {
                if (hm.containsKey(target - nums[i])) {
                    rezult[0] =  hm.get(target - nums[i]);
                    rezult[1] = i;
                    return rezult;
                } else {
                    if (!hm.containsKey(nums[i])) {
                        hm.put(nums[i], i);
                    }
                }
            }
        }
        return rezult;
    }
}
