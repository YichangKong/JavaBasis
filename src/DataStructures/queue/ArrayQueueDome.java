package DataStructures.queue;

import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-02-23-17:41
 */
public class ArrayQueueDome {


    //使用数组模拟环形队列的思路分析
    public static void main(String[] args) {

        //创建队列类的实例
        ArrayQueue arrayQueue = new ArrayQueue(4);//实际的存取数组值为3
        char key = ' ';
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        while (loop) {
            System.out.print("s(show) 显示队列数据");
            System.out.print("g(get) 获取队列");
            System.out.print("a(add) 添加数据到队列");
            System.out.println("e(exit) 退出程序");

            key = sc.next().charAt(0);

            switch (key) {

                case 's':
                    arrayQueue.show();
                    break;

                case 'g':
                    try {
                        int value = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\t", value);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数值");
                    int n = sc.nextInt();
                    arrayQueue.addQueue(n);
                    System.out.println("添加成功");
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }

        System.out.println("程序退出！！");

    }

    static class ArrayQueue {

        private int maxSize;//最大存放数量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;//存放数据

        //创建队列类的构造器
        public ArrayQueue(int arrMaxSize) {

            maxSize = arrMaxSize;
            arr = new int[maxSize];

        }

        //判断队列是否满
        public boolean ifFull() {
            return (rear + 1) % maxSize == front;
        }

        //判断队列是否空
        public boolean isEmpty() {
            return rear == front;
        }

        //添加数据到数组
        public void addQueue(int n) {

            if (ifFull()) {
                System.out.println("Sorry Can`t to add,the Queue are Full");
                return;
            }

            //如果队列还要位置 便添加数值
            arr[rear] = n;//0

            rear = (rear + 1) % maxSize; //运算符 % ：模运算，（1）、当运算符左边小于右边，结果就等于左边；（2）、当运算符左边大于右边，就和算术中的取余是一样的效果。
        }

        //取数据
        public int getQueue() {
            //判断队列是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列为空！");
            }
            int val = arr[front];

            arr[front] = 0;

            rear--;

            //将第一位取走的位置补上数据
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1) {
                    arr[i] = arr[i + 1];
                } else {
                    arr[i] = 0;
                }
            }
            return val;
        }

        //显示数组数据
        public void show() {

            //判断队列是否为空
            if (isEmpty()) {
                System.out.println("队列为空！");
                return;
            }

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] != 0) {
                    System.out.printf("arr[%d]=%d\t", i, arr[i]);
                }


            }


        }
    }

}
