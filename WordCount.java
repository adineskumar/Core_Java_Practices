/* Search for a particular word and return the number of its occurrences 
 * Logic	- Pass file name as input
 * 			- Pass the word to be searched also an input
 * 			- Read the file line by line
 * 			- split the line based on the search word and count
 * 			- Always u will get the count +1 in addition 
 * 			- So subtract -1 from the result
 * 
 * Question - what if I need to read a file and list the max occurred word
 * 			- what if I need to read all the files in a folder and search for a word.
 */

package com.dinesh.corejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		try {
				// TODO Auto-generated method stub
				Scanner in = new Scanner(System.in);
				System.out.println("Enter the location and name of the file...");
				String file_name = in.nextLine();
				
				System.out.println("Enter the word to be searched...");
				String word = in.nextLine();
				
				FileReader fr = new FileReader(file_name);
				BufferedReader br = new BufferedReader(fr);
				
				String str;
				int count = 0;
				
				
				if (word != null){
				while ((str = br.readLine()) != null)  {
					count += str.split(word).length -1 ;
				}
				System.out.println(word+" occured "+count+" times in the file "+file_name);
				}
				
				
				
				br.close();
				in.close();
			}
		catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
			}

}
