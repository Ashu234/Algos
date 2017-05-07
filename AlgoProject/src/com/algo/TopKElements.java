package com.algo;

public class TopKElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {6, 11 , 3, 15, 20 , 20, 10, 9, 6, 18, 13};
		int size = arr1.length;
		
		buildHeap(arr1,size);
		
		printHeap(arr1);
		int topK = 11;
		
		findTopKElements(arr1,size,topK);
		
		printHeap(arr1);

	}

	private static void printHeap(int[] arr1) {
		// TODO Auto-generated method stub
		for(int i = 0;i < arr1.length; i ++)
		{
			System.out.println(arr1[i]);
		}
		
	}

	private static void findTopKElements(int[] arr1, int N, int k) {
		// TODO Auto-generated method stub
		int size = N-1;
		int i = k+1;
		while(k > 0)
		{
			
			int temp = arr1[0];
			arr1[0] = arr1[size];
			arr1[size] = temp;
			
			size = size -1;
			if(size > 0)
			{
			heapify(arr1, 0 , size);
			}
			System.out.println(i-k + "st top element :" + arr1[size+1]);
			k--;
			
		}
		
	}

	private static void buildHeap(int[] arr1, int N) {
		// TODO Auto-generated method stub
		
		for(int i= N/2-1; i>=0; i--)
		{
			heapify(arr1, i , N);
		}
		
		
	}

	private static void heapify(int[] arr1, int i, int N) {
		// TODO Auto-generated method stub
		int largest = arr1[i];
		int left = 2*i + 1;
		int right = 2*i + 2;
		int swapIndex = i;
		
		if((left < N || left == 1 )&& arr1[left] > largest)
		{
			largest = arr1[left];
			swapIndex = left;
		}
		
		if(right <= N && arr1[right] > largest)
		{
			largest = arr1[right];
			swapIndex = right;
		}
		
		if(largest != arr1[i])
		{
			int temp = arr1[swapIndex];
			arr1[swapIndex] = arr1[i];
			arr1[i] = temp;
			
			heapify(arr1, swapIndex, N);
		}
		
		
	}

}


















