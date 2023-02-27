package l33t.supa.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static void print(ListNode head){
        System.out.print(head.val);
        while (head.next != null){
            head = head.next;
            System.out.print(" -> " + head.val);
        }
    }
}
