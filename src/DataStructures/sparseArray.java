package DataStructures;

import java.io.*;

/**
 * @author yichangkong
 * @create 2020-02-22-18:39
 * 二维数组 转 稀疏数组的思路
 * 1. 遍历  原始的二维数组，得到有效数据的个数 sum
 * 2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
 * 3. 将二维数组的有效数据数据存入到 稀疏数组
 * <p>
 * 稀疏数组转原始的二维数组的思路
 * <p>
 * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
 * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
 */
public class sparseArray {

    //棋盘存盘
    public static void main(String[] args) throws Exception {

        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表 蓝子

        int cherArrays[][] = new int[11][11];

        System.out.println("原始数组~");

        //赋值
        cherArrays[1][2] = 1;
        cherArrays[2][3] = 2;
        cherArrays[2][4] = 2;
        //增强forec

        int sum = 0;

        for (int[] row : cherArrays) {

            for (int num : row) {
                System.out.printf("%d\t", num);
                //计算棋盘非零个数
                if (num != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("非零个数 sum =" + sum);

        //根据非零个数创建稀疏数组

        int spA[][] = new int[sum + 1][3];

        spA[0][0] = 11;
        spA[0][1] = 11;
        spA[0][2] = sum;

        int count = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (cherArrays[i][j] != 0) {
                    count++;
                    spA[count][0] = i;
                    spA[count][1] = j;
                    spA[count][2] = cherArrays[i][j];
                }
            }
        }
        System.out.println("稀疏数组~");
        for (int[] row : spA) {

            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        arrayTofile(spA);

        //恢复二维数组
        System.out.println("恢复二维数组");

        int cherArrays2[][] = new int[spA[0][0]][spA[0][1]];

        for (int i = 1; i < spA.length; i++) {

            cherArrays2[spA[i][0]][spA[i][1]] = spA[i][2];
        }


        toForeach(cherArrays2);

        System.out.println("写文件");

        FileInputStream fis = new FileInputStream("map.data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        int[][] anotherArray = (int[][]) ois.readObject();
        ois.close();

        toForeach(anotherArray);


    }

    static void arrayTofile(int[][] spa) throws IOException {

        FileOutputStream fos = new FileOutputStream("map.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(spa);
        oos.close();

    }

    static void toForeach(int[][] Array) {
        for (int[] row : Array
        ) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();

        }
    }

}
