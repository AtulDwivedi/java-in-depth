package com.atuldwivedi.jid.ds.linkedlist;

public class LinkedListTest {


    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);
        Node nodeFive = new Node(5);
        Node nodeSix = new Node(6);
        Node nodeSeven = new Node(7);

        LinkedList simpleLinkedList = new LinkedList();
        simpleLinkedList.add(nodeTwo);
        simpleLinkedList.add(nodeThree);
        simpleLinkedList.add(nodeFive);
        simpleLinkedList.add(nodeSix);
        simpleLinkedList.add(0, nodeOne);
        simpleLinkedList.add(3, nodeFour);
        simpleLinkedList.add(6, nodeSeven);
        simpleLinkedList.printLinkedList();
        System.out.println(simpleLinkedList.getMiddle().data);


        LinkedList linkedList = new LinkedList();
        linkedList.add(new Node(1));
        linkedList.add(new Node(2));
        Node NODE = new Node(3);
        linkedList.add(NODE);
        linkedList.add(new Node(4));
        Node node = new Node(6);
        linkedList.add(node);


        Node someNode = new Node(5);
        linkedList.add(4, someNode);
        linkedList.add(100, new Node(77));

        linkedList.add(0, new Node(0));

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
