/*
����һ���ַ�������words�������е�ÿ���ַ��������Կ�����һ������
���㰴����˳�򷵻�words�����������ʵ����ַ��������е��ʡ�
��������ɾ�� words[j]������/�����Ҳ�������ַ��õ� word[i]
��ô�ַ��� words[i] ���� words[j] ��һ�����ַ�����
*/
package com.ring;

import java.util.Scanner;

public class Report2second 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in); //����scan����û�����
		int n,i,j,p;
		n=scan.nextInt(); //���û������ַ�������ĸ���
		String []words=new String[n]; //�����ַ�������
		for(i=0;i<n;i++)
		{
			words[i]=scan.next(); //���û����������е�ÿ���ַ���
		}
		scan.close();
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j) continue; //��ͬ�Ĳ����Ƚ�
				else if(words[i].length()>words[j].length()) continue; //�����ַ��������Ƕ��ַ������Ӵ�
				else
				{
					int m=words[j].length()-words[i].length(); //����m��¼�ַ������ȵĲ�
					for(p=0;p<(m+1);p++)
					{
						if(words[i].equals(words[j].substring(p,p+words[i].length()))) 
							//���ַ�������һ���ַ�����ÿ����ͬ���ȵĲ��ֽ��бȽ�
							System.out.print("\""+words[i]+"\",");
						
					}
				}
			}
		}
	}

}
