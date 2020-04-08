package DataStructures.recursion;

/**
 * @author yichangkong
 * @create 2020-04-01-20:30
 * 考察递归的调用机制 打印先后顺序 1 2 3 4
 * 迷宫
 */
public class recursionTest {

    public static void main(String[] args) {
        //test(4);
        System.out.println(factroial(3));
    }

    private static void test(int i) {
        if (i >= 2) {
            test(i - 1);
        }
        System.out.println("N  ：" + i);

        //如果将上述的代码换成 则只会打印出 1
//        if (i >= 2) {
//            test(i - 1);
//        } else {
//            System.out.println("N ! ：" + i);
//        }

    }

    //阶乘问题

    static public int factroial(int n) {
        if (n == 1) {
            return n;
        } else {
            return factroial(n - 1) * n;
        }
    }
}
