//283. Move Zeroes (easy)



import java.util.Arrays;

public class MoveZeroes {

    static public void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();

        int[] nums = {1,2,0,5,0,9,0};
        System.out.println(Arrays.toString(nums));
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int nonzero = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonzero] = nums[i];
                nonzero++;
            }
        }
        for(int i=nonzero; i<nums.length; i++) {
            nums[i] = 0;
        }
    }

}
