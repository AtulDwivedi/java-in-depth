package com.atuldwivedi.jid.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    static int maxWidth(Node node) {
        if (node == null) {
            return 0;
        }

        int width = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (true) {
            int nodeCountPerLevel = queue.size();
            if (nodeCountPerLevel == 0) {
                return width;
            }

            width = Math.max(width, nodeCountPerLevel);

            while (nodeCountPerLevel > 0) {
                Node temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }

                nodeCountPerLevel--;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(100);
        System.out.println("Height of tree is " + maxWidth(root));
    }
}
