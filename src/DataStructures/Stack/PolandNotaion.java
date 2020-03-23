package DataStructures.Stack;

import java.util.Stack;

/**
 * @author yichangkong
 * @create 2020-03-21-22:47
 * 中缀表达式转后缀表达式
 */
public class PolandNotaion {

    public static void main(String[] args) {

        //初始化两栈 S1 S2
        Stack<String> operatStack = new Stack();//；零时存取运算符
        Stack<String> polanStack = new Stack();//逆波兰表达式


        //测试案例
        String expersstion = "1 + ( ( 2 + 3 ) * 4 ) - 5";

        String[] arrayStr = expersstion.split(" ");//转换为字符串数组进行从左至右遍历扫描

        int size = arrayStr.length;//11

        System.out.println(size);

        boolean flag = true;


        for (int index = 0; index < size; index++) {

            String str = arrayStr[index];

            //遇到操作数
            if (isNum(str)) {

                polanStack.push(str);

            } else {//如果是操作符
                if (operatorLevel(str) == 1) {
                    //(1) 如果是左括号“(”，则直接压入s1
                    if (str.equals("(")) {
                        operatStack.push(str);
                    } else {
                        //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                        boolean f1 = true;
                        while (f1) {

                            String s = operatStack.peek();
                            if (s.equals("(")) {
                                operatStack.pop();
                                f1 = false;
                            } else {
                                polanStack.push(operatStack.pop());
                            }
                        }
                    }
                } else {
                    flag = true;
                    while (flag) {
                        if (operatStack.size() == 0 || operatStack.peek().equals("(")) {//如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈
                            //直接入S1
                            operatStack.push(str);
                            flag = false;
                        } else {
                            int L1 = operatorLevel(str);
                            int L2 = operatorLevel(operatStack.peek());
                            //2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
                            if (L1 < L2) {
                                operatStack.push(str);

                                System.out.println("L!");
                                flag = false;
                            } else { //3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                                polanStack.push(operatStack.pop());
                            }
                        }
                    }
                }
            }
        }

        while (operatStack.size() != 0) {
            polanStack.push(operatStack.pop());
        }
        System.out.println(polanStack);
    }


    //判断方法 检验输入的符号是否为数
    static public boolean isNum(String string) {

        if (operatorLevel(string) > 4) {

            int num = Integer.parseInt(string);

            if (num <= 9 || num >= 0) {
                return true;//是数字
            }
        }
        return false;//符号

    }


    //优先级 运算符 1 > 2 > 3 >4
    static public int operatorLevel(String string) {

        switch (string) {
            case "(":
                return 1;
            case ")":
                return 1;

            case "+":
                return 3;
            case "-":
                return 3;
            case "*":
                return 2;
            case "/":
                return 2;
            case "#":
                return 4;
            default:
                return 5;
        }

    }
}
