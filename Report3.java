/*
�ڿγ�������ʱ�ӳ���Ļ�����ʵ�������ʱ������������ʱ�ӡ�
��ѡ���ݣ��ꡢ�¡��ա�Сʱ�����ӡ����ģ�⣻
��ѡ���ݣ����ڡ�ũ����ģ�⡣
*/
package com.ring;

import java.util.Scanner;

class Display //����һ����ʾ�࣬�����������Զ��������Ķ��󣬶�����Է����������������ĺ���
{
	private int value,limit;//������Ҫ��������ֵ��һ��Ϊ���ڵ�ֵ��һ��Ϊ����
	
	public void Display(int value,int limit)
	{
		this.value=value;//����������βε�ֵ������������ֵ
		this.limit=limit;
	}
	
	public int getValue()//���ú����õ�ֵ
	{
		return value;//���ض����ֵ
	}
	
	public void increase1()//������δ�������ޣ���һֱ��
	{
		value++;
	}
	public void increase2()//ÿ�����Լ�ÿ��ĵ�һλ����1
	{
		value++;
		if(value==limit) value=1;
	}
	public void increase3()//Сʱ�����ӡ��룬��λ��Ϊ0
	{
		value++;
		if(value==limit) value=0;
	}
	public int just(int y,int m)//�ж��Ƿ�Ϊ�����Լ�ÿ���µ�����
	{
		int limit1 = 30;//��ʼ��ÿ����Ϊ30��
		switch(m)//ѡ���·ݶ�Ӧ������
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			{
				limit1=32;//����31��
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

class Clock//����һ����
{
	Display second1 = new Display();//�ڴ����ж���һ��Display�Ķ�����ͬ
	Display minute1 = new Display();
	Display hour1 = new Display();
	Display day1 = new Display();
	Display month1 = new Display();
	Display year1 = new Display();
	
	public void Clock(int hour, int minute, int second, int year, int month, int day)//����һ��Clock������������ʾʱ��
	{
		second1.Display(second,60);//�ȰѶ�Ӧ���û������ֵ�����Ӧ�����value�м�¼
		minute1.Display(minute, 60);
		hour1.Display(hour,24);
		year1.Display(year,10000);
		month1.Display(month,12);
		day1.Display(day,day1.just(year1.getValue(),month1.getValue()));
		for(;;)//ѭ����ʾʱ��
		{
			second1.increase3();//������
			if(second1.getValue()==0)
			{
				minute1.increase3();//��������
				if(minute1.getValue()==0)
				{
					hour1.increase3();//Сʱ����
					if(hour1.getValue()==0)
					{
						day1.increase2();//��������
						if(day1.getValue()==1)
						{
							month1.increase2();//�·�����
							if(month1.getValue()==2) day1.Display(day,day1.just(year1.getValue(),month1.getValue()));//ÿ����һ���£���Ҫ�ж������޵ı仯
							if(month1.getValue()==1)
								year1.increase1();//������
						}
					}
				}
			}
			try
			{
				Thread.sleep(1000);//����1s��ʵ��ÿ����ʾһ��
			}catch(Exception e)
			{
				
			}
			System.out.printf("%04d:%02d:%02d:%02d:%02d:%02d\n",year1.getValue(),month1.getValue(),day1.getValue(),hour1.getValue(),minute1.getValue(),second1.getValue());//���
		}
	}
	
}


public class Report3 
{
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("���������ڵ�ʱ:��:��:��:��:��");//��ʾ�û�
		Clock clock = new Clock();//
		clock.Clock(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());//�û��������ڵ�ʱ��
		in.close();
	}

}

