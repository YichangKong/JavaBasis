package DataStructures.linkedist;

/**
 * @author yichangkong
 * @create 2020-03-09-22:07
 */
public class Joseph {


    public static void main(String[] args) {

        //创建 list管API
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(25);
        list.show();
        list.out(4, 2);

    }


    //创建一个环形单向链表
    static class CircleSingleLinkedList {

        //构建一个first节点 当前没有编号
        private Boy first = null;
        //添加小孩节点 形成环状链表

        //根据用户要求进行出圈操作   k 第几个开始报 move 移动几位
        public void out(int k, int m) {

            //判断是否为空
            if (first == null) return;

            Boy firster = null;
            Boy helper = null;
            Boy curBoy = first;

            //第一步遍历指定开始小孩  创建 firster  helper
            boolean loop = true;
            while (loop) {

                if (k != 1 & curBoy.getNext().no == k) {

                    helper = curBoy;
                    firster = curBoy.getNext();
                    System.out.println("初始firster = " + firster.no + "helper =  " + helper.no + "指定完成");
                    loop = false;

                } else if (k == 1 & curBoy.getNext() == first) {
                    //如果k等于1 则指定不了 helper 这需要遍历到最后
                    helper = curBoy;
                    firster = curBoy.getNext();
                    System.out.println("初始firster = " + firster.no + " , helper =  " + helper.no + "指定完成");
                    loop = false;

                }

                curBoy = curBoy.getNext();


            }

            //开始循环遍历跳出Boy
            while (true) {


                boolean flag = true;
                int count = 0;
                //需要查看还有多少个有效Boy


                while (flag) {
                    if (count == m - 1) {
                        System.out.printf("出圈小孩%d \n", firster.no);
                        firster = firster.getNext();
                        helper.setNext(firster);
                        //跳出这层循环
                        flag = false;

                    } else {
                        firster = firster.getNext();
                        helper = helper.getNext();
                        count++;//遍历一次自增一次
                    }

                }


                if (firster == helper) {

                    System.out.printf("出圈小孩%d \n", firster.no);

                    return;

                }


            }


        }


        //nums 添加小孩数量
        public void addBoy(int nums) {

            if (nums < 1) {

                System.out.println("nums 必须大于1 ");

                //结束方法
                return;

            }
            Boy curBoy = null;//辅助指针 帮助构建环形链表

            for (int i = 1; i <= nums; i++) {
                //根据nums创建小孩

                Boy boy = new Boy(i);

                //如果是第一个小孩
                if (i == 1) {

                    first = boy;
                    //构成环形
                    first.setNext(first);
                    //让curboy指向first
                    curBoy = first;

                } else {
                    //如果不是第一个孩子
                    curBoy.setNext(boy);

                    boy.setNext(first);

                    curBoy = boy;

                }
            }

        }

        //遍历环形链表

        public void show() {
            //判断是否为空
            if (first == null) {
                return;
            }

            Boy curBoy = first;
            while (true) {

                System.out.printf("小孩的编号%d \n", curBoy.getNo());


                if (curBoy.getNext() == first) {
                    return;

                    //说明已经遍历到尾部
                } else {

                    curBoy = curBoy.getNext();

                }


            }

        }

    }

    //创建一个 boy类 表示一个节点
    static class Boy {
        private int no;//表示编号
        private String name;
        private Boy next;//默认为空

        public Boy(int no) {
            this.no = no;
            name = null;
            next = null;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Boy{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

//遍历

}
