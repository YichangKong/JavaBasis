package DataStructures.recursion;

/**
 * @author yichangkong
 * @create 2020-04-08-17:09
 */
public class maze {

    public static void main(String[] args) {
        //创建一个初始二维数组迷宫
        int[][] mazes = new int[8][7];
        //将数值1代表为迷宫的墙
        for (int i = 0; i < 7; i++) {
            mazes[0][i] = 1;
            mazes[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            mazes[i][0] = 1;
            mazes[i][6] = 1;
        }
        //设置挡板
        mazes[3][1] = 1;
        mazes[3][2] = 1;
        mazes[1][2] = 1;
        mazes[2][2] = 1;
        System.out.println("初始化迷宫：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mazes[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("找路完成： 》 " + setWay(mazes, 1, 1));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mazes[i][j] + "   ");
            }
            System.out.println();
        }

    }

    /**
     * @Description 使用递归回溯来找寻
     * 1.说明：如果小球能够找到{int【6】 【5】} 说明走出迷宫
     * 2.约定：当map【i】【j】为0 表示该点没有走过 ； 2 表示通路可以走 ； 3 表示该点已经走过 但是走不通
     * 3.在走迷宫时 需要确定一个策略走法 》 下》右》上》左 如果走不通再进行回溯
     * @Param [maze, i, j] i j 表示从那个位置开始寻找
     * @Return 如果找到通路就返回true 否则false
     * @Date 2020/4/8
     * @Time 17:40
     */
    static public boolean setWay(int[][] maze, int i, int j) {

        if (maze[6][5] == 2) {//说明已经找到
            return true;
        } else if (maze[i][j] == 0) {//起点
            maze[i][j] = 2;
            if (setWay(maze, i + 1, j)) {//下
                return true;
            } else if (setWay(maze, i, j + 1)) {//右
                return true;
            } else if (setWay(maze, i - 1, j)) {//上
                return true;
            } else if (setWay(maze, i, j - 1)) {//左
                return true;
            } else {//多不能走通
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
