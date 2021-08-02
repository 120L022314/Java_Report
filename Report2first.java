/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */


package com.ring;

import java.util.Scanner;

public class Report2first 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in); //检测用户输入
		String s;
		int k;
		while(true) //确保循环一直进行，直到遇到循环内跳出语句
		{
				s=scan.nextLine(); //由用户输入字符串
				k=scan.nextInt();
				if(1<=k && k<s.length() && s.length()<=10000) break; //满足条件时跳出循环
		}
		scan.close();
		System.out.print(s.substring(k)+s.substring(0,k)); //对字符串进行操作
	}

}
