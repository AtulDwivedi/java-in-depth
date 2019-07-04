package com.atuldwivedi.jid.ds.linkedlist;

import static java.util.Optional.ofNullable;

public class LinkedListTest {


    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);
        Node nodeFive = new Node(3);
        Node nodeSix = new Node(2);
        Node nodeSeven = new Node(1);

        LinkedList simpleLinkedList = new LinkedList();
        simpleLinkedList.add(nodeTwo);
        simpleLinkedList.add(nodeThree);
        simpleLinkedList.add(nodeFive);
        simpleLinkedList.add(nodeSix);
        simpleLinkedList.add(0, nodeOne);
        simpleLinkedList.add(3, nodeFour);
        simpleLinkedList.add(6, nodeSeven);
        simpleLinkedList.printLinkedList();
        Node middle = simpleLinkedList.getMiddle();
        System.out.println(middle.data);
//        simpleLinkedList.reverse();
        simpleLinkedList.printLinkedList();
        System.out.println(simpleLinkedList.isPalindrome());
        simpleLinkedList.printLinkedList();


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

        ofNullable(getLinkedList().getMiddle()).ifPresent(it -> System.out.println(it.data));
        System.out.println(getLinkedList(1, 2, 3, 2, 1).getMiddle().data);
        System.out.println(getLinkedList(1, 2, 3, 4, 2, 1).isPalindrome());
        System.out.println(getLinkedList(1, 2, 3, 4, 5).elementFromEnd(10));
    }

    private static LinkedList getLinkedList(Integer... elements) {
        if (elements == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (Integer element : elements) {
            linkedList.add(new Node(element));
        }
        return linkedList;
    }
}
