package l33t.supa.linkedList;

public class deleteDuplicatesSorted {
    public static void main(String[] args) {
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln3d = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln6d = new ListNode(6);
        ListNode ln6dd = new ListNode(6);
        ListNode ln10 = new ListNode(10);
        ListNode ln13d = new ListNode(13);
        ListNode ln13 = new ListNode(13);

        ln2.next = ln3;
        ln3.next = ln3d;
        ln3d.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln6d;
        ln6d.next = ln6dd;
        ln6dd.next = ln10;
        ln10.next = ln13d;
        ln13d.next = ln13;

        ListNode head = deleteDuplicates(ln2);
        ListNode.print(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while (current.next != null){
            if(current.val == prev.val){
                prev.next = current.next;
            }else{
                prev = current;
            }
            current = current.next;
        }
        if(prev.val == current.val){
            prev.next = null;
        }
        return head;
    }
}


