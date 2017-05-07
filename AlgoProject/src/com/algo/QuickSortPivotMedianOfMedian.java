package com.algo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class QuickSortPivotMedianOfMedian {
	
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
			printArray(arr1, 0, arr1.length-1);*/
			System.out.println("Before " + System.currentTimeMillis() % 1000);
			myQuickSort(arr, 0, arr.length-1);
			System.out.println("After " + System.currentTimeMillis() % 1000);
			/*System.out.println("print sorted array :");
	        printArray(arr1, 0, arr1.length-1);*/
			
			try {
				PrintWriter writer = new PrintWriter("QuickSortOutputMedianPivot.txt", "UTF-8");
				
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
		
		int p = findPivot(arr,low,high);
		
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
	
	private static int findPivot(int[] arr, int low, int high) {

		if(high - low + 1 <= 20)
		{
			int smallArray[] = new int[high - low + 1];
			smallArray = Arrays.copyOfRange(arr, low, high+1);
			//Arrays.sort(smallArray);  //here implement Insertion sort.
			callInsertionSort(smallArray);
			return smallArray[smallArray.length/2];
		}
		
		int temp[] = null;
		
		int medians[] = new int[(int)Math.ceil((double)(high-low+1)/3)];
        int medianIndex = 0;
        
        while(low <= high)
        {
        	
        	temp = new int[Math.min(7,high-low+1)];
        	
        	for(int i = 0; i < 7 && low <= high ; i++){
        		
        		temp[i] = arr[low];
        		low++;
        	}
        	
        	//Arrays.sort(temp);
        	callInsertionSort(temp);
        	medians[medianIndex] = temp[temp.length/2];
        	medianIndex++;
        }
		
		
		return findPivot(medians, 0, medianIndex-1);
	}
	
	private static void callInsertionSort(int[] smallArray) {
		// TODO Auto-generated method stub
		
		int length = smallArray.length;
		int p;
		int value;
		for(int i = 1; i< length; i++)
		{
			value = smallArray[i];
			p = i;
			while(p > 0 && smallArray[p-1] > value)
			{
				smallArray[p] = smallArray[p-1];
				p--;
			}
			smallArray[p] = value;
			
		}
		
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
		int[] arr = new int[1000000];
		 String fileName="RandomNumbers1M.txt";
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
