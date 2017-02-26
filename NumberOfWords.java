package com.dinesh.corejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class NumberOfWords {

	 static int i,c=0,res;
	 static String delimiter = ",";
	    static int wordcount(String s)
	    {
	        String[] StrArr = s.split(delimiter);
	        c = StrArr.length;
	        return c;
	    }
	    
	    public static void main (String args[]) 
	    {
	        try {
	    	Scanner in  = new Scanner(System.in);
	    	System.out.println("Enter the file name...");
	    	String file_name = in.nextLine();
	    	
	    	FileReader fr = new FileReader(file_name);
	    	BufferedReader br = new BufferedReader(fr);
	    	
	    	String line;
	    	while ((line = br.readLine()) != null){
	    		res += NumberOfWords.wordcount(line);
	    	}
	    	
	        //string is always passed in double quotes
	        
	        System.out.println("The number of words in the String are :  "+res);
	        
	        in.close();
	        br.close();
	        
	    }
	        catch 	(Exception e) {//Catch exception if any
	                System.err.println("Error: " + e.getMessage());
	            }
	        }

}

