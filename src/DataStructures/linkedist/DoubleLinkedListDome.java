package DataStructures.linkedist;

/**
 * @author yichangkong
 * @create 2020-03-08-16:33
 * 双向链表实现
 */
public class DoubleLinkedListDome {

    public static void main(String[] args) {

        //给管理类添加模拟数据
        DoubleLinkedList list = new DoubleLinkedList();

        MyList list1 = new MyList(1, "李白", "man");
        MyList list2 = new MyList(2, "白居易", "man");
        MyList list3 = new MyList(3, "屈原", "man");
        MyList list4 = new MyList(4, "默克尔", "male");

        //添加数据 按顺序

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        //进行数据遍历 删除 和 添加

        //删除2号
        list.delete(2);
        list.delete(4);

        list.show();

        System.out.println(list3.per);


    }

    //定义DoubleLinkedList来管理 MyList
    static class DoubleLinkedList {

        MyList ListHead = new MyList(0, "", "");

        //遍历打印数据
        void show() {

            while (true) {

                if (ListHead.next != null) {

                    System.out.println(ListHead.next);

                } else {

                    break;

                }

                ListHead = ListHead.next;

            }

        }

        public void addByorde() {

        }

        void delete(int no) {

            MyList cur = ListHead.next;

            while (true) {


                if (cur.no == no & cur.next != null) {

                    cur.per.next = cur.next;
                    cur.next.per = cur.per;
                    break;

                } else if (cur.next == null) {

                    cur.per.next = null;
                    break;

                }

                cur = cur.next;

            }

        }

        void add(MyList list) {

            MyList temp = ListHead;

            while (true) {

                if (temp.next == null) {

                    temp.next = list;
                    list.per = temp;

                    break;


                } else {

                    temp = temp.next;


                }

            }
        }
    }


    static class MyList {
        int no;
        String name;
        String gender;
        MyList next; //定义下一个mylist对象
        MyList per;//定义上一个mylist对象

        @Override
        public String toString() {
            return "MyList{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        public MyList(int no, String name, String gender) {
            this.no = no;
            this.name = name;
            this.gender = gender;
        }

    }
}
