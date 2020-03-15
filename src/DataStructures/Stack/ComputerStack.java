package DataStructures.Stack;

import java.util.Stack;

/**
 * @author yichangkong
 * @create 2020-03-13-17:10
 */
public class ComputerStack {

    //数字栈
    static public Stack<Integer> numStack = new Stack();
    //符号栈
    static public Stack<Character> symbolStack = new Stack();
    //最终的求值
    static int val;
    static char[] symbols;

    public static void main(String[] args) {

        //定义两栈  计算3+6*2-2
        String string = "30-1*20+2";//如果两二级连续出现便会出错

        //定义一个符号优先级数组
        symbols = new char[4];
        symbols[0] = '+';
        symbols[1] = '-';
        symbols[2] = '*';
        symbols[3] = '/';

        //调用计算方法 传入计算表达式
        val = computer(string);

        System.out.println(val);
    }

    //扫描方法
    static public Integer computer(String str) {
        //定义指令 如果flag等于2则声明 已经连续遍历出两个二级运算符需要将上两数值计算
        int flag = 0;
        //将字符串转换成数组
        char[] chars = str.toCharArray();
        //解决多位数问题
        String KeepNum = "";
        int index = -1;


        for (char c : chars) {
            index++;
            if (c >= '0' && c <= '9') {
                //解决多位数问题 如果是数字直接添加
                //如果当前遍历到最后一位直接入栈
                if ((index + 1) == chars.length) {
                    numStack.add(Integer.parseInt(String.valueOf(c)));
                } else {
                    KeepNum += c;
                    //判断下一位的字符是否为数字 如果不是数字就开始入栈 再将将keepNum清空
                    if (isOper(chars[index + 1])) {
                        numStack.add(Integer.parseInt(KeepNum));
                        KeepNum = "";
                    }

                }


            } else {
                if (symbolStack.size() == 0) {
                    symbolStack.add(c);
                } else {

                    if (isSymbol(c) == 2) {
                        flag++;
                        if (flag == 2) {
                            int val2 = numStack.pop();
                            int val1 = numStack.pop();
                            Character cs = symbolStack.pop();
                            mySwicth(cs, val1, val2);
                            symbolStack.add(c);

                        } else {

                            symbolStack.add(c);
                        }
                    } else {

                        //将flag归零
                        flag = 0;

                        //数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算

                        System.out.println(numStack);

                        int val2 = numStack.pop();
                        int val1 = numStack.pop();
                        Character cs = symbolStack.pop();

                        mySwicth(cs, val1, val2);
                        symbolStack.add(c);

                    }
                }
            }
        }
//遍历循环结束 按顺序计算
        while (symbolStack.size() != 0) {
            int val4 = numStack.pop();
            int val3 = numStack.pop();
            char cs = symbolStack.pop();
            mySwicth(cs, val3, val4);
        }

        //给表达式赋值
        return (Integer) numStack.pop();
    }

    private static boolean isOper(char c) {
        return (c >= '0' && c <= '9') ? false : true;
    }

    static public void mySwicth(char cs, int val1, int val2) {
        switch (cs) {
            case '*':
                val = val1 * val2;
                numStack.add(val);
                break;
            case '-':
                val = val1 - val2;
                numStack.add(val);
                break;
            case '+':
                val = val1 + val2;
                numStack.add(val);
                break;
            case '/':
                val = val1 / val2;
                numStack.add(val);
                break;
            default:
                break;
        }
    }

//判断是否为运算符号  和优先级  +- index 12  第一级 */ index3 4

    static public int isSymbol(char val) {

        int outlook = 1;
        for (char c : symbols) {
            if (val == c) {
                return (outlook > 2) ? (outlook = 2) : (outlook = 1);
            }
            outlook++;
        }
        return (outlook > 2) ? (outlook = 2) : (outlook = 1);
    }
}
