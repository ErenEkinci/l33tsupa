package l33t.supa.searchinsert;

public class SearchInsert {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{1,3,4,5,6,8,12,44,55,78,100};
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int current;

        while (end-start > 1){
            current = start + (end - start + ((end-start)%2==0 ? 0 : 1))/2;
            if(nums[current] > target){
                end = current;
            }else if(nums[current] < target){
                start = current;
            } else {
                return current;
            }
        }

        return nums[start] >= target ? start : start+1;
    }
}
