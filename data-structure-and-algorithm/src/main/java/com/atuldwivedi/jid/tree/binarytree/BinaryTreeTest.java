package com.atuldwivedi.jid.tree.binarytree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Let us create a binary tree shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(100);
        System.out.println("Height of tree is " + tree.height(tree.root));
    }
}
