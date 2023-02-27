package l33t.supa.linkedList;

public class Intersection {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(11);
        ListNode a2 = new ListNode(12);
        ListNode b1 = new ListNode(21);
        ListNode b2 = new ListNode(22);
        ListNode b3 = new ListNode(23);
        ListNode c1 = new ListNode(31);
        ListNode c2 = new ListNode(32);
        ListNode c3 = new ListNode(33);

        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;
//        ListNode a = getIntersectionNode(a1,b1);
//        System.out.println(a != null ? a.val : 0);

        ListNode m1 = new ListNode(2);
        ListNode n1 = m1;
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;
        ListNode i = getIntersectionNode(m1,n1);
        System.out.println(i != null ? i.val : 0);

        ListNode t = null;
//        ListNode result = getIntersectionNode(t, m1);
//        System.out.println(result != null ? result.val : 0);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        ListNode prev, temp, tempA, tempB, tailA, tailB;
        tempA = headA;
        tempB = headB;
        int cA=0, cB=0, cAB=0;

        prev = null;
        temp = null;
        while (headA != null) {
            // reverse
            temp = headA.next;
            headA.next = prev;

            // re-adjust
            prev = headA;
            headA = temp;

            cA++;
        }

        // find tail and fix headA
        tailA = prev;
        headA = tempA;

        prev = null;
        temp = null;
        while (headB != null) {
            // reverse
            temp = headB.next;
            headB.next = prev;

            // re-adjust
            prev = headB;
            headB = temp;
            cAB++;
        }

        // find tail and fix head B
        tailB = prev;
        headB = tempB;

        if(tailB != tempA){
            // reverse both and return null
            prev = null;
            temp = null;
            while (tailA != null) {
                // reverse
                temp = tailA.next;
                tailA.next = prev;

                // re-adjust
                prev = tailA;
                tailA = temp;
            }

            prev = null;
            temp = null;
            while (tailB != null) {
                // reverse
                temp = tailB.next;
                tailB.next = prev;

                // re-adjust
                prev = tailB;
                tailB = temp;
            }

            return null;
        }

        prev = null;
        temp = null;
        while (tailA != null) {
            // reverse
            temp = tailA.next;
            tailA.next = prev;

            // re-adjust
            prev = tailA;
            tailA = temp;
            cB++;
        }

        System.out.println("cA : " + cA);
        System.out.println("cB : " + cB);
        System.out.println("cAB : " + cAB);

        int totalEdges = cA+cB+cAB;
        totalEdges = (totalEdges-1) / 2;
        int posA = totalEdges-cB;
        System.out.println("totalEdges : " + totalEdges);
        System.out.println("posA : " + posA);

        temp = headA;
        for (int i = 0; i < posA; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
