package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Use this nested class for storing the values of the LinkedList. Each
    // LinkedList.Node contains the value at its index, and a link to the
    // LinkedList.Node at the next index (called the "child" here). If the child
    // is null, that denotes the last element of the LinkedList.
    class Node {
        public Object value;
        public Node child;

        public Node(Object value) {
            this(value, null);
        }

        public Node(Object value, Node child) {
            this.value = value;
            this.child = child;
        }
    }

    public int size() {
        return size;
    }

    public LinkedList prepend(Object value) {
        // throw Kamayan.todo(
        //     "The prepend(Object) method should prepend the argument to the",
        //     "beginning of this LinkedList and increase the size by 1. The",
        //     "return value must be this."
        // );

        // head = new Node(value, head);
        // size++;

        return null;
        // return this;
    }

    public LinkedList add(Object value) {
        // throw Kamayan.todo(
        //     "The add(Object) method should append the argument to the end of",
        //     "this LinkedList and increase the size by 1. The return value must",
        //     "be this."
        // );

        Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;

            while (currentNode.child != null){
                currentNode = currentNode.child;
            }

            currentNode.child = node;
        }

        size++;

        return this;
    }

    public Object delete(int index) {
        // throw Kamayan.todo(
        //     "The delete(int) method should delete the value at the provided",
        //     "index and return it. The size should be 1 less than it was before",
        //     "this method was called. The index must be within the bounds of the",
        //     "LinkedList, or an IndexOutOfBoundsException should be thrown."
        // );

        checkBounds(index);

        Object deleteValue;

        if (index == 0) {
            deleteValue = head.value;
            head = head.child;
            return deleteValue;
        }

        Node currentNode = goToNodeIndex(index-1);

        deleteValue = currentNode.child.value;

        currentNode.child = currentNode.child.child;
        // size;
        return deleteValue;
    }

    public Object get(int index) {
        // throw Kamayan.todo(
        //     "The get(int) method should retrieve the value at the given index.",
        //     "The index must be within the bounds of the LinkedList, or an",
        //     "IndexOutOfBoundsException should be thrown."
        // );

        checkBounds(index);
        Node currentNode = goToNodeIndex(index);

        return currentNode.value;
    }

    public Object set(int index, Object value) {
        // throw Kamayan.todo(
        //     "The set(int, Object) method should set the value at the index",
        //     "defined in the first argument such that list.get(index) will",
        //     "return the second argument.",
        //     "",
        //     "If the index is negative, an IndexOutOfBoundsException should be",
        //     "thrown.",
        //     "",
        //     "If the index is bigger than the current size of the linked list,",
        //     "the links should be adjusted to fit the new index. All indexes",
        //     "between the former last element and the new index should be",
        //     "initialized with null.",
        //     "",
        //     "The size after this method is called depends on the index",
        //     "provided. An existing index would not affect the size, but an",
        //     "index greater than the last index will add the difference to the",
        //     "size.",
        //     "",
        //     "This method should return the value that was previously in the",
        //     "given index, or null if that does not apply."
        // );

        checkLowerBound(index);

        // if (head == null) {
        //     head = new Node(null);
        //     size++;
        // }

        // Node currentNode = head;

        // for (int i = 0; i < index; i++){
        //     if (currentNode.child == null) {
        //         currentNode.child = new Node(null);
        //         size++;
        //     }

        //     currentNode = currentNode.child;
        // }

        Node currentNode = goToNodeIndex(index);

        Object oldValue  = currentNode.value;

        currentNode.value = value;

        return oldValue;
    }

    private void checkBounds(int index) {
        checkLowerBound(index);
        checkUpperBound(index);
    }

    private void checkLowerBound(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void checkUpperBound(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private Node goToNodeIndex (int index){
        if (head == null) {
            head = new Node(null);
            size++;
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++){
            if (currentNode.child == null) {
                currentNode.child = new Node(null);
                size++;
            }

            currentNode = currentNode.child;
        }

        return currentNode;
    }
}
