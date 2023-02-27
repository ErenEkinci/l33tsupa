package l33t.supa.math;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> sum = threeSum(nums);

        sum.stream().sorted(Comparator.comparing(o -> o.stream().reduce(Integer::max).get()))
                .forEach(integers -> {
                    System.out.println("==================");
                    integers.forEach(System.out::println);
                    integers.stream()
                            .reduce(Integer::max).stream()
                            .sorted(Integer::compareTo)
                            .forEach(integer -> System.out.println("MAX = " + integer));
                    System.out.println("==================");
                });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        List<Integer> looked = new ArrayList<>();

        firstInt:
        for (int i = 0; i < nums.length-2; i++) {
            int c = nums[i];
            if(looked.contains(c)){
                break;
            }
            looked.add(c);
            List<Integer> looked2 = new ArrayList<>();

            secondInt:
            for (int j = i+1; j < nums.length-1; j++) {
                int c2 = nums[j];
                if(looked2.contains(c2)){
                    break;
                }
                looked2.add(c2);

                for (int k = j+1; k < nums.length; k++) {
                    int c3 = nums[k];

                    if(c + c2 + c3 == 0){
                        triplets.add(new ArrayList<>(List.of(c,c2,c3)));
                        break secondInt;
                    }
                }
            }
        }
        return triplets;
    }
}
