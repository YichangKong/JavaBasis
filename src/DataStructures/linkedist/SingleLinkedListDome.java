package DataStructures.linkedist;

/**
 * @author yichangkong
 * @create 2020-02-25-20:25
 */
//自我生成 list 并不使用java 提供的list api因此达到对数据结构的认识
public class SingleLinkedListDome {


    public static void main(String[] args) {

        //创建测试数据
        HeroNode hero1 = new HeroNode(1, "宋江1", "及时雨1");
        HeroNode hero2 = new HeroNode(2, "宋江2", "及时雨2");
        HeroNode hero3 = new HeroNode(3, "宋江3", "及时雨3");
        HeroNode hero5 = new HeroNode(5, "宋江5", "及时雨5");
        HeroNode hero4 = new HeroNode(4, "宋江4", "及时雨4");

        singleLinkedList list = new singleLinkedList();
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero5);
        list.addByOrder(hero4);
        list.list();

        System.out.println("开始进行链表数据反转");

        list.transposeList();

        list.list();


    }

    //定义singlelinkedList 管理我们的英雄
    static class singleLinkedList {


        //先初始化一个头节点  不动头节点  也不存放具体的数据
        private HeroNode head = new HeroNode(0, "", "");
        //将单链表进行数据反转

        public void transposeList() {

            HeroNode reslist = new HeroNode(0, "", "");
            HeroNode temp = head;

            //将指定的数组进行遍历 在插入到新链表
            //判断传入的链表是否为空 或者只有一个hero 则无需反转
            if (temp.next == null && temp.next.next == null) {
                return;
            }

            reslist.next = new HeroNode(temp.next.no, temp.next.name, temp.next.nickname);

            boolean flag = true;

            while (flag) {
                temp = temp.next;

                HeroNode cur = reslist.next;


                if (temp.next != null) {

                    //取一个中间变量
                    reslist.next = new HeroNode(temp.next.no, temp.next.name, temp.next.nickname);

                   /* reslist.next.no = temp.next.no;
                    reslist.next.name = temp.next.name;
                    reslist.next.nickname = temp.next.nickname; 为什么这样说写便导致大量重复数据！ */

                    reslist.next.next = cur;

                } else {
                    flag = false;
                }
            }
            head = reslist;
        }


        //添加节点到单向链表
        //思路，当不考虑编号顺序时
        //1.找到当前链表的最后节点
        //2.将最后这个节点的next 指向 新的节点

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

        //根据指定编号进行hero删除
        public void deleteByNo(int no) {

            //指定指针temp遍历
            HeroNode temp = head;

            boolean flag = false;

            //遍历到指定hero 进行数据删除和数据更改
            while (true) {

                if (temp.next == null) {
                    return;
                }
                if (temp.next.no == no) {
                    flag = true;

                    //查询到hero编号 开始数据操作和转移
                    //1.将temp。next 的next 的hreo 进行专业 》 hero
                    //2.将temp。next 》 null

                    HeroNode hero = temp.next.next;
                    temp.next = hero;
                    break;
                }

                //将temp 的指针移到下一位
                temp = temp.next;


            }

            //判断上述的操作是否已经查找到需要的指针
            if (flag) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }


        }


        //根据编号来修改节点英雄信息 name nickname

        public void upDateHeroByNo(int no, String name, String nickName) {

            //指针temp变量
            HeroNode temp = head;

            boolean flag = false;

            while (true) {
                if (temp.no == no) {
                    flag = true;
                    break;
                } else if (temp == null) {
                    break;
                }
                temp = temp.next;
            }


            if (flag) {

                temp.name = name;
                temp.nickname = nickName;

                System.out.println("修改成功！");

            } else {
                System.out.println("修改失败！！");
            }


        }


        //添加heronode 通过排序
        public void addByOrder(HeroNode heroNode) {

            //先安排一个模板变量 temp进行指针遍历

            HeroNode temp = head;

            //
            while (true) {
                if (heroNode.no == 0) {
                    System.out.println("插入英雄排行为零！");
                    break;
                }

                if (temp.no < heroNode.no && heroNode.no < temp.next.no) {

                    heroNode.next = temp.next;
                    temp.next = heroNode;
                    break;

                    //当heronode是排到的最后
                } else if (temp.next == null) {

                    temp.next = heroNode;
                }
                temp = temp.next;

            }

        }

        //显示链表 遍历
        public void list() {
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

    //定义HeroNode 创建一个每个heronode 对象就是一个节点

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
