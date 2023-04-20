package LC;

public class _2487_RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(13);
        ListNode nodeFour = new ListNode(3);
        ListNode nodeFive = new ListNode(8);

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;

        ListNode returnList = removeNodes(head);
        while (returnList != null) {
            System.out.println(returnList.val);
            returnList = returnList.next;
        }

    }

    public static ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;

        head.next = removeNodes(head.next);

        if (head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode () {}
        public ListNode (int val) {this.val = val;}
        public ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
