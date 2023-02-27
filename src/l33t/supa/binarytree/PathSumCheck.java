package l33t.supa.binarytree;

public class PathSumCheck {
    public static void main(String[] args) {
        TreeNode ld7 = new TreeNode(7);
        TreeNode ld2 = new TreeNode(2);
        TreeNode ld1 = new TreeNode(1);
        TreeNode ld13 = new TreeNode(13);
        TreeNode ld11 = new TreeNode(11,ld7,ld2);
        TreeNode ld4 = new TreeNode(4,ld11,null);
        TreeNode ld4_ = new TreeNode(4,null,ld1);
        TreeNode ld8 = new TreeNode(8,ld13,ld4_);
        TreeNode ld5 = new TreeNode(5,ld4,ld8);

        TreeNode ld0 = new TreeNode();
        TreeNode ld00 = null;

        System.out.println(hasPathSum(ld5, 22));
        System.out.println(hasPathSum(ld0, 0));
        System.out.println(hasPathSum(ld00, 0));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }

}
