package l33t.supa.removedupes;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,3,3,3,3,3,4,5,6,7,8,8,8,8,8,8,8,8,8,8,8};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int lastN = nums[0];
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>lastN) {
                lastN = nums[i];
                nums[++lastIndex] = lastN;
            }
        }

        return lastIndex+1;
    }
}
