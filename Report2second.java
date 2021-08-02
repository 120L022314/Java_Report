/*
给你一个字符串数组words，数组中的每个字符串都可以看作是一个单词
请你按任意顺序返回words中是其他单词的子字符串的所有单词。
如果你可以删除 words[j]最左侧和/或最右侧的若干字符得到 word[i]
那么字符串 words[i] 就是 words[j] 的一个子字符串。
*/
package com.ring;

import java.util.Scanner;

public class Report2second 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in); //定义scan检测用户输入
		int n,i,j,p;
		n=scan.nextInt(); //由用户输入字符串数组的个数
		String []words=new String[n]; //定义字符串数组
		for(i=0;i<n;i++)
		{
			words[i]=scan.next(); //由用户输入数组中的每个字符串
		}
		scan.close();
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j) continue; //相同的不做比较
				else if(words[i].length()>words[j].length()) continue; //长的字符串不能是短字符串的子串
				else
				{
					int m=words[j].length()-words[i].length(); //定义m记录字符串长度的差
					for(p=0;p<(m+1);p++)
					{
						if(words[i].equals(words[j].substring(p,p+words[i].length()))) 
							//将字符串与另一个字符串的每个相同长度的部分进行比较
							System.out.print("\""+words[i]+"\",");
						
					}
				}
			}
		}
	}

}
