package LC;

public class _206_ReverseLinkedListRecursively {
    public static void main(String[] args) {

    }

    /*
    * Recursive solution:
    * */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode helper = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return helper;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

/*
* Iterative solution:
*
*     public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode helper = curr.next;
            curr.next = prev;
            prev = curr;
            curr = helper;
        }

        return prev;
    }

*
* Recursive solution:
*
*
* */