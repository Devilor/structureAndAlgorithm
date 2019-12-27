package com.ernesto.stack;

import java.util.Iterator;

/**
 * @author Ernesto
 * @date 2019/12/27
 */
public class TestDriver {
    public static void main(String[] args) {
        //testStackByArray();
        testStackByLinked();
    }

    public static void testStackByArray() {
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
        //System.out.println(Arrays.toString(stack.getData()));
        //System.out.println(stack.pop());
        //System.out.println(Arrays.toString(stack.getData()));
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(String.format("item - {%s}\n", iterator.next()));
        }
    }

    public static void testStackByLinked() {
        EStackByLinked<String> stack = new EStackByLinked<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");

        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.printf("item - {%s}\n",iterator.next());
        }
    }
}
