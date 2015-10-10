package com.collections;

/**
 * @author	Srinivas Reddy
 * @Email	srinivas96alluri@gmail.com
 */

public class SinglyLinkedList<Type> implements List<Type> {

    private Node<Type> head, tail;

    public SinglyLinkedList() {
        this.tail = this.head = new Node<>(null, null); 
    }

    /**
     * Adds an element at specified position
     *
     * @param data
     * @param pos [0 to length -1]
     * @return index
     */
    @Override
    public int addElement(Type data, int pos) {
        Node<Type> tmp = head;
        int index = 0;
        
        while (tmp != tail) {
            if (index++ == pos) {
                // Pass the reaming list address to append to new node
                tmp.next = new Node<>(data, tmp.next);
                return index - 1;
            }
            tmp = tmp.next;
        }
        // Adding element at last if position is more than list length
        tail = tmp.next = new Node<>(data, null);
        return index;
    }

    /**
     * Adds an element at the end of the SLL
     *
     * @param data
     * @return index
     */
    @Override
    public int addElement(Type data) {
        Node<Type> tmp = head;
        int index = 0;
        while (tmp != tail) {
            tmp = tmp.next;
            ++index;
        }
        tail = tmp.next = new Node<>(data, null);
        return index;
    }

    /**
     * Adds an element at the end of the SLL
     *
     * @param pos
     * @return true/false
     */
    @Override
    public boolean removeElement(int pos) {

        Node<Type> tmp = head;

        for (int index = 1; index < pos; ++index) {
            if (tmp == tail) {
                return false;
            }
            tmp = tmp.next;
        }

        if ((tmp.next != null) && (tmp.next.next != null)) {
            tmp.next = tmp.next.next;
        } else {
            tmp.next = null;
            tail = tmp;
        }
        return true;
    }

    /**
     * Returns a string representation of SLL
     *
     * @return String
     */
    @Override
    public String toString() {
        String result;
        result = new String();
        for (Node<Type> tmp = head.next; tmp != tail.next; tmp = tmp.next) {
            result += (tmp.data + "  ");
        }
        return result;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = head;
    }

    /* Creating node as an inner class avoid outside access */
    @SuppressWarnings("hiding")
	private class Node<Type> {

        private Type data;
        private Node<Type> next;

        public Node(Type data, Node<Type> next) {
            this.data = data;
            this.next = next;
        }
    }
}
