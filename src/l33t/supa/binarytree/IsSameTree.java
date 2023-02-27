package l33t.supa.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode nd2 = new TreeNode(2);
        TreeNode nd1 = new TreeNode(1, null, nd2);
        TreeNode nd4 = new TreeNode(4);
        TreeNode nd3 = new TreeNode(3, nd1, nd4);
        TreeNode nd7 = new TreeNode(7);
        TreeNode nd8 = new TreeNode(8, nd7, null);
        TreeNode nd6 = new TreeNode(6, null, nd8);
        TreeNode nd5 = new TreeNode(5, nd3, nd6);

        TreeNode sd2 = new TreeNode(2);
        TreeNode sd1 = new TreeNode(1, null, sd2);
        TreeNode sd4 = new TreeNode(4);
        TreeNode sd3 = new TreeNode(3, sd1, sd4);
        TreeNode sd7 = new TreeNode(7);
        TreeNode sd8 = new TreeNode(8, sd7, null);
        TreeNode sd6 = new TreeNode(6, null, sd8);
        TreeNode sd5 = new TreeNode(5, sd3, sd6);

        TreeNode kd1 = new TreeNode(1,null,null);
        TreeNode kd2 = new TreeNode(2,kd1,null);
        TreeNode kd3 = new TreeNode(3,kd2,null);
        TreeNode kd4 = new TreeNode(4,kd3,null);
        TreeNode kd5 = new TreeNode(5,kd4,null);
        TreeNode kd6 = new TreeNode(6,kd5,null);
        TreeNode kd7 = new TreeNode(7,kd6,null);
        TreeNode kd8 = new TreeNode(8,kd7,null);

        TreeNode nll = null;
        TreeNode tn2 = new TreeNode(2,null,null);
        TreeNode tn1 = new TreeNode(1,null,tn2);
        TreeNode n1 = new TreeNode(1,null,null);

//        System.out.println(isSameTree(sd5,nd5));
//        System.out.println(isSameTree(sd5,kd8));
        System.out.println(isSameTree(n1,tn1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==null && q==null;
        }

        Queue<TreeNode> pQue = new LinkedList<>();
        Queue<TreeNode> qQue = new LinkedList<>();
        pQue.add(p);
        qQue.add(q);
        TreeNode phead,qhead;


        while(!pQue.isEmpty()){
            if(qQue.isEmpty()) return false;

            phead = pQue.poll();
            qhead = qQue.poll();
            if(phead.val != qhead.val) return false;

            if(phead.left != null){
                if(qhead.left == null) return false;
                TreeNode pleft = phead.left;
                TreeNode qleft = qhead.left;
                pQue.add(pleft);
                qQue.add(qleft);
            }else{
                if(qhead.left != null) return false;
            }

            if(phead.right != null){
                if(qhead.right == null) return false;
                TreeNode pright = phead.right;
                TreeNode qright = qhead.right;
                pQue.add(pright);
                qQue.add(qright);
            }else{
                if(qhead.right != null) return false;
            }
        }

        return qQue.isEmpty();
    }

}
