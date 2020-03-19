package com.yichangkong;

/**
 * @author yichangkong
 * @create 2020-03-18-10:08
 */
public class SumAlgorithm {

    public static void main(String[] args) {
        //本人：内层循环，sum这行代码，执行20次，内层循环执行21次，总的内层循环，执行了21*3=63次，外层循环，执行4次，也就是说总的循环次数，63+4=67次
        //老师：
        long startTime = System.nanoTime();

        int sum = 0;
        int numj = 0;
        int numi = 0;

        for (int j = 1; j <= 3; j++) {
            numj = j + 2;
            for (int i = 1; i <= 20; i++) {
                numi = i + 1;
                sum += numi * numi * numj;
            }

        }
        System.out.println(sum);
        long endTime = System.nanoTime();
        System.out.println("运行时间:" + (endTime - startTime) + "ns");

    }


}
