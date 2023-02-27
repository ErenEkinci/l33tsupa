package l33t.supa.linkedList;

public class MergeSortedLists {
    public static void main(String[] args) {
        test2();

    }

    private static void test2() {
        ListNode ln3 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln0 = new ListNode(0);
        ListNode ln_4 = new ListNode(-4);

        ln3.next = ln2;
        ln2.next = ln0;
        ln0.next = ln_4;
        ln_4.next = ln2;

        System.out.println(hasCycle(ln3));;
    }
    private static void test1() {
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln10 = new ListNode(10);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln13 = new ListNode(13);

        ln2.next = ln3;
        ln3.next = ln10;

        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln13;

        ListNode sorted = mergeTwoLists(ln2,ln4);
        ListNode head = sorted;

        ListNode.print(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode temp = list1.val < list2.val ? list2 : list1;
        ListNode head = list1.val < list2.val ? list1 : list2;
        ListNode first = head;
        ListNode hold;

        while (head.next != null){

            if (head.next.val >= temp.val) {
                hold = head.next;
                head.next = temp;
                temp = hold;
            }
            head = head.next;
        }

        head.next = temp;

        return first;
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode initial = head;
        ListNode prev = null;
        ListNode next;

        while(head.next != null){
            next = head.next;
            if(next == initial){
                return true;
            }
            head.next = prev;
            prev = head;
            head = next;
        }

        return false;
    }
}
