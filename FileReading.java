package com.dinesh.corejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReading {
public static void main(String args[]) throws Exception
{
	String FILENAME;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the location of the filename...");
	FILENAME = in.nextLine();
	
	try {
	FileReader fr = new FileReader(FILENAME);
	BufferedReader br = new BufferedReader(fr);
	
	String sCurrentLine;
	while ((sCurrentLine = br.readLine()) != null)
	{
		System.out.println(sCurrentLine);
	}
	br.close();
	}
	catch (IOException e){
		e.printStackTrace();
		
	}
	in.close();
}
}