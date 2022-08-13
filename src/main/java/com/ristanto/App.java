package com.ristanto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * given people whose age of death and year of death are known, find the average number of 
 * people the witch killed on year of birth of those people
 */
public class App 
{
//	get number of dead by year
	public static int getNumberOfDead(int year) {
		int add = 1;
		ArrayList<Integer> count = new ArrayList<Integer>();
		for(int i = 0; i<year; i++) {
			if(count.size() < 2) {
				count.add(i+add);
			}else {
				int last_index = count.get(count.size() - 1);
				int second_last_index = count.get(count.size() - 2);
				count.add(last_index+second_last_index+add);
			}
		}
		
		return count.get(count.size() - 1);
	}
	
	
	public static int killedPeopel(int aod, int yod) {
		if(aod > 0 || yod > 0) {
			int born = yod - aod;
			return getNumberOfDead(born);
		}else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
        int iterator, current_number = 1, aod, yod, n;
        
        System.out.print("Number of People :"); 
        n = sc.nextInt(); 
        
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
        	
        	System.out.print("Age of death :"); 
            aod = sc.nextInt(); 
            
            System.out.print("Year of Death :"); 
            yod = sc.nextInt(); 
            
            System.out.println();
            
            data.add(killedPeopel(aod, yod));
		}
        
        float total = 0;
        for (int i = 0; i < data.size(); i++) {
			total = total + data.get(i);
		}
        
        float avg = total/n;
        
        System.out.println("the average is : " + avg);
	}
}
