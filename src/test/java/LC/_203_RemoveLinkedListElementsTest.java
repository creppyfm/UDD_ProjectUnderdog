package LC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class _203_RemoveLinkedListElementsTest extends _203_RemoveLinkedListElements {

    @Test
    @DisplayName("123456_TRUE")
    void testRemoveElementsIteratively_LastElement() {
        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSix = new ListNode(6);
        ListNode nodeSeven = new ListNode(7);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;

        ListNode head = nodeOne;
        int val = 7;

        removeElementsIteratively(head, val);
        while (head != null) {
            assertTrue(head.val != val);
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    @DisplayName("234567_TRUE")
    void testRemoveElementsIteratively_FirstElement() {
        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSix = new ListNode(6);
        ListNode nodeSeven = new ListNode(7);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;

        int val = 1;
        ListNode head = removeElementsIteratively(nodeOne, val);

        while (head != null) {
            assertTrue(head.val != val);
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    @DisplayName("123567_TRUE")
    void testRemoveElementsIteratively_MiddleElement() {
        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSix = new ListNode(6);
        ListNode nodeSeven = new ListNode(7);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;

        ListNode head = nodeOne;
        int val = 4;

        removeElementsIteratively(head, val);
        while (head != null) {
            assertTrue(head.val != val);
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    @DisplayName("356_TRUE")
    void testRemoveElementsIteratively_FourElements() {
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

        int val = 4;
        ListNode head = removeElementsIteratively(nodeOne, val);

        while (head != null) {
            assertTrue(head.val != val);
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    @DisplayName("NULL_TRUE")
    void testRemoveElementsIteratively_ConsecutiveElements() {
        ListNode nodeOne = new ListNode(4);
        ListNode nodeTwo = new ListNode(4);
        ListNode nodeThree = new ListNode(4);
        ListNode nodeFour = new ListNode(4);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;

        int val = 4;
        ListNode head = removeElementsIteratively(nodeOne, val);

        while (head != null) {
            assertTrue(head.val != val);
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    @DisplayName("NULL_TRUE")
    void testRemoveElementsIteratively_EmptyList() {
        ListNode head = null;
        int val = 1;

        removeElementsIteratively(head, val);
        assertNull(head);
    }

    @Test
    @DisplayName("NULL_TRUE")
    void testRemoveElementsIteratively_OneElement() {
        ListNode nodeOne = new ListNode(1);
        nodeOne.next = null;

        int val = 1;
        ListNode head = removeElementsIteratively(nodeOne, val);

        assertNull(head);
    }

}