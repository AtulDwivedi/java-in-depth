package com.atuldwivedi.jid.tree.binarytree;

import java.util.Stack;

public class InorderTraversalWithoutRecursionWithStack {

    static void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inorder(root);
    }
}
