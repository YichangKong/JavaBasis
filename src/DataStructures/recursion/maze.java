package DataStructures.recursion;

/**
 * @author yichangkong
 * @create 2020-04-08-17:09
 */
public class maze {

    public static void main(String[] args) {
        //����һ����ʼ��ά�����Թ�
        int[][] mazes = new int[8][7];
        //����ֵ1����Ϊ�Թ���ǽ
        for (int i = 0; i < 7; i++) {
            mazes[0][i] = 1;
            mazes[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            mazes[i][0] = 1;
            mazes[i][6] = 1;
        }
        //���õ���
        mazes[3][1] = 1;
        mazes[3][2] = 1;
        mazes[1][2] = 1;
        mazes[2][2] = 1;
        System.out.println("��ʼ���Թ���");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mazes[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("��·��ɣ� �� " + setWay(mazes, 1, 1));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mazes[i][j] + "   ");
            }
            System.out.println();
        }

    }

    /**
     * @Description ʹ�õݹ��������Ѱ
     * 1.˵�������С���ܹ��ҵ�{int��6�� ��5��} ˵���߳��Թ�
     * 2.Լ������map��i����j��Ϊ0 ��ʾ�õ�û���߹� �� 2 ��ʾͨ·������ �� 3 ��ʾ�õ��Ѿ��߹� �����߲�ͨ
     * 3.�����Թ�ʱ ��Ҫȷ��һ�������߷� �� �¡��ҡ��ϡ��� ����߲�ͨ�ٽ��л���
     * @Param [maze, i, j] i j ��ʾ���Ǹ�λ�ÿ�ʼѰ��
     * @Return ����ҵ�ͨ·�ͷ���true ����false
     * @Date 2020/4/8
     * @Time 17:40
     */
    static public boolean setWay(int[][] maze, int i, int j) {

        if (maze[6][5] == 2) {//˵���Ѿ��ҵ�
            return true;
        } else if (maze[i][j] == 0) {//���
            maze[i][j] = 2;
            if (setWay(maze, i + 1, j)) {//��
                return true;
            } else if (setWay(maze, i, j + 1)) {//��
                return true;
            } else if (setWay(maze, i - 1, j)) {//��
                return true;
            } else if (setWay(maze, i, j - 1)) {//��
                return true;
            } else {//�಻����ͨ
                maze[i][j] = 3;
                return false;
            }
        } else if (maze[i][j] == 1) {
            maze[i][j] = 1;
            return false;
        } else {
            maze[i][j] = 3;
            return false;
        }


    }
}
