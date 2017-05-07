package com.algo;

public class TopKElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {7, 11 , 3, 15, 20 , 2, 10, 9, 6, 18, 13};
		int size = arr1.length;
		
		buildHeap(arr1,size);
		int topK = 3;
		
		findTopKElements(arr1,size,topK);

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
			
			System.out.println(i-k + "st top element :" + arr1[size]);
			size = size -1;
			heapify(arr1, 0 , size);
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
		
		if(left < N && arr1[left] > largest)
		{
			largest = arr1[left];
			swapIndex = left;
		}
		
		if(right < N && arr1[right] > largest)
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


















