package com.devilor.link;

/**
 * 链表实现:不使用伪头的方式.
 *
 * @author PigPig
 * @date 2021/04/15 20:50
 **/
public class MyLinkedList2<T> {

    /**
     * 链表长度.
     */
    private int size;

    /**
     * 链表的节点属性.
     */
    private ListNode node;

    /**
     * 在指定的 index 位置增加元素.
     *
     * @param index 需要增加的节点的位置
     * @throws Exception 异常
     */
    public void addAtIndex(int index, T data) throws Exception {
        if (index < 0 || index > this.size) {
            throw new Exception(">>>>> index 无效!");
        }
        ListNode newNode = new ListNode();
        newNode.data = data;
        //如果 size == 0
        if (this.size == 0) {
            this.node = newNode;
            this.node.next = null;

        } else {
            //仅仅是一个移动的指针标识
            ListNode temp = this.node;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index 不合法！");
        }

        ListNode temp = this.node;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return (T) temp.data;
    }


    /**
     * @param index 元素位置
     * @author PigPig
     * @date 2021/04/18 01:10
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("index 无效！");
        }
        ListNode temp = this.node;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        if (index == 0) {
            this.node = temp.next;
        } else {
            temp.next = temp.next.next;
        }
        size--;
    }

    /**
     * ListNode:链表的节点对象.
     *
     * @param <T> 链表中要存放的 data 的数据类型.
     */
    private class ListNode<T> {

        T data;

        ListNode<T> next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList2{" +
                "size=" + size +
                ", node=" + node +
                '}';
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList2<String> stringMyLinkedList2 = new MyLinkedList2<>();
        stringMyLinkedList2.addAtIndex(0, ">>>>>> 0");
        stringMyLinkedList2.addAtIndex(1, ">>>>>> 1");
        stringMyLinkedList2.addAtIndex(2, ">>>>>> 2");
        stringMyLinkedList2.addAtIndex(3, ">>>>>> 3");
        System.out.println(stringMyLinkedList2);
        String s = stringMyLinkedList2.get(1);
        System.out.println(s);
        String s3 = stringMyLinkedList2.get(3);
        System.out.println(s3);
        stringMyLinkedList2.deleteAtIndex(0);
        System.out.println(stringMyLinkedList2);
    }

}
