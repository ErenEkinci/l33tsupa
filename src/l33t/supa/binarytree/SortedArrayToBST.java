package l33t.supa.binarytree;

import static l33t.supa.binarytree.BinaryTreeTraversal.inorderTraversal;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,9,5};
        System.out.println(inorderTraversal(sortedArrayToBST(nums)));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return fromArray(nums, 0, nums.length-1);
    }

    public static TreeNode fromArray(int[] nums, int s, int e){
        if(e-s == 1){
            return new TreeNode(nums[e], new TreeNode(nums[s]), null);
        } else if( e == s ){
            return new TreeNode(nums[s]);
        } else if (e < s){
            return null;
        }

        int mid = (e+s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fromArray(nums, s, mid-1);
        root.right = fromArray(nums, mid+1, e);
        return root;
    }

}
