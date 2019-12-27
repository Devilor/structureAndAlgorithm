package com.ernesto.stack;

import java.util.Arrays;

/**
 * @author Ernesto
 * @date 2019/12/27
 */
public class TestDriver {
    public static void main(String[] args) {
        EStack<String> stack = new EStack<String>(4);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        System.out.println(Arrays.toString(stack.getData()));
        stack.pop();
        System.out.println(Arrays.toString(stack.getData()));
    }
}
