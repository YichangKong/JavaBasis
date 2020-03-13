package DataStructures.Stack;

/**
 * @author yichangkong
 * @create 2020-03-11-21:14
 * 用链表模拟栈
 */
public class LinkleStackDemo {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("                       ::\n");
        sb.append("                      :;J7, :,                        ::;7:\n");
        sb.append("                      ,ivYi, ,                       ;LLLFS:\n");
        sb.append("                      :iv7Yi                       :7ri;j5PL\n");
        sb.append("                     ,:ivYLvr                    ,ivrrirrY2X,\n");
        sb.append("                     :;r@Wwz.7r:                :ivu@kexianli.\n");
        sb.append("                    :iL7::,:::iiirii:ii;::::,,irvF7rvvLujL7ur\n");
        sb.append("                   ri::,:,::i:iiiiiii:i:irrv177JX7rYXqZEkvv17\n");
        sb.append("                ;i:, , ::::iirrririi:i:::iiir2XXvii;L8OGJr71i\n");
        sb.append("              :,, ,,:   ,::ir@mingyi.irii:i:::j1jri7ZBOS7ivv,\n");
        sb.append("                 ,::,    ::rv77iiiriii:iii:i::,rvLq@huhao.Li\n");
        sb.append("             ,,      ,, ,:ir7ir::,:::i;ir:::i:i::rSGGYri712:\n");
        sb.append("           :::  ,v7r:: ::rrv77:, ,, ,:i7rrii:::::, ir7ri7Lri\n");
        sb.append("          ,     2OBBOi,iiir;r::        ,irriiii::,, ,iv7Luur:\n");
        sb.append("        ,,     i78MBBi,:,:::,:,  :7FSL: ,iriii:::i::,,:rLqXv::\n");
        sb.append("        :      iuMMP: :,:::,:ii;2GY7OBB0viiii:i:iii:i:::iJqL;::\n");
        sb.append("       ,     ::::i   ,,,,, ::LuBBu BBBBBErii:i:i:i:i:i:i:r77ii\n");
        sb.append("      ,       :       , ,,:::rruBZ1MBBqi, :,,,:::,::::::iiriri:\n");
        sb.append("     ,               ,,,,::::i:  @arqiao.       ,:,, ,:::ii;i7:\n");
        sb.append("    :,       rjujLYLi   ,,:::::,:::::::::,,   ,:i,:,,,,,::i:iii\n");
        sb.append("    ::      BBBBBBBBB0,    ,,::: , ,:::::: ,      ,,,, ,,:::::::\n");
        sb.append("    i,  ,  ,8BMMBBBBBBi     ,,:,,     ,,, , ,   , , , :,::ii::i::\n");
        sb.append("    :      iZMOMOMBBM2::::::::::,,,,     ,,,,,,:,,,::::i:irr:i:::,\n");
        sb.append("    i   ,,:;u0MBMOG1L:::i::::::  ,,,::,   ,,, ::::::i:i:iirii:i:i:\n");
        sb.append("    :    ,iuUuuXUkFu7i:iii:i:::, :,:,: ::::::::i:i:::::iirr7iiri::\n");
        sb.append("    :     :rk@Yizero.i:::::, ,:ii:::::::i:::::i::,::::iirrriiiri::,\n");
        sb.append("     :      5BMBBBBBBSr:,::rv2kuii:::iii::,:i:,, , ,,:,:i@petermu.,\n");
        sb.append("          , :r50EZ8MBBBBGOBBBZP7::::i::,:::::,: :,:,::i;rrririiii::\n");
        sb.append("              :jujYY7LS0ujJL7r::,::i::,::::::::::::::iirirrrrrrr:ii:\n");
        sb.append("           ,:  :@kevensun.:,:,,,::::i:i:::::,,::::::iir;ii;7v77;ii;i,\n");
        sb.append("           ,,,     ,,:,::::::i:iiiii:i::::,, ::::iiiir@xingjief.r;7:i,\n");
        sb.append("        , , ,,,:,,::::::::iiiiiiiiii:,:,:::::::::iiir;ri7vL77rrirri::\n");
        sb.append("         :,, , ::::::::i:::i:::i:i::,,,,,:,::i:i:::iir;@Secbone.ii:::\n");
        sb.append("\t\t阿黄保佑                                                  永无BUG\n");
        System.out.println(sb.toString());

        LinkedListInt listInt = new LinkedListInt(5);
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        // listInt.add(5);

        System.out.println(listInt.pop());
        System.out.println(listInt.pop());
        System.out.println(listInt.pop());
        System.out.println("_________");

        listInt.list();

        listInt.add(3);
        listInt.add(4);
        listInt.add(5);

        System.out.println("__________");

        listInt.list();
        System.out.println("__________");

        System.out.println(listInt.pop());


    }

    //创建一个int类型 的 链表类

    //指定存取数已经满

    static class LinkedListInt {

        int maxSize;
        int ind = 0;

        private linkedList head = new linkedList(0, 0);

        public LinkedListInt(int maxSize) {
            this.maxSize = maxSize;
        }

        //加值
        public void add(int val) {
            linkedList temp = head;

            //判断是已经存取满载
            if (ifFull()) {
                System.out.println("LIST : 已经存取满载");
                return;
            }

            //循环到next为空值时
            while (true) {

                if (temp.next != null) {

                    temp = temp.next;//将指针下移

                } else {

                    temp.next = new linkedList(ind, val);
                    ind++;
                    break;

                }


            }

        }

        //取值 pop
        public int pop() {
            int val = 0;
            //根据index 的最后值 来进行遍历
            if (ifEmpty()) return val;

            linkedList temp = head;
            while (true) {
                if (temp.next != null) {

                    if (temp.next.index == ind - 1) {

                        //进行赋值 再进行删除 将指针下移
                        val = temp.next.val;
                        temp.next = null;
                        ind--;
                        return val;

                    } else {
                        //循环遍历
                        temp = temp.next;
                    }
                }

            }
        }

        //取值 index 指针值
        public void list() {
            linkedList temp = head.next;

            if (ifEmpty()) return;

            while (true) {
                if (temp != null) {

                    System.out.println(temp.val);
                    temp = temp.next;


                } else {
                    return;
                }


            }
        }

        public boolean ifFull() {
            return ind == maxSize;

        }

        //链表是否为空
        public boolean ifEmpty() {
            return ind == 0;
        }


    }


    //创建链表节点
    static class linkedList {
        private int index;//指针
        private int val;//定义链表 值
        private linkedList next;

        public linkedList(int index, int val) {
            this.index = index;
            this.val = val;
            this.next = null;

        }

        @Override
        public String toString() {
            return "linkedList{" +
                    "index=" + index +
                    ", val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}


class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈  测试数据放在数组
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    //判断是否栈满
    public boolean ifFull() {
        return top == maxSize - 1;

    }

    //判断栈是否为空
    public boolean ifEmpty() {

        return top == -1;
    }

    //入栈
    public void push(int value) {

        //判断是否栈满
        if (ifFull()) return;
        //添加
        top++;
        stack[top] = value;

    }

    //出栈 先入后出
    public int pop() {

        //判断是否kong
        if (ifEmpty()) {
            System.out.println("栈空 请插入数据进行测试");
            return 0;
        }
        //try { return stack[top]; } finally { top--; }这个方法着实有些撒比了
        //以为 show 和 pop两个之间的top会影响

        int cur = top;

        int value = stack[top];
        top--;
        return value;


    }
    //显示栈的情况 比如栈的size

    public void list() {
        if (ifEmpty()) {
            System.out.println("栈空 请插入数据进行测试");
            return;
        }
        for (int i = top; i > -1; i--) {

            System.out.println(stack[i]);

        }

    }
}



