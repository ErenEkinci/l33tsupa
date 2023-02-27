package l33t.supa.arraySort;

public class mergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        merge(nums1,m,nums2,n);
        System.out.println("ref = " + nums1);
        for (int j : nums1) {
            System.out.println(j);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m+n];
        int i=0, n1=0, n2=0;
        while(n1 < m && n2 < n){
            if(nums1[n1] < nums2[n2]){
                merged[i] = nums1[n1];
                n1++;
            }else{
                merged[i] = nums2[n2];
                n2++;
            }
            i++;
        }
        if(n1 == m){
            while(n2<n){
                merged[i] = nums2[n2++];
                i++;
            }
        } else {
            while(n1<m){
                merged[i] = nums1[n1++];
                i++;
            }
        }

        for (int j = 0; j < m+n; j++) {
            nums1[j] = merged[j];
        }
    }
}
