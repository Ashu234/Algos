package com.algo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class QuickSortPivotFirstElement {
	
	public static void sort(int[] array)
    {
        quickSort(array, 0, array.length - 1);
    }
  
    public static void quickSort(int array[], int low, int high) 
    {
        int i = low, j = high;
        int temp;
        int pivot = array[low]; 
       // printArray(array, low, high);
        while (i <= j) 
        {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j) 
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
 
                i++;
                j--;
            }
        }       
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);
    }
   
    public static void main(String[] args) 
    {
        /*Scanner scan = new Scanner( System.in );        
        
        int n, i;
        
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();*/
    	
    	int[] arr = readFile();//{7, 11 , 3, 15, 20 , 2, 10, 9, 6, 18, 13};
		
		/*int i = 0;
		while(arr[i] != 0)
		{
			i++;
		}
		
		int array[] = Arrays.copyOfRange(arr, 0, i);*/
       
        //int array[] = new int[ n ];
       
       /* System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            array[i] = scan.nextInt(); */    
		System.out.println("Before " + System.currentTimeMillis() % 1000);
        sort(arr);
        System.out.println("After " + System.currentTimeMillis() % 1000);
        
        try {
			PrintWriter writer = new PrintWriter("QuickSortOutputFirstElementPiot.txt", "UTF-8");
			
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
       /* System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++)
            System.out.print(array[i]+" ");            
        System.out.println();*/            
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
