package com.atuldwivedi.jid.ds.linkedlist;

public class LinkedListTest {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Node(1));
        linkedList.add(new Node(2));
        Node NODE = new Node(3);
        linkedList.add(NODE);
        linkedList.add(new Node(4));
        Node node = new Node(6);
        linkedList.add(node);


        Node someNode = new Node(5);
        linkedList.add(someNode, 4);
        linkedList.add(new Node(77), 100);

        linkedList.add(new Node(0), 0);

        node.next = NODE;
        linkedList.detectAndRemoveLoop();
        if (linkedList.isLoopPresent()) {
            System.out.println("Provided linked list has loop, traversing on such list not allowed.");
            System.out.println("Nodes in Loop: " + linkedList.detectAndCountNodesInLoop());
        } else {
            linkedList.printLinkedList();
        }

        System.out.println("Size of linked list: " + linkedList.size());
    }
}
