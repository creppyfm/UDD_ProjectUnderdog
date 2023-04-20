package LC;

public class _876_MiddleOfLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        ListNode right = head, left = head;
        int counter = 0;

        while (right != null) {
            right = right.next;
            counter++;
        }

        int n = (counter / 2);
        for (int i = 1; i <= n; i++) {
            left = left.next;
        }

        return left;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode (int val) {this.val = val;}
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
