package com.ernesto.stack;

/**
 * 借助链表实现 Stack
 *
 * @author Ernesto
 * @date 2019/12/27
 */
public class EStackByLinked<T> {
    private Node head;
    private int size;

    private class Node {
        Node next;
        T data;
    }

    public void push(T item) {
        Node oldHead = head;
        head = new Node();
        head.next = oldHead;
        head.data = item;
        size++;
    }

    public T pop() {
        T item = head.data;
        head = head.next;
        size--;
        return item;
    }

    public Boolean isEmpty() {
        return (size == 0 || this.head == null);
    }

    public int size() {
        return this.size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>();
    }

    private class Iterator<T> implements java.util.Iterator<T> {
        private Node currentNode = head;

        public boolean hasNext() {
            return currentNode != null;
        }

        public T next() {
            T result = (T)currentNode.data;
            currentNode = currentNode.next;
            return result;
        }

        public void remove() {
            System.out.println("不支持该操作！");
        }
    }
}
