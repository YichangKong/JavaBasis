package DataStructures.Stack;

/**
 * @author yichangkong
 * @create 2020-03-11-21:14
 * 用链表模拟栈
 */
public class LinkleStackDemo {

    public static void main(String[] args) {

        LinkedListInt listInt = new LinkedListInt(5);
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        // listInt.add(5);

        System.out.println(listInt.pop());
        System.out.println(listInt.pop());
        System.out.println(listInt.pop());

        listInt.list();


    }

    //创建一个int类型 的 链表类

    //指定存取数已经满

    static class LinkedListInt {

        int maxSize;
        int ind = 0;

        private linkedList head = new linkedList(0, 0);

        public LinkedListInt(int maxSize) {
            this.maxSize = maxSize;
        }

        //加值
        public void add(int val) {
            linkedList temp = head;

            //判断是已经存取满载
            if (ifFull()) {
                System.out.println("LIST : 已经存取满载");
                return;
            }

            //循环到next为空值时
            while (true) {

                if (temp.next != null) {

                    temp = temp.next;//将指针下移

                } else {

                    temp.next = new linkedList(ind, val);
                    ind++;
                    break;

                }


            }

        }

        //取值 pop
        public int pop() {
            int val = 0;
            //根据index 的最后值 来进行遍历
            if (ifEmpty()) return val;

            linkedList temp = head;
            while (true) {
                if (temp.next != null) {

                    if (temp.next.index == ind - 1) {

                        //进行赋值 再进行删除 将指针下移
                        val = temp.next.val;
                        temp.next = null;
                        ind--;
                        return val;

                    } else {
                        //循环遍历
                        temp = temp.next;
                    }
                }

            }
        }

        //取值 index 指针值
        public void list() {
            linkedList temp = head.next;

            if (ifEmpty()) return;

            while (true) {
                if (temp != null) {

                    System.out.println(temp.val);
                    temp = temp.next;


                } else {
                    return;
                }


            }
        }

        public boolean ifFull() {
            return ind == maxSize;

        }

        //链表是否为空
        public boolean ifEmpty() {
            return ind == 0;
        }


    }


    //创建链表节点
    static class linkedList {
        private int index;//指针
        private int val;//定义链表 值
        private linkedList next;

        public linkedList(int index, int val) {
            this.index = index;
            this.val = val;
            this.next = null;

        }

        @Override
        public String toString() {
            return "linkedList{" +
                    "index=" + index +
                    ", val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}


class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈  测试数据放在数组
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    //判断是否栈满
    public boolean ifFull() {
        return top == maxSize - 1;

    }

    //判断栈是否为空
    public boolean ifEmpty() {

        return top == -1;
    }

    //入栈
    public void push(int value) {

        //判断是否栈满
        if (ifFull()) return;
        //添加
        top++;
        stack[top] = value;

    }

    //出栈 先入后出
    public int pop() {

        //判断是否kong
        if (ifEmpty()) {
            System.out.println("栈空 请插入数据进行测试");
            return 0;
        }
        //try { return stack[top]; } finally { top--; }这个方法着实有些撒比了
        //以为 show 和 pop两个之间的top会影响

        int cur = top;

        int value = stack[top];
        top--;
        return value;


    }
    //显示栈的情况 比如栈的size

    public void list() {
        if (ifEmpty()) {
            System.out.println("栈空 请插入数据进行测试");
            return;
        }
        for (int i = top; i > -1; i--) {

            System.out.println(stack[i]);

        }

    }
}



