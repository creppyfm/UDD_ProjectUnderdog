package LC;

public class _21_MergeTwoSortedListsRecursively {
    public static void main(String[] args) {
        ListNode list3 = new ListNode(3);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list4 = new ListNode(4);

        list1.next = list4;
        list2.next = list3;

        printList(list1);
        System.out.println("");
        printList(list2);
        System.out.println("");

        ListNode returnList = mergeTwoLists(list1, list2);
        printList(returnList);
    }


    public static ListNode mergeTwoLists(ListNode left, ListNode right) {
        /*
        Base case: left or right == null. In this case, we return the opposite node.
        This means we have reached the end of one (or both) of the lists, and
        we should set the 'next' node equal to the remaining nodes in the opposite list.
        */
        if (left == null) return right;
        if (right == null) return left;

        /*
        Recursive case: left.val < right.val et vice versa. In this case, we set
        curr.next == the return from a recursive call. To this recursive call, we
        pass the 'next' node of curr and the head of the other list.
        */
        if (left.val < right.val) {
            left.next = mergeTwoLists(left.next, right);
            return left;
        } else {
            right.next = mergeTwoLists(left, right.next);
            return right;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode () {}
        public ListNode (int val) {this.val = val;}
        public ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;}
    }

    public static void printList(ListNode list) {
        ListNode curr = list;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }

    }
}
