package com.yichangkong;

import javafx.scene.input.DataFormat;
import sun.rmi.runtime.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-02-21-17:54
 */
public class brithComputer {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的生日 年/月/日 xxxx/xx/xx");

        String str = sc.nextLine();

        DateFormat df =  new SimpleDateFormat("yy/mm/dd");

        Date brith = df.parse(str);

        Date taday = new Date();

        Long begin = brith.getTime();

        long now = taday.getTime();

        System.out.println("你已经活了"+(now-begin)/1000/60/60/24+"天");











    }



}
