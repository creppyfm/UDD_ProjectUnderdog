package PracticeProblems.RecursionPractice;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GauntletTest extends Gauntlet {
    /*
        Capture console output.
    */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    /*
        Values for 'createLinkedListFromArray'
    */
    private static final int[] VALUES_ARR = { 1, 2, 3, 4, 5, 6, 7 };

    /*
        Prepare stream before test executes; Close afterwards.
    */
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /*
        Testing 'printsLinkedList' (41 - 61)
    */
    @Test
    @DisplayName("EMPTY_STRING_TRUE")
    void testPrintsLinkedList_NullNode() {
        ListNode head = null;
        printsLinkedList(head);
        assertEquals("", outContent.toString());
    }
    @Test
    @DisplayName("1_TRUE")
    void testPrintsLinkedList_SingleNode() {
        ListNode head = createLinkedListFromArray(new int[] { 1 });
        printsLinkedList(head);
        assertEquals("1", outContent.toString());
    }
    @Test
    @DisplayName("1234567_TRUE")
    void testPrintsLinkedList_LongerInput() {
        ListNode head = createLinkedListFromArray(VALUES_ARR);
        printsLinkedList(head);
        assertEquals("1234567", outContent.toString());
    }

    /*
        Testing 'convertsLinkedListToBinaryTree' (66 - 107)
    */
    @Test
    @DisplayName("NULL_TRUE")
    void testConvertsLinkedListToBinaryTree_NullInput() {
        ListNode head = null;
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        assertNull(root);
    }
    @Test
    @DisplayName("1/NULL/NULL_TRUE")
    void testConvertsLinkedListToBinaryTree_SingleNode() {
        ListNode head = createLinkedListFromArray(new int[] { 1 });
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        assertEquals(head.val, root.val);
        assertNull(root.right);
        assertNull(root.left);
    }
    @Test
    @DisplayName("2/1/3_TRUE")
    void testConvertsLinkedListToBinaryTree_LongerInput() {
        ListNode head = createLinkedListFromArray(new int[] { 1, 2, 3 });
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.right.val);
    }
    @Test
    @DisplayName("4/2/6/1/3/5/7/NULL/NULL/NULL/NULL_TRUE")
    void testConvertsLinkedListToBinaryTree_LongerBalancedTree() {
        ListNode head = createLinkedListFromArray(VALUES_ARR);
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        assertEquals(4, root.val);
        assertEquals(2, root.left.val);
        assertEquals(6, root.right.val);
        assertEquals(1, root.left.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.right.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }

    /*
        Testing 'printsBinaryTree' (112 - 143)
    */
    @Test
    @DisplayName("EMPTY_STRING_TRUE")
    void testPrintsBinaryTree_NullInput() {
        ListNode head = null;
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        printsBinaryTree(root);
        assertEquals("", outContent.toString());
    }
    @Test
    @DisplayName("1_TRUE")
    void testPrintsBinaryTree_SingleNode() {
        ListNode head = createLinkedListFromArray(new int[] { 1 });
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        printsBinaryTree(root);
        assertEquals("1", outContent.toString());
    }
    @Test
    @DisplayName("213_TRUE")
    void testPrintsBinaryTree_LongerInput() {
        ListNode head = createLinkedListFromArray(new int[] { 1, 2, 3 });
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        printsBinaryTree(root);
        assertEquals("213", outContent.toString());
    }
    @Test
    @DisplayName("4213657_TRUE")
    void testPrintsBinaryTree_ProperOrder() {
        ListNode head = createLinkedListFromArray(VALUES_ARR);
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        printsBinaryTree(root);
        assertEquals("4213657", outContent.toString());
    }


    /*
        Testing 'convertsBinaryTreeToNAryTree' (149 - )
    */
    @Test
    @DisplayName("NULL_TRUE")
    void testConvertsBinaryTreeToNAryTree_NullInput() {
        BinaryTreeNode root = null;
        NAryTreeNode nAryRoot = convertsBinaryTreeToNAryTree(root);
        assertNull(nAryRoot);
    }
    @Test
    @DisplayName("1_TRUE")
    void testConvertsBinaryTreeToNAryTree_SingleNode() {
        ListNode head = createLinkedListFromArray(new int[] { 1 });
        BinaryTreeNode root = convertsLinkedListToBinaryTree(head);
        NAryTreeNode nAryRoot = convertsBinaryTreeToNAryTree(root);
        assertEquals(1, nAryRoot.val);
        assertEquals(nAryRoot.val, root.val);
    }


    @Test
    @DisplayName("")
    void testMaxVal() {
    }

    @Test
    @DisplayName("")
    void testMaxValHelper() {
    }

    /*
        Quickly generate Linked List from 'VALUES_ARR'
    */
    private ListNode createLinkedListFromArray(int[] values) {
        ListNode head = null;
        ListNode current = null;

        for (int value : values) {
            if (current == null) {
                head = new ListNode(value);
                current = head;
            } else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return head;
    }

}