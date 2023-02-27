package l33t.supa.rotatedSortedArray;


public class RotatedSortedArraySearch {

    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{0,1,2,4,5,6,7};
//        int[] nums = new int[]{1,2};
        int p = search(nums, -8);
        System.out.println(p);
    }

    public static int search(int[] nums, int target)
    {
        int i, current;
        int left = 0;
        int right =  nums.length -1;

        if(nums[0] < nums[nums.length-1]){
            i = binarySearch(nums,0, nums.length-1, target);
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

            if(target<nums[right] || target>nums[left]){
                i = -1;
            }else if(target<nums[0]){
                i = binarySearch(nums,right, nums.length-1 ,target);
            }else{
                i = binarySearch(nums,0,left,target);
            }
        }

        return i;
    }

    private static int binarySearch(int[] nums , int begin, int end, int target)
    {
        int middle;

        while (begin <= end)
        {
            middle =  (end + begin) / 2;

            if(nums[middle] ==  target)
            {
                return middle;
            }
            else if ( target < nums[middle] )
            {
                end = middle -1;
            }
            else {
                begin = middle +1;
            }
        }

        return -1;
    }

}
