package l33t.supa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode nd2 = new TreeNode(2);
        TreeNode nd1 = new TreeNode(1, null, nd2);
        TreeNode nd4 = new TreeNode(4);
        TreeNode nd3 = new TreeNode(3, nd1, nd4);
        TreeNode nd7 = new TreeNode(7);
        TreeNode nd8 = new TreeNode(8, nd7, null);
        TreeNode nd6 = new TreeNode(6, null, nd8);
        TreeNode nd5 = new TreeNode(5, nd3, nd6);

        List<Integer> result = inorderTraversal(nd5);

        for (int i:result) {
            System.out.print(", " + i);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode head = root;
        boolean left = true;

        while(head != null){
            if(left && head.left != null){
                TreeNode node = head;
                nodeStack.push(node);
                head = head.left;
            }else{
                result.add(head.val);
                if (head.right != null){
                    head = head.right;
                    left = true;
                }else if(!nodeStack.empty()){
                    head = nodeStack.pop();
                    left = false;
                }else{
                    head = null;
                }
            }
        }

        return result;
    }

}
