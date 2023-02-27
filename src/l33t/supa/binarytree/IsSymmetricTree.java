package l33t.supa.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricTree {
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


        System.out.println(isSymmetric(nd1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root.left == null || root.right == null){
            return root.left == null && root.right == null;
        }

        return isSym(root.left, root.right);
    }

    static boolean isSym(TreeNode l,TreeNode r){
        if(l == null || r == null){
            return l == null && r == null;
        } else if (l.val != r.val){
            return false;
        }
        return isSym(l.left, r.right) && isSym(l.right, r.left);
    }

}
