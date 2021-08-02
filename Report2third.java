/*
在一个[平衡字符串]中,'L'和'R'字符的数量是相同的
给出一个平衡字符串 s,请你将它分割成尽可能多的平衡字符串
返回可以通过分割得到的平衡字符串的最大数量
*/

package com.ring;

import java.util.Scanner;

public class Report2third 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in); //检测用户输入
		String s; //定义要接受用户输入的数组
		int n1,n2,i,count=0,k=0,flag;
		do
		{
			n1=0; 
			n2=0; //初始化R和L的数量为0
			s=scan.next(); //由用户输入字符串
			char []c=new char[s.length()]; //定义字符数组接收字符串
			for(i=0;i<s.length();i++)
			{
				c[i]=s.charAt(i); //遍历字符串，转化为字符数组
				if(c[i]=='L') n1++;
				else if(c[i]=='R') n2++; //统计R和L的数量
			}
		}while(n1!=n2 || (n1+n2)!=s.length() || s.length()>1000); //当不符合要求的时候重复循环，重新输入字符串
		scan.close();
		char []b=new char[s.length()]; //定义新字符数组接收字符串s
		for(i=0;i<s.length();i++)
		{
			b[i]=s.charAt(i); //同上，把字符串转化为字符数组
		}
		for(i=0;i<s.length()-1;)
		{
			flag=0; //定义标识符，判断是否在循环内执行过某一判断语句
			n1=1; //初始化R和L个数为1
			n2=1;
			while(i<s.length()-1 && b[i]==b[i+1])
			{
				i++; //i递增，来逐渐向后推
				n1++; //满足条件时，R或L个数增加
			}
			i++; //结束循环表示不满足条件了，需要再向下推一位
			k=i; //k标志一个位置
			while(i<s.length()-1 && b[i]==b[i+1])
			{
				if(n1==n2)
				{
					count++; //满足条件的字串个数加1
					k=i+1; //此时前面的字串已被隔开，位置移到下一位
					flag=1; //标志在循环内已执行语句，循环外不再执行
					break; //满足条件后跳出循环
				}
				i++; //
				n2++; //
			}
			if(flag==0 && n1==n2)
			{
				count++; 
				k=i+1; 
			}
			i=k; //把i移到标志位置处，开始下一次判断
		}
		System.out.print(count);
	}

}
