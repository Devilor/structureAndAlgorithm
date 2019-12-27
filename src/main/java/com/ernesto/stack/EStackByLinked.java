package com.ernesto.stack;

/**
 * 借助链表实现 Stack
 *
 * @author Ernesto
 * @date 2019/12/27
 */
public class EStackByLinked<T> {
    //头结点
    private Node head;
    //链表长度
    private int size;

    /**
     * 封装 Node （抽象数据结构）
     * 因为客户代码不必关心链表节点的具体实现所以不能暴露出去
     */
    private class Node {
        Node next;
        T data;
    }

    /**
     * 栈添加方法（栈顶添加）
     * 思路：添加数据，其实就是往链表头部插入一个链接（链表上的每个元素姑且称呼为链接）
     * ① 首先用一个 Node 类型的引用来暂时指向插入前的头结点，因为不这样，插入新头部之后
     * 无法再获取以前头部节点
     * ② 然后创建一个新 Node 结构，将新链接的 next 指针指向原来头结点，插入的数据放到
     * 新链接的 data 数据项中
     * ③ size++
     *
     * @param item
     */
    public void push(T item) {
        Node oldHead = head;
        head = new Node();
        /**
         * 因为将添加的数据直接放在了待插入头部的 Node 中（新建 Node 的 data 位置）
         * 所以第一个头结点（最后会变成尾部节点）总是为 null
         */
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
