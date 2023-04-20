package LC;

public class _21_MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        ListNode returnNext = new ListNode();
        ListNode tailNode = returnNext;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tailNode.next = list1;
                list1 = list1.next;
            } else {
                tailNode.next = list2;
                list2 = list2.next;
            }
            tailNode = tailNode.next;
        }
        tailNode.next = list1 != null ? list1 : list2;
        return returnNext.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode () {}
        public ListNode (int val) {
            this.val = val;
        }
        public ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


