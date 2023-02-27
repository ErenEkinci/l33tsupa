package l33t.supa.medianSortedArrays;

import java.util.Arrays;

public class MedianSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{0,2,4,6,8,10,12,16,20};
//        int[] nums2 = new int[]{3,5,7,9,13};
        int[] nums1 = new int[]{0,2,4,6,8,10,12,16,20,55,444,456,567,999};
        int[] nums2 = new int[]{3,5,7,9,13};

        System.out.println(findMedianSortedArrays(nums1,nums2));
        System.out.println("=======================");
        findMedianSortedArraysBad(nums1, nums2);
    }

    public static double mergeSortMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        int size1 = end1-start1+1;
        int size2 = end2-start2+1;

        int[] arr = new int[size1+size2];

        for (int i = 0; i < size1; i++) {
            arr[i] = nums1[start1 + i];
        }
        for (int i = 0; i < size2; i++) {
            arr[size1+i] = nums2[start2 +i];
        }

        Arrays.sort(arr);

        if(arr.length %2 == 1)
            return arr[arr.length/2];
        else{
            return ((double) (arr[(arr.length-1)/2]+ arr[(arr.length-1)/2 +1]))/2.0;
        }
    }

    public static void findMedianSortedArraysBad(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];
        }
        for (int i = nums1.length; i < arr.length; i++) {
            arr[i] = nums2[i-nums1.length];
        }

        Arrays.sort(arr);
        if(arr.length %2 == 1)
            System.out.println(arr[arr.length/2]);
        else{
            System.out.println(arr[(arr.length-1)/2]);
            System.out.println(arr[(arr.length-1)/2 +1]);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // holds the limits start1, end1, start2, end2 for 2 arrays
        int[] ind = {0, nums1.length-1, 0, nums2.length-1};

        while (!exit(ind)){
            rebalance(nums1,nums2,ind);
        }
        return  mergeSortMedian(nums1, ind[0], ind[1], nums2, ind[2], ind[3]);
    }

    public static boolean exit(int[] ind){
        // exit condition for the loop
        return (ind[1] - ind[0] < 2) || (ind[3] - ind[2] < 2);
    }

    public static double finalSix(int[] nums1, int[] nums2, int[] ind){
        // finds the median when at least one array is size 2 or smaller
        System.out.println(nums1[ind[0]]);
        System.out.println(nums1[ind[1]]);
        System.out.println(nums2[ind[2]]);
        System.out.println(nums2[ind[3]]);
        System.out.println("=====================");



        if(ind[1] - ind[0] > 2){
            int[] med1 = medianIndex(ind[0], ind[1]);
            int[] med2 = medianIndex(ind[2], ind[3]);
            if(med1[0] == med1[1]){
                if(med2[0] == med2[1]){

                }
            }
        }else if(ind[3] - ind[2] > 2) {
            int size = ind[3] - ind[2] + 1;
            if (size % 2 == 1) {
                int[] med = medianIndex(ind[2], ind[3]);
                ind[2] = med[0] - 1;
                ind[3] = med[1] + 1;
            }
        } else {
            int[] arr = new int[ind[1]-ind[0] + ind[3]-ind[2] + 2];

            int c=0;
            for (int i = ind[0]; i <= ind[1]; i++) {
                arr[c++] = nums1[i];
            }
            for (int i = ind[2]; i < ind[3]; i++) {
                arr[c++] = nums2[i];
            }
            Arrays.sort(arr);
            return arr[(arr.length+1) / 2 -1];
        }



        return 0;
    }

    public static int balanceAmount(int[] ind){
        int size1 = ind[1] - ind[0]+1;
        int size2 = ind[3] - ind[2]+1;
        return Math.min(size1+1, size2+1) / 2 -1;
    }


    public static void rebalance(int[] nums1, int[] nums2, int[] ind){
        int[] med1 = medianIndex(ind[0],ind[1]);
        int[] med2 = medianIndex(ind[2],ind[3]);

        int median1s = nums1[med1[0]];
        int median1e = nums1[med1[1]];
        int median2s = nums2[med2[0]];
        int median2e = nums2[med2[1]];

        int balanceAmount = balanceAmount(ind);

        if(median1e > median2e)
            ind[1] -= balanceAmount;
        else
            ind[3] -= balanceAmount;

        if(median1s < median2s)
            ind[0] += balanceAmount;
        else
            ind[2] += balanceAmount;
    }

    /**
     * returns medians for an array
     * second value is -1 if array has a single median aka odd size
     * @param s1
     * @param e1
     * @return
     */
    public static int[] medianIndex(int s1, int e1){
        int[] medianIndex = new int[2];
        if(singleMedian(s1,e1)){
            medianIndex[0] = (s1+e1) / 2;
            medianIndex[1] = medianIndex[0];
        }else{
            medianIndex[0] = (s1+e1-1) / 2;
            medianIndex[1] = (s1+e1+1) / 2;
        }
        return medianIndex;
    }

    public static boolean singleMedian(int s, int e){
        return (s+e)%2 == 0;
    }
}
