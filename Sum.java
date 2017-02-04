package com.dinesh.corejava;

// import scanner class to scan/get input from the terminal
import java.util.Scanner;

public class Sum {
public static void main(String args[])
{
	int a,b,c;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter value for a...");
	a = in.nextInt();
	
	System.out.println("Enter value for b...");
	b = in.nextInt();
	
	c = a + b;
	System.out.println("Sum of "+a+" and "+b+" is..."+c);
	in.close();
}
}

