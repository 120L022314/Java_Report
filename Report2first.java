/*
�ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
�붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
���磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 */


package com.ring;

import java.util.Scanner;

public class Report2first 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in); //����û�����
		String s;
		int k;
		while(true) //ȷ��ѭ��һֱ���У�ֱ������ѭ�����������
		{
				s=scan.nextLine(); //���û������ַ���
				k=scan.nextInt();
				if(1<=k && k<s.length() && s.length()<=10000) break; //��������ʱ����ѭ��
		}
		scan.close();
		System.out.print(s.substring(k)+s.substring(0,k)); //���ַ������в���
	}

}
