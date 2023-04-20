package LC;

public class _203_RemoveLinkedListElements {
    public static void main(String[] args) {

        ListNode nodeOne = new ListNode(4);
        ListNode nodeTwo = new ListNode(1);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSix = new ListNode(6);
        ListNode nodeSeven = new ListNode(4);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;

        ListNode head = removeElementsIteratively(nodeOne, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeElementsIteratively(ListNode head, int val) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) {
                    head = head.next;
                    curr = head;
                } else {
                    ListNode helper = curr;
                    prev.next = curr.next;
                    curr = curr.next;
                    helper.next = null;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    /*private static ListNode removeElements(ListNode head, int val) {
        //base case
        if(head.next == null) return head;
        //recursive
        ListNode prev = head;
        head = head.next;
        if (head.val == val)
        return removeElements(head, val);
    }*/


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


//first element matches condition
//last element matches condition