package LC;

import java.nio.file.Paths;

public class _24_SwapNodesInPairs {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSix = new ListNode(6);
        ListNode nodeSeven = new ListNode(7);

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;

        ListNode returnList = swapPairsIteratively(head);
        while (returnList != null) {
            System.out.println(returnList.val);
            returnList = returnList.next;
        }
    }

    /*
        Iterative solution:
    */
    public static ListNode swapPairsIteratively(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode prev = helper;
        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            left.next = right.next;
            right.next = left;
            prev.next = right;

            prev = left;
            left = left.next;
            if (left != null) {
                right = left.next;
            } else {
                break;
            }
        }
        return helper.next;
    }

    /*
        Recursive solution:
    */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; // covers odd and even length lists
        ListNode left = head;
        ListNode right = head.next;

        left.next = right.next;
        right.next = left;

        head = right; // reset head to be equal to new 'head' (right). This maintains the proper return (head)

        left.next = swapPairs(left.next); // connects tail of curr swapped pair to head of next swapped pair.

        return head;
    }

    public static ListNode swapPairsHelper(ListNode left, ListNode right) {
        if (right == null || left == null) return null;

        left.next = right.next;
        right.next = left;
        left = left.next;
        right = left.next;

        return swapPairsHelper(left, right);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

/*
* Recursion
*
* */
