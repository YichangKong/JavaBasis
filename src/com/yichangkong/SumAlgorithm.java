package com.yichangkong;

/**
 * @author yichangkong
 * @create 2020-03-18-10:08
 */
public class SumAlgorithm {

    public static void main(String[] args) {
        //���ˣ��ڲ�ѭ����sum���д��룬ִ��20�Σ��ڲ�ѭ��ִ��21�Σ��ܵ��ڲ�ѭ����ִ����21*3=63�Σ����ѭ����ִ��4�Σ�Ҳ����˵�ܵ�ѭ��������63+4=67��
        //��ʦ��
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
        System.out.println("����ʱ��:" + (endTime - startTime) + "ns");

    }


}
