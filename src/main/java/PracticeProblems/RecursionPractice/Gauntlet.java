package PracticeProblems.RecursionPractice;

import java.util.HashMap;
import java.util.Map;

public class Gauntlet {
    private static final int[] VALUES_ARR = { 3, 4, 5 };

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

        //1 - print linked list
        printsLinkedList(head);
        System.out.println("");

        //2 - convert linked list to binary tree
        //3 - print binary tree (dfs traversal)
        BinaryTreeNode binaryTreeNode = convertsLinkedListToBinaryTree(head);
        printsBinaryTree(binaryTreeNode);
        System.out.println("");

        //4 - convert binary tree to n-ary tree
        NAryTreeNode root = convertsBinaryTreeToNAryTree(binaryTreeNode);
        root.printChildren();
        System.out.println("");

        //5 - find max of binary tree
        int maxVal = maxVal(binaryTreeNode);
        System.out.print(maxVal);
        System.out.println("");

        ListNode headTEST = createLinkedListFromArray(VALUES_ARR);
        BinaryTreeNode btRoot = convertsLinkedListToBinaryTree(headTEST);
        System.out.println(maxVal(btRoot));
    }

    /*
        1. Print a linked list recursively - currently prints in reverse
    */
    public static void printsLinkedList(ListNode head) {
        if (head == null) return;

        printsLinkedList(head.next);

        System.out.print(head.val);

    }

    /*
        2. Turn linked list into binary tree (each node points to two others instead of one)
    */
    public static BinaryTreeNode convertsLinkedListToBinaryTree(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode mid = head;
        ListNode prev = null;

        /*
            Find mid of linked list
        */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = mid;
            mid = mid.next;
        }


        BinaryTreeNode root = new BinaryTreeNode(mid.val);
        if (prev != null) {
            prev.next = null;
            root.left = convertsLinkedListToBinaryTree(head);
        }
        root.right = convertsLinkedListToBinaryTree(mid.next);
        return root;
    }

    /*
        3. Print binary tree recursively
    */
    public static BinaryTreeNode printsBinaryTree(BinaryTreeNode root) {
        if (root == null) return null;

        System.out.print(root.val);
        printsBinaryTree(root.left);
        printsBinaryTree(root.right);

        return root;
    }

    /*
        4. Convert binary tree to n-ary tree (each node can have any number of children)
    */
    public static NAryTreeNode convertsBinaryTreeToNAryTree(BinaryTreeNode root) {
        if (root == null) return null;

        NAryTreeNode nAryRoot = new NAryTreeNode(root.val);
        if (root.left != null) {
            nAryRoot.addChild(convertsBinaryTreeToNAryTree(root.left));
        }
        if (root.right != null) {
            nAryRoot.addChild(convertsBinaryTreeToNAryTree(root.right));
        }

        return nAryRoot;
    }

    /*
        5. Find the max of the binary tree (keeping track of some info as you recurse)
    */
    public static int maxVal(BinaryTreeNode root) {
        int maxVal = root.val;
        return maxValHelper(root, maxVal);
    }

/*
    public static int maxValHelper(BinaryTreeNode root, int maxVal) {
        if (root.left != null) {
            maxVal = Math.max(maxVal, root.left.val);
            return maxVal;
        }

        if (root.right != null) {
            maxVal = Math.max(maxVal, root.right.val);
            return maxVal;
        }

        maxValHelper(root.left, maxVal);
        maxValHelper(root.right, maxVal);

        return Math.max(maxVal, root.val);
    }
*/

    public static int maxValHelper(BinaryTreeNode root, int maxVal) {
        if (root.left == null && root.right == null) return root.val;

        if (root.left != null) {
            maxVal = maxValHelper(root.left, maxVal);
            maxVal = Math.max(root.val, maxVal);
        }
        if (root.right != null) {
            maxVal = maxValHelper(root.right, maxVal);
            maxVal = Math.max(root.val, maxVal);

        }
        return maxVal;
    }

    /*
        Singly-Linked ListNode
    */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
        Binary TreeNode
    */
    public static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int val) {
            this.val = val;
        }
        BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        N-ary TreeNode
    */
    public static class NAryTreeNode {
        int val;
        Map<NAryTreeNode, Integer> children = new HashMap<>();
        NAryTreeNode(int val) {
            this.val = val;
        }

        void addChild(NAryTreeNode child) {
            this.children.putIfAbsent(child, child.val);
        }

        void printChildren() {
            this.children.forEach((node, child) -> {
                System.out.print(child);
            });
        }
    }

    private static ListNode createLinkedListFromArray(int[] values) {
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

/*
Problems:
    1. Print a linked list recursively
    2. Turn linked list into a binary tree (each node points to two others instead of one)
    3. Print that new binary tree recursively
    4. Convert binary tree to n-ary tree (each node can have any number of children)
    5. Find the max of the binary tree (keeping track of some info as you recurse)
*/