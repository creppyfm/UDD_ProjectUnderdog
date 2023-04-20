package LC;

public class _143_ReorderList {
    private static final int[] nodeVals = { 1, 2, 3, 4, 5 };
    private static final int[] nodeValsTwo = { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static void main(String[] args) {
        ListNode head = createsLinkedList(nodeValsTwo);

        reorderList(head);
        printList(head);
    }

    private static ListNode createsLinkedList(int[] nodeVals) {
        ListNode head = new ListNode(1);
        ListNode helper = head;
        for (int i = 1; i < nodeVals.length; i++) {
            helper.next = new ListNode(nodeVals[i]);
            helper = helper.next;
        }
        return head;
    }

    public static void reorderList(ListNode head) {
        ListNode stop = returnsRightHalf(head);

        ListNode left = head;
        ListNode right = reverseList(stop);
        ListNode tail = right;

        while (left != stop && right.next != null) {
            ListNode leftHelper = left.next;
            ListNode rightHelper = right.next;

            left.next = right;
            if (leftHelper != right) right.next = leftHelper;

            left = leftHelper;
            right = rightHelper;

        }

    }

    private static ListNode reverseList(ListNode head) {
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

    private static ListNode returnsRightHalf(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
