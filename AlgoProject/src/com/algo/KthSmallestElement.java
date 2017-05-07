package com.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;

public class KthSmallestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int nElements = 10001;
        int arr[] = new int[nElements];
        
        for(int i=0;i<nElements;i++)
        {
            arr[i] = (int)(2000*Math.random());
        }*/
		
		
		
		int[] arr = readFile();//{7, 11 , 3, 15, 20 , 2, 10, 9, 6, 18, 13};
		int i = 0;
		while(arr[i] != 0)
		{
			i++;
		}
		
		int arr1[] = Arrays.copyOfRange(arr, 0, i/5);
       // System.out.print("Array");
      //  printArray(arr, 0, nElements);
        
		/*System.out.println("Unsorted array : ");
		printArray(arr1, 0, arr1.length-1);*/
		
        int kthSmallest = 900;
        System.out.println("Before " + System.currentTimeMillis() % 1000);
        int kthSmallestValue = findKthSmallestElement(arr1,kthSmallest,0,arr1.length-1);
        System.out.println("After " + System.currentTimeMillis() % 1000);
        
        System.out.println(kthSmallest +"th smallest element : " + kthSmallestValue);
        
        //Arrays.sort(arr1);
        
       /* System.out.println("print sorted array :");
        printArray(arr1, 0, arr1.length-1);*/

	}
	
	private static int[] readFile() {
		// TODO Auto-generated method stub
		int[] arr = new int[10000];
		 String fileName="RandomNumbers.txt";
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

	private static int findKthSmallestElement(int[] arr, int k,int low, int high) {

		if(low == high)
		{
			return arr[low];
		}
		
		int partitionIndex = partition(arr,low,high);
		
		int l = partitionIndex - low + 1;
		
		if(l == k)
		{
			return arr[partitionIndex];
		}
		else if(l < k)
		{
			return findKthSmallestElement(arr, k-l, partitionIndex+1, high);
		}
		else
		{
		    return findKthSmallestElement(arr, k, low, partitionIndex-1);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		
		/*System.out.println("sub array being processes");
		printArray(arr, low, high);*/

		//int pivot = findRandomPivot(arr,low,high);
		int pivot = findPivot(arr,low,high);
		//System.out.println("pivot found :" + pivot);
		
		while(low < high)
		{
			while(arr[low] < pivot){
				
				low ++;
			}
			
			while(arr[high] > pivot){
				
				high --;
			}
			
			if(low == high)
			{
				low++;
			}
			
			if(low < high)
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			
			
		}
		
		return high;
	}
	
	private static int findRandomPivot(int[] arr, int low, int high)
	{
		Random rand = new Random();
		int num = low + rand.nextInt(high - low);
		
		return arr[num];
	}

	private static int findPivot(int[] arr, int low, int high) {

		if(high - low + 1 <= 9)
		{
			int smallArray[] = new int[high - low + 1];
			smallArray = Arrays.copyOfRange(arr, low, high+1);
			//Arrays.sort(smallArray);  //here implement Insertion sort.
			callInsertionSort(smallArray);
			return smallArray[smallArray.length/2];
		}
		
		int temp[] = null;
		
		int medians[] = new int[(int)Math.ceil((double)(high-low+1)/5)];
        int medianIndex = 0;
        
        while(low <= high)
        {
        	
        	temp = new int[Math.min(5,high-low+1)];
        	
        	for(int i = 0; i < 5 && low <= high ; i++){
        		
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

}
