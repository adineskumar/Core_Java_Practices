package com.dinesh.corejava;

import java.util.Scanner;

public class TypeCast {
	public static void main(String[] args)
	{
		// byte can hold data from -128 to 127
		// if the values are greater/beyond this range 
		// then this range can be converted into byte range using the type casting method 
		double a = 0;
		System.out.println("Enter the value to check type casting...");
		Scanner in = new Scanner(System.in);
		
		double i =in.nextDouble();
		a= (byte) i;	
		System.out.println("input "+i+" is converted to byte..."+a);
		
		a=(short) i;
		System.out.println("input "+i+" is converted to short..."+a);
		
		a=(long) i;
		System.out.println("input "+i+" is converted to long..."+a);
		
		a=(float) i;
		System.out.println("input "+i+" is converted to float..."+a);
		
		a=(double) i;
		System.out.println("input "+i+" is converted to double..."+a);
		in.close();
		}
		
	}
