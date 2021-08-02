/*
��Կ����Ͻ��ܵġ��Զ��ۻ�����������������ǵ�VendingMachine��������ƺ���չ��������
��Ʋ�����µ��ࣺ������Person��
�Զ��ջ���ֻ����������Ʒ�����ֺ�ơ�ƣ�����ơ��ֻ����18�����ϵĳ����˹���
 */


package com.ring;

import java.util.Scanner;

class Person //�½����ڹ����ߵ�һ���࣬��¼�����ߵ�����
{
	public int age() //�жϹ������Ƿ����
	{
		System.out.println("Are you alredy 18? (true or false)"); //��ʾ������ȷ���Լ��Ƿ����
		Scanner in=new Scanner(System.in); //�û�����
		while(true) //����ѭ��һֱ���У�������������ʱ����ֵ
		{
			boolean g=in.nextBoolean();
			if(g==true)
			{
				return 1; //��ʾ�������ѳ��꣬���ر�ʶt
			}
			else if(g==false)
			{
				return 0;
			}
			else continue;
		}
		
	}
	public int payment() //��ȷ�����ߵĳ�ֵ��ʽ
	{
		System.out.println("Please choose one mode of recharge"); //��ʾ������ѡ��һ�ַ�ʽ
		System.out.println("1.WeChat.\n2.Zhifubao.\n3.Cash"); //3��ѡ��
		Scanner in=new Scanner(System.in);
		while(true) //����ѭ��һֱ���У���������ʱ������
		{
			int a1=in.nextInt(); //��¼������ѡ��Ĺ���ʽ
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
		return in.nextInt(); //���س�ֵ���
	}
}

public class VendingMachine //��¼����������
{
	private int balance = 0; //��ʼ�����Ϊ0
	private int price = 3; //��Ʒ�۸�Ϊ3
	private int total = balance; //��ʼ�������Ѷ�Ϊ0
	
	public void showPrompt() //�û���ӭ����
	{
		System.out.println("Welcome!");
	}
	
	public void goods(int t) //����������ʾ�ɹ��������Ʒ
	{
		if(t==1) System.out.println("Here are cola and beer!\nThe prices of both are 3$");
		else System.out.println("Here are cola!\nThe price is 3$");
	}
	
	public void showBalance() //�ٴ���ʾ�����Ƿ��㹻������Ʒ
	{
		System.out.println("\nyour balance is "+balance);
	}
	
	public void insertMoney(int amount) //��ֵ
	{
		balance += amount; //�µ����Ϊԭ�����ϳ�ֵ��Ľ��
	}
	
	public void getFood(int t) //�����Ʒ����ʾ����
	{
		System.out.println("Whice one do you like?");
		System.out.println("1.cola!");
		if(t==1) System.out.println("2.beer!"); //������������ܹ���ơ�Ƶ�ѡ��
		Scanner in=new Scanner(System.in);
		int q=in.nextInt(); //��ȡ�û�ѡ��
		if (balance>=price) //�ж�����Ƿ��㹻������Ʒ
		{
			System.out.println("Here you are!");
			total += price;
			balance -= price; //���Ϊ����ǰ����ȥ��Ʒ�۸�
		}
		else //Ǯ����
		{
			System.out.println("Not Enough!");
		}
	}
	
	public void back() //��Ǯ��ʽ����ȹ������Ʊ���ֽ��˿�
	{
		System.out.println("The only way to give back the balance is cash\nHere you are!");
	}

	public static void main(String[] args) 
	{
		
		VendingMachine vm = new VendingMachine();
		Person ps=new Person();
		vm.showPrompt(); //��ӭ�û�
		int t=ps.age(); //�ж��Ƿ����
		vm.goods(t); //չʾ��Ʒ
		vm.showBalance(); //չʾ���
		int p=ps.payment(); //��ֵ
		vm.insertMoney(p); //����ֵ�ɹ�
		vm.showBalance(); //��ʾ���
		vm.getFood(t); //������Ʒ
		vm.showBalance(); //��ʾ���
		vm.back(); //�˿�
	}

}
