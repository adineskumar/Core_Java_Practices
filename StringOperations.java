package com.dinesh.corejava;

import java.util.Scanner;

public class StringOperations {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Demonstration for String Operations...");
		
		System.out.println("Enter the Input Text....");
		String inString = in.nextLine();
		
		if (!inString.isEmpty())
		{
			System.out.println(inString.toUpperCase());
			System.out.println(inString.toLowerCase());
			String temp[] = inString.split(" ");
			String outstr = null;
			for ( int j=0; j< temp.length; j++)
			{
				String initCap = new String(new char[]{temp[j].charAt(0)}).toUpperCase() + temp[j].substring(1,temp[j].length());
				if ( j==0 )
				{
					outstr = initCap;
				}
				else 
					{
					outstr = outstr + " " + initCap;
					}
			}
			System.out.println(outstr);
		in.close();
		}
	}
}
