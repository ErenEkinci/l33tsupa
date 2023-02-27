package l33t.supa.rotatedSortedArray;

public class RotatedSortedArrayMin {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,-12,0,1,2};
//        int[] nums = new int[]{0,1,2,4,5,6,7};
//        int[] nums = new int[]{1,2};
        System.out.println(min(nums));
    }

    public static int min(int[] nums)
    {
        int i, current;
        int left = 0;
        int right =  nums.length -1;

        if(nums[0] < nums[nums.length-1]){
            i = nums[0];
        }else{
            while (right - left  >= 2)
            {
                current = (right + left ) / 2;

                if(nums[current] > nums[right])
                {
                    left = current;
                }
                else {
                    right = current;
                }
            }
            return nums[right];
        }

        return i;
    }
}
