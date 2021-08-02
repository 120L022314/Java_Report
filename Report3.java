/*
在课程所讲的时钟程序的基础上实现有秒计时的数字万年历时钟。
必选内容：年、月、日、小时、分钟、秒的模拟；
可选内容：星期、农历的模拟。
*/
package com.ring;

import java.util.Scanner;

class Display //定义一个显示类，利用这个类可以定义出此类的对象，对象可以方便引用这个类里面的函数
{
	private int value,limit;//对象主要包含两个值，一个为现在的值，一个为上限
	
	public void Display(int value,int limit)
	{
		this.value=value;//将函数里的形参的值赋给此类对象的值
		this.limit=limit;
	}
	
	public int getValue()//调用函数得到值
	{
		return value;//返回对象的值
	}
	
	public void increase1()//由于年未设置上限，就一直加
	{
		value++;
	}
	public void increase2()//每个月以及每天的第一位都是1
	{
		value++;
		if(value==limit) value=1;
	}
	public void increase3()//小时、分钟、秒，进位后为0
	{
		value++;
		if(value==limit) value=0;
	}
	public int just(int y,int m)//判断是否为闰年以及每个月的天数
	{
		int limit1 = 30;//初始化每个月为30天
		switch(m)//选择月份对应的天数
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			{
				limit1=32;//大月31天
				break;
			}
			case 2:
			{
				limit1=29;//
				break;
			}
			case 4:
			case 6:
			case 9:
			case 11:
			{
				limit1=31;//
				break;
			}
		}
		if(y%400==0 || (y%4==0 && y%100!=0))
		{
			limit1=30;//
		}
		return limit1;//
	}
}

class Clock//定义一个类
{
	Display second1 = new Display();//在此类中定义一个Display的对象，下同
	Display minute1 = new Display();
	Display hour1 = new Display();
	Display day1 = new Display();
	Display month1 = new Display();
	Display year1 = new Display();
	
	public void Clock(int hour, int minute, int second, int year, int month, int day)//定义一个Clock函数，用来显示时间
	{
		second1.Display(second,60);//先把对应的用户输入的值传入对应对象的value中记录
		minute1.Display(minute, 60);
		hour1.Display(hour,24);
		year1.Display(year,10000);
		month1.Display(month,12);
		day1.Display(day,day1.just(year1.getValue(),month1.getValue()));
		for(;;)//循环显示时间
		{
			second1.increase3();//秒增加
			if(second1.getValue()==0)
			{
				minute1.increase3();//分钟增加
				if(minute1.getValue()==0)
				{
					hour1.increase3();//小时增加
					if(hour1.getValue()==0)
					{
						day1.increase2();//天数增加
						if(day1.getValue()==1)
						{
							month1.increase2();//月份增加
							if(month1.getValue()==2) day1.Display(day,day1.just(year1.getValue(),month1.getValue()));//每增加一个月，需要判断日上限的变化
							if(month1.getValue()==1)
								year1.increase1();//年增加
						}
					}
				}
			}
			try
			{
				Thread.sleep(1000);//休眠1s，实现每秒显示一次
			}catch(Exception e)
			{
				
			}
			System.out.printf("%04d:%02d:%02d:%02d:%02d:%02d\n",year1.getValue(),month1.getValue(),day1.getValue(),hour1.getValue(),minute1.getValue(),second1.getValue());//输出
		}
	}
	
}


public class Report3 
{
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("请输入现在的时:分:秒:年:月:日");//提示用户
		Clock clock = new Clock();//
		clock.Clock(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());//用户输入现在的时间
		in.close();
	}

}

