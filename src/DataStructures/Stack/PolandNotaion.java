package DataStructures.Stack;

import java.util.Stack;

/**
 * @author yichangkong
 * @create 2020-03-21-22:47
 * ��׺���ʽת��׺���ʽ
 */
public class PolandNotaion {

    public static void main(String[] args) {

        //��ʼ����ջ S1 S2
        Stack<String> operatStack = new Stack();//����ʱ��ȡ�����
        Stack<String> polanStack = new Stack();//�沨�����ʽ


        //���԰���
        String expersstion = "1 + ( ( 2 + 3 ) * 4 ) - 5";

        String[] arrayStr = expersstion.split(" ");//ת��Ϊ�ַ���������д������ұ���ɨ��

        int size = arrayStr.length;//11

        System.out.println(size);

        boolean flag = true;


        for (int index = 0; index < size; index++) {

            String str = arrayStr[index];

            //����������
            if (isNum(str)) {

                polanStack.push(str);

            } else {//����ǲ�����
                if (operatorLevel(str) == 1) {
                    //(1) ����������š�(������ֱ��ѹ��s1
                    if (str.equals("(")) {
                        operatStack.push(str);
                    } else {
                        //����������š�)���������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
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
                        if (operatStack.size() == 0 || operatStack.peek().equals("(")) {//���s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ
                            //ֱ����S1
                            operatStack.push(str);
                            flag = false;
                        } else {
                            int L1 = operatorLevel(str);
                            int L2 = operatorLevel(operatStack.peek());
                            //2.���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1��
                            if (L1 < L2) {
                                operatStack.push(str);

                                System.out.println("L!");
                                flag = false;
                            } else { //3.���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚ�
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


    //�жϷ��� ��������ķ����Ƿ�Ϊ��
    static public boolean isNum(String string) {

        if (operatorLevel(string) > 4) {

            int num = Integer.parseInt(string);

            if (num <= 9 || num >= 0) {
                return true;//������
            }
        }
        return false;//����

    }


    //���ȼ� ����� 1 > 2 > 3 >4
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
