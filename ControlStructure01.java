package com.dinesh.corejava;

import java.util.Scanner;

public class ControlStructure01 {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number...");
		
		int s = in.nextInt();
		for (int i=0;i<= 2*s;i++)
		{
			if (i <= s)
			{
				System.out.println("Forward loop - "+i);
			}
			else 
			{
				System.out.println("Backward loop -"+(2*s-i));
			}
			
		}
		in.close();
	}
}
