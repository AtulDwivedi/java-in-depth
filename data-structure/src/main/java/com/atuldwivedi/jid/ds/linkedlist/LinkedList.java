package com.atuldwivedi.jid.ds.linkedlist;

import static java.lang.String.format;

public class LinkedList {

    private Node head;

    /**
     * Adds node at the end of the list
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }

        if (head == null) {
            head = node;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    /**
     * Adds element at specified index iff index < linked list size + 2.
     *
     * @param index
     * @param node
     */
    public void add(int index, Node node) {
        if (node == null || index < 0) {
            return;
        }

        if (head == null && index == 0) {
            head = node;
            return;
        }

        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }

        Node current = head;
        int counter = 0;
        while (current.next != null && counter < index - 1) {
            current = current.next;
            counter += 1;
        }

        if (counter + 1 == index) {
            Node temp = current.next;
            current.next = node;
            node.next = temp;
        }

    }


    public void printLinkedList() {
        assert (isLoopPresent());
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(format("%d -> ", current.data));
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean isLoopPresent() {

        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int size = 0;
        if (!isLoopPresent()) {
            if (head == null) {
                return size;
            }
            size = 1;
            Node current = head;
            while (current.next != null) {
                current = current.next;
                size += 1;
            }
        }
        return size;
    }

    public int detectAndCountNodesInLoop() {
        int nodesInLoop = 0;
        if (head == null) {
            return nodesInLoop;
        }
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node temp = slow;
                nodesInLoop += 1;
                while (temp.next != slow) {
                    nodesInLoop += 1;
                    temp = temp.next;
                }
                break;
            }
        }
        return nodesInLoop;
    }

    public void detectAndRemoveLoop() {
        if (head == null) {
            return;
        }
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                break;
            }

        }
    }

    public Node getMiddle() {
        if (head == null) {
            return null;
        }

        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reverse() {
        Node prev = null, next;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node reverseFromNode(Node node) {
        Node prev = null, next;
        Node current = node;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public boolean compareWith(Node anotherListHead) {
        Node thisHead = head;
        Node otherHead = anotherListHead;
        while (thisHead != null && anotherListHead != null) {
            if (thisHead.data == otherHead.data) {
                thisHead = thisHead.next;
                otherHead = otherHead.next;
            } else {
                return false;
            }
        }

        return thisHead == null && otherHead == null;
    }

    public boolean isPalindrome() {
        if (head == null && head.next == null) {
            return true;
        }

        Node slow = head, fast = head, prevOfSlow = head;
        Node middle = null, secondHalf = null;

        while (fast != null && fast.next != null) {
            prevOfSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            middle = slow;
            slow = slow.next;
        }

        secondHalf = slow;
        prevOfSlow.next = null;

        secondHalf = reverseFromNode(secondHalf);

        boolean result = true;
        Node thisHead = head;
        Node otherHead = secondHalf;
        while (thisHead != null && secondHalf != null) {
            if (thisHead.data == otherHead.data) {
                thisHead = thisHead.next;
                otherHead = otherHead.next;
            } else {
                result = false;
                break;
            }
        }
        secondHalf = reverseFromNode(secondHalf);

        if (middle != null) {
            prevOfSlow.next = middle;
            middle.next = secondHalf;
        } else {
            prevOfSlow.next = secondHalf;
        }
        return result;
    }
}
