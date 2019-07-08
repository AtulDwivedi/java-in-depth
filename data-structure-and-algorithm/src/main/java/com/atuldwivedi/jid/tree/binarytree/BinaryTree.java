package com.atuldwivedi.jid.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (true) {
            int nodeCountPerLevel = queue.size();

            if (nodeCountPerLevel == 0) {
                return height;
            }

            height++;

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


}

class Node {
    Integer data;

    Node left;

    Node right;

    public Node(Integer data) {
        this.data = data;
    }
}
