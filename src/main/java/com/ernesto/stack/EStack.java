package com.ernesto.stack;

/**
 * @author Ernesto
 * @date 2019/12/26
 */
public class EStack<T> {
    //当前栈的大小
    private int size;
    //栈中存放数据的容器（数组模拟）
    private T[] data;

    public EStack(int maxSize) {
        this.data = (T[])new Object[maxSize];
    }

    public EStack() {
        this.data = (T[])new Object[10];
    }

    public T[] getData() {
        return data;
    }

    /**
     * 判断栈是否已满
     *
     * @return
     */
    public Boolean isFull() {
        if (size == this.data.length) {
            return true;
        }
        return false;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * 栈扩容方法
     * 每次扩大为当前栈大小的 2 倍
     */
    private void resize(int newSize) {
        T[] resizeData = (T[])new Object[newSize];
        //使用 JDK 自带数组 Copy 方法
        //System.arraycopy(this.data, 0, resizeData, 0, this.maxSize);
        //手撸
        for (int i = 0; i < size; i++) {
            resizeData[i] = this.data[i];
        }
        this.data = resizeData;
        resizeData = null;
    }

    /**
     * 新增元素到栈中
     *
     * @param item
     */
    public void push(T item) {
        //是否已满①扩容②抛出异常
        if (isFull()) {
            //① 手动抛出异常
            //throw new RuntimeException("栈空间已满！");
            //② 自动扩容
            this.resize(size * 2);
        }
        this.data[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = this.data[--size];
        this.data[size] = null;
        if (size > 0 && size == this.data.length / 4) {
            this.resize(size / 2);
        }
        return item;
    }
}
