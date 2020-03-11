package DataStructures.Stack;

/**
 * @author yichangkong
 * @create 2020-03-10-16:29
 * <p>用数组模拟栈结构
 */
public class ArrayStackDemo {


    public static void main(String[] args) {

        //测试
        //添加数据
        ArrayStack stack = new ArrayStack(8);

        stack.push(1);
        stack.push(2);
        stack.push(8);
        stack.push(4);
        stack.push(5);

        stack.list();


    }


    static class ArrayStack {
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

}
//定义一个数组栈

