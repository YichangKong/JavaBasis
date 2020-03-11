package DataStructures.Stack;

/**
 * @author yichangkong
 * @create 2020-03-10-16:29
 * <p>用数组模拟栈结构
 */
public class ArrayStackDemo {


    public static void main(String[] args) {

    }


    //定义一个数组栈
    class ArrayStack {
        private int maxSize;//栈的大小
        private int[] stack;//数组模拟栈  测试数据放在数组
        private int top = -1;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[this.maxSize];
        }
    }

}
