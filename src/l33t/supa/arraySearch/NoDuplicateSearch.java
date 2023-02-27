package l33t.supa.arraySearch;

public class NoDuplicateSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5,2,3,1,5,6,99,7,99,6,4,7};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}
