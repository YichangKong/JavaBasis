package DataStructures.recursion;

/**
 * @author yichangkong
 * @create 2020-04-01-20:30
 * ����ݹ�ĵ��û��� ��ӡ�Ⱥ�˳�� 1 2 3 4
 * �Թ�
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
        System.out.println("N  ��" + i);

        //����������Ĵ��뻻�� ��ֻ���ӡ�� 1
//        if (i >= 2) {
//            test(i - 1);
//        } else {
//            System.out.println("N ! ��" + i);
//        }

    }

    //�׳�����

    static public int factroial(int n) {
        if (n == 1) {
            return n;
        } else {
            return factroial(n - 1) * n;
        }
    }
}
