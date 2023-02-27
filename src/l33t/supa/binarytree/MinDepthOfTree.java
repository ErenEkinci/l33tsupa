package l33t.supa.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinDepthOfTree {
    public static void main(String[] args) {
        TreeNode ld16 = new TreeNode(16,null,null);
        TreeNode ld15 = new TreeNode(15,null,ld16);
        TreeNode ld14 = new TreeNode(14,null,null);
        TreeNode ld13 = new TreeNode(13,null,null);
        TreeNode ld12 = new TreeNode(12,null,null);
        TreeNode ld11 = new TreeNode(11,null,null);
        TreeNode ld17 = new TreeNode(17,null,null);
        TreeNode ld10 = new TreeNode(10,null,null);
        TreeNode ld9 = new TreeNode(9,null,null);
        TreeNode ld8 = new TreeNode(8,null,ld15);
        TreeNode ld7 = new TreeNode(7,ld14,null);
        TreeNode ld6 = new TreeNode(6,ld12,ld13);
        TreeNode ld5 = new TreeNode(5,ld10,ld11);
        TreeNode ld4 = new TreeNode(4,ld17,ld9);
        TreeNode ld3 = new TreeNode(3,ld7,ld8);
        TreeNode ld2 = new TreeNode(2,ld5,ld6);
        TreeNode ld1 = new TreeNode(1,ld3,ld4);
        TreeNode ld0 = new TreeNode(0,ld1,ld2);

        System.out.println(minDepth(ld0));

        TreeNode a6 = new TreeNode(6);
        TreeNode a5 = new TreeNode(5,null,a6);
        TreeNode a4 = new TreeNode(4,null,a5);
        TreeNode a3 = new TreeNode(3,null,a4);
        TreeNode a2 = new TreeNode(2,null,a3);
        TreeNode a1 = new TreeNode(1,null,a2);

        System.out.println(minDepth(a1));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> dep = new LinkedList<>();
        int depth = 1;
        queue.add(root);
        dep.add(depth);

        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            depth = dep.poll();
            if(head.left == null && head.right == null){
                return depth;
            }else{
                if(head.left != null){
                    queue.add(head.left);
                    dep.add(depth+1);
                }
                if(head.right != null){
                    queue.add(head.right);
                    dep.add(depth+1);
                }
            }
        }

        return 1;
    }

}
