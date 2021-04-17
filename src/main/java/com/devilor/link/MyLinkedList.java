package com.devilor.link;

/**
 * 自己实现链表.
 *
 * @author PigPig
 * @date 2021/04/12 23:26
 */
public class MyLinkedList<T> {

    /**
     * 链表的长度.
     */
    private Integer size;

    /**
     * 哨兵伪头.
     */
    private ListNode sentinel;

    private class ListNode {

        private T data;

        private ListNode next;

        public ListNode(ListNode index, T data) {
            this.next = index;
        }

        public ListNode() {
        }

    }

    /**
     * 构造方法.
     *
     * @author PigPig
     * @date 2021/04/15 21:29
     */
    public MyLinkedList() {
        this.size = 0;
        this.sentinel = new ListNode();
    }

    /**
     * 获取指定 index 位置的节点.
     *
     * @param index 索引
     * @return T
     * @author PigPig
     * @date 2021/04/13 01:01
     */
    public T get(Integer index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("index 无效！");
        }
        // 声明一个移动查找的指针，以伪头节点为开始往后查找
        ListNode movableIndex = this.sentinel;
        // for (int i = 0, length = this.size; i < length; i++) {
        for (int i = 0; i <= index; i++) {
            // 跳过伪头节点查找
            movableIndex = movableIndex.next;
        }
        return movableIndex.data;
    }

    /**
     * 在指定的位置添加元素节点.
     *
     * @param index 索引
     * @param data 数据
     * @author PigPig
     * @date 2021/04/15 21:31
     */
    public void addAtIndex(int index, T data) throws Exception {
        if (index < 0 || index > this.size) {
            // 我特么直接手动扔出这个异常
            throw new Exception("index 无效!");
        }
        // 判断满足插入的条件后,首先想到移动一个位置，即：size++
        size++;
        // 分析：只要拿到 index 即：待插入的位置的节点即可(此处可以直接调用 get 方法),因为是在当前 index 位置节点的后面插入
        // 声明一个移动的指针，记录移动的位置,从哨兵伪头开始
        ListNode targetIndex = this.sentinel;
        // i < index:为什么不能是 i <= index,是因为要跳过伪头
        for (int i = 0; i < index; i++) {
            // 此时可以这样理解：targetIndex.next
            // 为了便于理解，在这里可以理解为就是那个伪头之后的节点(i = 0)或者是
            // index 位置原来的节点(i > 0)，而不要认为它是一个指向下个节点的指针
            targetIndex = targetIndex.next;
        }
        // 新节点的后继指针指向了以前该位置节点的后继节点，因为既然是插入 index 位置，那么就是一种替换了原来 index 位置的过程，
        // 原来 index 位置节点的场景要用新的节点来表达
        // 然后再将原来当前位置的节点的后继指针指向待插入的节点,此流程的顺序不能颠倒,
        // 否则就无法定位原来当前节点的后继节点位置了

        // 创建一个新的待插入的节点
        ListNode toInsertNode = new ListNode();
        // 赋值语句，从等号后面往前解释：
        // targetIndex.next => index 位置原来节点的后继节点指针
        // toInsertNode => index 当前要插入的节点
        // toInsertNode.next => index 当前位置要插入节点的后继节点指针
        // toInsertNode 当前要替换 targetIndex 节点，所以，targetIndex 的后继节点原来指向谁,现在由 toInsertNode 来表达,
        // 即：toInsertNode.next = targetIndex.next
        toInsertNode.next = targetIndex.next;
        toInsertNode.data = data;

        // 走到这里,原来 index 位置节点: targetIndex 已经断开了和它的原来后继节点的指向关系,它后面的节点应该是新插入的节点,
        // 由此可知,应该用 targetIndex.next = toInsertNode 来表达它和它后面节点 -- 新插入的节点 -- 的前后关联关系
        targetIndex.next = toInsertNode;
    }

    /**
     * 删除指定 index 位置的元素节点.
     *
     * @param index 索引
     * @return T
     * @author PigPig
     * @date 2021/04/15 21:32
     */
    public T deleteAtIndex(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("index 无效！");
        }
        // 满足删除条件之后,先长度减少,避免删的过瘾忘记了
        this.size--;
        ListNode targetIndex = this.sentinel;
        // 首先定义好查找的范围,可以使用 get 方法,可是我就不,我就喜欢写
        for (int i = 0; i < index; i++) {
            targetIndex = targetIndex.next;
        }
        // 思路:找到 index 位置的原来的节点,删除
        targetIndex.next = targetIndex.next.next;
        return targetIndex.data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode node = this.sentinel.next;
        for (int index = 0; index < this.size; index++) {
            stringBuilder
                    .append(">>>>>> index : value ==> ")
                    .append(index)
                    .append("=====")
                    .append(node.data)
                    .append("\n");
            node = node.next;
        }
        return stringBuilder.toString();
    }

    /**
     * 当前类 main 方法.
     *
     * @param args 参数列表
     * @author PigPig
     * @date 2021/04/15 21:28
     */
    public static void main(String[] args) throws Exception {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.addAtIndex(0, "1");
        String s = stringMyLinkedList.toString();
        System.out.println(s);
        String s2 = stringMyLinkedList.deleteAtIndex(0);
        System.out.println(stringMyLinkedList.toString());
    }

}
