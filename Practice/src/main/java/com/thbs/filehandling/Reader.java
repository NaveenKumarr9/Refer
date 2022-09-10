package com.thbs.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			// System.out.println(reader.readLine());
			reader.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
