package com.algo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

public class QuickSortPivotRandomNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = readFile();//{7, 11 , 3, 15, 20 , 2, 10, 9, 6, 18, 13};
		
		/*int i = 0;
		while(arr[i] != 0)
		{
			i++;
		}
		
		int arr1[] = Arrays.copyOfRange(arr, 0, i);*/
		
        
	       // System.out.print("Array");
	      //  printArray(arr, 0, nElements);
	        
			/*System.out.println("Unsorted array : ");
			printArray(arr, 0, arr1.length-1);*/
			System.out.println("Before " + System.currentTimeMillis() % 1000);
			myQuickSort(arr, 0, arr.length-1);
			System.out.println("After " + System.currentTimeMillis() % 1000);
			/*System.out.println("print sorted array :");
	        printArray(arr1, 0, arr1.length-1);*/
			
			try {
				PrintWriter writer = new PrintWriter("QuickSortOutputRandomPivot.txt", "UTF-8");
				
				for(int j = 0; j< arr.length; j++)
				{
					
					writer.println(String.valueOf(arr[j]));
				}
				
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	
	private static void myQuickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int i = low;
		int j = high;
		
		int p = findRandomPivot(arr, low, high);
		
		while(i < j)
		{
			while(arr[i] < p)
			{
				i++;
			}
			
			while(arr[j] > p)
			{
				j--;
			}
			
			if(i <= j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}
			
		}
		
		if(low < j)
		{
			myQuickSort(arr, low, j);
		}
		if(i < high)
		{
			myQuickSort(arr, i, high);
		}
		
	}

	private static int findRandomPivot(int[] arr, int low, int high)
	{
		Random rand = new Random();
		int num = low + rand.nextInt(high - low);
		
		return arr[num];
	}
	
	private static void printArray(int arr[],int low, int high)
    {
        System.out.print("[  ");
        for(int i=low;i<=high;i++)
        {
            System.out.print(arr[i] + "  ");
           // System.out.println();
        }
        System.out.println("]");
    }
	
	private static int[] readFile() {
		// TODO Auto-generated method stub
		int[] arr = new int[50000];
		 String fileName="RandomNumbers50K.txt";
	       try{

	          //Create object of FileReader
	          FileReader inputFile = new FileReader(fileName);

	          //Instantiate the BufferedReader Class
	          BufferedReader bufferReader = new BufferedReader(inputFile);

	          //Variable to hold the one line data
	          String line;

	          // Read file line by line and print on the console
	        int i = 0;
	          while ((line = bufferReader.readLine()) != null)   {
	        	  arr[i] = Integer.parseInt(line);
	        	  i++;
	            //System.out.println(line);
	          }
	          //Close the buffer reader
	          bufferReader.close();
	          
	          
	       }catch(Exception e){
	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
	       }
		return arr;
	}

}
