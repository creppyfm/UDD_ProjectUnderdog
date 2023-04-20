package LC;

public class _19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
    }

    /*
    * Iterative solution
    * */
/*
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode helper = new ListNode();
        helper.next = head;
        ListNode left = helper;
        ListNode right = helper;
        for (int i = n; i > 0; i--) {
            right = right.next;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return helper.next;
    }
*/

    /*
    * Recursive solution
    * */
    private ListNode mergeSortedList(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeSortedList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeSortedList(list1, list2.next);
            return list2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

