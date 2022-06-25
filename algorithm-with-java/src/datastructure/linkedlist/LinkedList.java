package datastructure.linkedlist;

public class LinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    private Node<E> head;
    private Node<E> current;
    private Node<E> tail;
    private int size = 0;

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(E data){
        if (size == 0) {
            addFirst(data);
        } else {
            Node<E> newNode = new Node<>(data);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    Node<E> node(int index) {
        Node<E> target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }

    public void add(int k, E data) {
        if (k == 0) {
            addFirst(data);
        } else {
            Node<E> temp1 = node(k - 1);
            Node<E> temp2 = temp1.next;

            Node<E> newNode = new Node<>(data);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public E removeFirst() {
        Node<E> temp = head;
        head = temp.next;
        E returnData = temp.data;
        temp = null;
        size--;

        return returnData;
    }

    public E remove(int k){
        if (k == 0) {
            return removeFirst();
        }

        Node<E> temp = node(k - 1);
        Node<E> deleteTarget = temp.next;
        temp.next = temp.next.next;
        E returnData = deleteTarget.data;
        if (deleteTarget == tail) {
            tail = temp;
        }
        deleteTarget = null;
        size--;
        return returnData;
    }

    public E removeLast() {
        return remove(size - 1);
    }
}
