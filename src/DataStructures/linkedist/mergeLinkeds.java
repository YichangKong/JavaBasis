package DataStructures.linkedist;

/**
 * @author yichangkong
 * @create 2020-03-04-16:24
 * 两顺序链表合并
 */
public class mergeLinkeds {
    public static void main(String[] args) {
        //创建测试数据
        HeroNode hero1 = new HeroNode(1, "宋江1", "及时雨1");
        HeroNode hero3 = new HeroNode(3, "宋江3", "及时雨3");
        HeroNode hero7 = new HeroNode(7, "宋江7", "及时雨7");

        HeroNode hero4 = new HeroNode(4, "宋江4", "及时雨4");
        HeroNode hero9 = new HeroNode(9, "宋江9", "及时雨9");
        HeroNode hero5 = new HeroNode(5, "宋江5", "及时雨5");

        singleLinkedList list1 = new singleLinkedList();
        singleLinkedList list2 = new singleLinkedList();

        list1.add(hero1);
        list1.add(hero3);
        list1.add(hero7);

        list2.add(hero4);
        list2.add(hero5);
        list2.add(hero9);


        System.out.println("链表1");
        list1.showList();
        System.out.println("链表2");
        list2.showList();
        System.out.println("合并两个有顺链表");

        singleLinkedList list3 = merge(list1, list2);

        list3.showList();


    }
    //将两个链表进行顺序合并

    public static singleLinkedList merge(singleLinkedList list1, singleLinkedList list2) {

        singleLinkedList merges = new singleLinkedList();

        HeroNode mergesHead = merges.head;


        //进行数据赋值
        HeroNode head1 = list1.head;
        HeroNode head2 = list2.head;

        //先进行逻辑分析 将两个有序列表进行合并
        //1. 将其中的一条链表进行复制

        while (true) {
            //遍历第一条数据链表
            if (head1.next != null) {
                mergesHead.next = head1.next;
            } else {
                break;
            }

            //循环遍历
            mergesHead = mergesHead.next;
            head1 = head1.next;
        }

        //这里遍历完成之后  mergesHead已经将指针指到最后一个位置 怎么操作？？？
        //解决办法就是将merg链表复制一份  第一个遍历的数据链表

        mergesHead = merges.head;


        //2.在已经复制第一条数据的基础上进行顺序比较 在进行数据插入

        while (true) {
            HeroNode cur = null;
            HeroNode temp = head2.next;

            if (mergesHead.next == null) {
            }


            //第一种情况 1 < 2 < 3 将head2插入主链
            if (temp.no > mergesHead.next.no & temp.no < mergesHead.next.next.no) {

                cur = mergesHead.next.next;

                mergesHead.next.next = new HeroNode(temp.no, temp.name, temp.nickname);

                mergesHead.next.next.next = cur;

//                将指针下移

                temp = temp.next;

            } else if (temp.no > mergesHead.next.no) {

            }

            break;


        }

        //指针下移
        mergesHead = mergesHead.next;

        return merges;
    }


    static class singleLinkedList {


        //先初始化一个头节点  不动头节点  也不存放具体的数据
        private HeroNode head = new HeroNode(0, "", "");
        private HeroNode head1 = new HeroNode(0, "", "");

        public void add(HeroNode heroNode) {

            //因为head的节点不能动  因此我们需要一个辅助遍历 temp
            HeroNode temp = head;


            //遍历链表 找到最后
            while (true) {

                if (temp.next == null) {
                    break;
                }
                //当退出while退出循环时  temp就指向链表的最后

                //如果没有找到最后 将temp的next 后移
                temp = temp.next;
            }
            temp.next = heroNode;
        }


        public void showList() {
            //判断链表是否为空

            if (head.next == null) {
                System.out.println("链表为空！");
                return;
            }
            //因为头节点不能动  因此我们辅助变量遍历
            HeroNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                //输出节点的信息
                System.out.println(temp);
                //将temp后移 一定小心
                temp = temp.next;
            }
        }

    }


    static class HeroNode {

        private int no;
        private String name;
        private String nickname;
        //        指向下一个节点
        private HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }


}

