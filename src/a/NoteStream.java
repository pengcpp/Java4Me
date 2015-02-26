package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Stream ...
 * 
 * @author Three 2/26/2014
 * 
 */
public class NoteStream {

	public static void main(String[] args) throws IOException {
		System.out.println("NoteStream...");

//		BRRead();

		BRReadLines();
	}

	public static void BRRead() throws IOException {
		char c;
		// 使用 System.in 创建 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter characters, 'q' to quit.");
		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != 'q');
	}

	public static void BRReadLines() throws IOException {

		// 使用 System.in 创建 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'end' to quit.");
		do {
			str = br.readLine();
			System.out.println(str);
		} while (!str.equals("end"));
	}
}
