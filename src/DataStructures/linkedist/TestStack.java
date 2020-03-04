package DataStructures.linkedist;

import java.util.Stack;

/**
 * @author yichangkong
 * @create 2020-03-04-15:55
 * 简单演示stack栈 的基本使用
 */
public class TestStack {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        //入栈

        stack.add("java");
        stack.add("SE");
        stack.add("EE");

        //出栈
        while (stack.size() > 0) {

            System.out.println(stack.pop());//pop就是将栈顶的数据取出

        }

    }

}
