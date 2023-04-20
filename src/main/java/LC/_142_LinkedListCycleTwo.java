package LC;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _142_LinkedListCycleTwo {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;

            detectCycle(node1);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode pointer = head;
        Set<ListNode> visited = new HashSet<>();

        while (visited.add(pointer)) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return null;
            }
        }
        return pointer;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode (int val) {
            this.val = val;
            this.next = null;
        }
    }
}
