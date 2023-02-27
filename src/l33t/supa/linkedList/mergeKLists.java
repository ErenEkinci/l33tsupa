package l33t.supa.linkedList;

import java.util.Arrays;

public class mergeKLists {
    public static void main(String[] args) {
        test0();
    }

    private static void test0() {
        ListNode[] lists = new ListNode[0];
        ListNode sorted = mergeKLists(lists);
        ListNode head = sorted;

        ListNode.print(head);
    }

    private static void test1() {
        ListNode[] lists = new ListNode[3];

        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln10 = new ListNode(10);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln13 = new ListNode(13);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ListNode ln16 = new ListNode(16);
        ListNode ln23 = new ListNode(23);

        ln2.next = ln3;
        ln3.next = ln10;

        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln13;

        ln7.next = ln8;
        ln8.next = ln16;
        ln16.next = ln23;

        lists[0] = ln2;
        lists[1] = ln4;
        lists[2] = ln7;
        Arrays.stream(lists).forEach(ListNode::print);

        ListNode sorted = mergeKLists(lists);
        ListNode head = sorted;

        ListNode.print(head);
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head, current;
        if(lists.length == 0) return null;

        int smallest = smallest(lists);
        if(smallest == -1) return null;
        head = lists[smallest];
        current = head;

        lists[smallest] = lists[smallest].next;

        smallest = smallest(lists);
        while (smallest != -1) {
            current.next = lists[smallest];
            current = lists[smallest];
            lists[smallest] = lists[smallest].next;
            smallest = smallest(lists);
        }
        return head;
    }

    public static int smallest(ListNode[] heads){
        if (heads.length<1) return -1;
        ListNode small = null;
        int min = -1;
        for (int i = 0; i < heads.length; i++) {
            if(heads[i] != null) {
                if(small == null || small.val > heads[i].val){
                    small = heads[i];
                    min = i;
                }
            }
        }
//        if(min != -1)
//            System.out.println(heads[min].val);
        return min;
    }
}
