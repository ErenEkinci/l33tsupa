package l33t.supa.removedupes;

public class RemoveItems {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,3};
//        int[] nums = {3};
        System.out.println(removeElement(nums, 3));
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int rev = nums.length;
        int i = 0;
        while (i < rev) {
            if(nums[i] == val){
                while(rev > i){
                    rev--;
                    if(nums[rev] != val){
                        nums[i] = nums[rev];
                        i++;
                        break;
                    }
                }
            }else{
                i++;
            }
        }

        return i;
    }
}
