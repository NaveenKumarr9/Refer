package com.thbs.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHandling {
	public static void main(String[] args) {
		
		String[] names= {"Naveen","Kumar"};
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write("This is Naveen");
			for(String name: names) {
				writer.write("\n" + name);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
