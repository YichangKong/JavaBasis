package com.yichangkong;

import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-03-24-21:17
 * Enter 10 integers from the keyboard and output them in ascending order.
 */
public class SmallExercises {

    public static void main(String[] args) {

        System.out.println("Please enter 10 integers, pay attention to the format，end with enter!");

        Scanner sc = new Scanner(System.in);

        //int[] ints = new int[]{5, 45, 2, 3, 4, 78, 6, 36, 52, 89}; //测试数据


        int[] ints = new int[10];

        for (int i = 0; i < 10; i++) {
            ints[i] = sc.nextInt();
        }
        System.out.println("Sort comparison by default!");

        comparisonSorting(ints);//比较排序
        //选择排序SelectionSort(ints);
        cycle(ints);
        System.out.println("the_input_session_is_over");
    }

    static public int[] comparisonSorting(int[] ints) {
        int num1;
        int num2;
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (ints[i] > ints[j]) {

                    num1 = ints[i];
                    ints[i] = ints[j];
                    ints[j] = num1;
                }
            }
        }
        return ints;
    }

    static int[] SelectionSort(int ints[]) {
        for (int i = 0; i < 10; i++) {
            int index = i;
            for (int j = i + 1; j < 10; j++) {
                if (ints[j] < ints[index]) {
                    index = j;
                }
            }
            if (index == i)
                continue;
            else {
                int temp;
                temp = ints[index];
                ints[index] = ints[i];
                ints[i] = temp;
            }
        }
        return ints;
    }


    static public void cycle(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
