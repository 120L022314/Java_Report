/*
针对课堂上介绍的“自动售货机场景”，请对我们的VendingMachine类进行完善和扩展，包括：
设计并添加新的类：购买人Person；
自动收货集只出售两种商品：可乐和啤酒，其中啤酒只允许18岁以上的成年人购买。
 */


package com.ring;

import java.util.Scanner;

class Person //新建关于购买者的一个类，记录购买者的属性
{
	public int age() //判断购买者是否成年
	{
		System.out.println("Are you alredy 18? (true or false)"); //提示购买者确定自己是否成年
		Scanner in=new Scanner(System.in); //用户输入
		while(true) //保持循环一直进行，除非满足条件时返回值
		{
			boolean g=in.nextBoolean();
			if(g==true)
			{
				return 1; //表示购买者已成年，返回标识t
			}
			else if(g==false)
			{
				return 0;
			}
			else continue;
		}
		
	}
	public int payment() //明确购买者的充值方式
	{
		System.out.println("Please choose one mode of recharge"); //提示购买者选择一种方式
		System.out.println("1.WeChat.\n2.Zhifubao.\n3.Cash"); //3种选项
		Scanner in=new Scanner(System.in);
		while(true) //保持循环一直进行，符合条件时会跳出
		{
			int a1=in.nextInt(); //记录购买者选择的购买方式
			if(a1==1) 
			{
				System.out.println("Please use WeChat to scan the code!");
				break;
			}
			else if(a1==2)
			{
				System.out.println("Please use Zhifubao to scan the code!");
				break;
			}
			else if(a1==3)
			{
				System.out.println("Please use Cash");
				break;
			}
			else continue;
		}
		System.out.println("Please fill it with the balance\ninput one amonut");
		return in.nextInt(); //返回充值金额
	}
}

public class VendingMachine //记录机器的属性
{
	private int balance = 0; //初始化余额为0
	private int price = 3; //商品价格为3
	private int total = balance; //初始化总消费额为0
	
	public void showPrompt() //用户欢迎界面
	{
		System.out.println("Welcome!");
	}
	
	public void goods(int t) //根据年龄显示可供购买的商品
	{
		if(t==1) System.out.println("Here are cola and beer!\nThe prices of both are 3$");
		else System.out.println("Here are cola!\nThe price is 3$");
	}
	
	public void showBalance() //再次显示余额，看是否足够购买商品
	{
		System.out.println("\nyour balance is "+balance);
	}
	
	public void insertMoney(int amount) //充值
	{
		balance += amount; //新的余额为原余额加上充值后的金额
	}
	
	public void getFood(int t) //获得商品或提示余额不足
	{
		System.out.println("Whice one do you like?");
		System.out.println("1.cola!");
		if(t==1) System.out.println("2.beer!"); //如果成年会给出能购买啤酒的选项
		Scanner in=new Scanner(System.in);
		int q=in.nextInt(); //读取用户选项
		if (balance>=price) //判断余额是否足够购买商品
		{
			System.out.println("Here you are!");
			total += price;
			balance -= price; //余额为购买前余额减去商品价格
		}
		else //钱不够
		{
			System.out.println("Not Enough!");
		}
	}
	
	public void back() //退钱方式，类比购买地铁票，现金退款
	{
		System.out.println("The only way to give back the balance is cash\nHere you are!");
	}

	public static void main(String[] args) 
	{
		
		VendingMachine vm = new VendingMachine();
		Person ps=new Person();
		vm.showPrompt(); //欢迎用户
		int t=ps.age(); //判断是否成年
		vm.goods(t); //展示商品
		vm.showBalance(); //展示余额
		int p=ps.payment(); //充值
		vm.insertMoney(p); //余额充值成功
		vm.showBalance(); //显示余额
		vm.getFood(t); //购买商品
		vm.showBalance(); //显示余额
		vm.back(); //退款
	}

}
