package l33t.supa.binarytree;

public class MaxDepthOfTree {
    public static void main(String[] args) {
        TreeNode ld5 = new TreeNode(5);
        TreeNode ld6 = new TreeNode(6);
        TreeNode ld7 = new TreeNode(7);
        TreeNode ld8 = new TreeNode(8);
        TreeNode ld3 = new TreeNode(3,ld8,ld7);
        TreeNode ld4 = new TreeNode(4,ld6,ld5);
        TreeNode ld2 = new TreeNode(2,ld3,ld4);

        TreeNode rd5 = new TreeNode(5);
        TreeNode rd6 = new TreeNode(6);
        TreeNode rd7 = new TreeNode(7);
        TreeNode rd8 = new TreeNode(8);
        TreeNode rd4 = new TreeNode(4,rd5,rd6);
        TreeNode rd3 = new TreeNode(3,rd7,rd8);
        TreeNode rd2 = new TreeNode(2,rd4,rd3);

        TreeNode nd1 = new TreeNode(1, ld2, rd2);


        System.out.println(maxDepth(nd1));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
    }

}
