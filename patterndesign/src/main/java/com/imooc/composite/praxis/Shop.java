package com.imooc.composite.praxis;

import java.util.Scanner;

public class Shop {
    private String coffee = "咖啡";
    private String coke = "可乐";
    private String tea = "茶";
    private double coffeeprice = 2.00;
    private double cokeprice = 3.00;
    private double teaprice = 5;
    private double price = 0.0;

    public Shop() {
    }

    public void getName(int i) {
        if (i == 1) {
            System.out.println("你选择的是咖啡");
        }
        if (i == 2) {
            System.out.println("你选择的是可乐");
        }
        if (i == 3) {
            System.out.println("你选择的是茶");
        }
    }

    public double getShopping(int i, double p) {
        if (i == 1) {
            if (p < coffeeprice) {
                System.out.println("您的钱不够买此商品");
            } else {
                price = p - coffeeprice;
            }
        }
        if (i == 2) {
            if (p < cokeprice) {
                System.out.println("您的钱不够买此商品");
            } else {
                price = p - cokeprice;
            }
        }
        if (i == 3) {
            if (p < teaprice) {
                System.out.println("您的钱不够买此商品");
            } else {
                price = p - teaprice;
            }
        }
        return price;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        try {
            System.out.println("请选择你想要的商品\n 1.咖啡 2.可乐 3.茶");
            Scanner si = new Scanner(System.in);
            int i = si.nextInt();
            System.out.println(" ");
            if (i > 3 || i < 1) {
                System.out.println("没有此产品");
            } else {
                shop.getName(i);
                System.out.println(" ");
                System.out.print("请付账:");
                Scanner sp = new Scanner(System.in);
                double p = sp.nextDouble();
                System.out.println(" ");
                if (shop.getShopping(i, p) != 0.0) {
                    System.out.println("找你的钱：" + shop.getShopping(i, p));
                }
            }
        } catch (Exception ex) {
            System.out.println("请正确输入!");
        }
    }
}