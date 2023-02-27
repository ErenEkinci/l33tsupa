package l33t.supa.math;

import java.util.ArrayList;

public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,8,100,2,100,4,8,3,7};
        int[] height3 = {1,1};

        int a1 = maxArea(height2);
        int a2 = maxArea2(height2);
        System.out.println("RES: " + (a1==a2));
        System.out.println(a1);
        System.out.println(a2);
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        
        ArrayList<Integer> jumpsAsc = new ArrayList<>();
        ArrayList<Integer> jumpsAscRev = new ArrayList<>();

        int ascMax = -1;
        int revMax = -1;

        int i=0;
        int last = height.length-1;
        while(i<height.length){
            if(height[i] > ascMax) {
                ascMax = height[i];
                jumpsAsc.add(i);
            }
            if(height[last - i] > revMax) {
                revMax = height[last - i];
                jumpsAscRev.add(last - i);
            }
            i++;
        }

        int leftIndex;
        int rightIndex;
        for (Integer j : jumpsAsc) {
            leftIndex = j;
            rightIndex = jumpsAscRev.get(0);
            int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex-leftIndex);
            if (area > maxArea) {
                maxArea = area;
            }

            for (int k = 0; rightIndex > leftIndex && k < jumpsAscRev.size(); k++) {
                rightIndex = jumpsAscRev.get(k);

                area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex-leftIndex);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
    public static int maxArea(int[] height) {
        int max = 0;
        int maxi = 0;
        int maxj = 0;

        for(int i=0; i<height.length-1; i++){
            if(height[i] > maxi){
                maxi = height[i];
                maxj = 0;
                for(int j=height.length-1; j>i; j--){
                    if(height[j] > maxj){
                        maxj = height[j];
                        int area = Math.min(height[i], height[j]) * (j-i);
                        if(area > max) {
                            max = area;
                        }
                    }
                }
            }
        }

        return max;
    }
}
