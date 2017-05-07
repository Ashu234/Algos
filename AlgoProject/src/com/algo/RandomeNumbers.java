package com.algo;

import java.io.IOException;
import java.io.PrintWriter;

public class RandomeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //File out = new File("random.txt");
	     //   FileWriter fw = null;
	        int n = 1000000;
	        /*int low = 1;
	        int high = 10000;*/
	        // Try block: Most stream operations may throw IO exception
	        try {
	            // Create file writer object
	          //  fw = new FileWriter(out);
	            // Wrap the writer with buffered streams
	            //BufferedWriter writer = new BufferedWriter(fw);
	            PrintWriter writer = new PrintWriter("RandomNumbers1M.txt", "UTF-8");
	            int line;
	            //Random random = new Random();
	            while (n > 0) {
	                // Randomize an integer and write it to the output file
	                //line = random.nextInt(high-low) + low;
	                line = 1 + (int) (Math.random() * ((1000000 - 1) + 1));
	            	/*writer.write(line);
	                writer.newLine();*/
	                writer.println(String.valueOf(line));
	                n--;
	            }
	            // Close the stream
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(0);
	        }

	}

}
