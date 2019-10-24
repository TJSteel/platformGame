package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomFileReader {

	// all methods are static so the constructor should be private
	private CustomFileReader() {
	}

	public static String[] readTextFile(String filename) {
		File file = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		ArrayList<String> input = new ArrayList<String>();

		// try opening the file
		try {
			file = new File(filename);
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
		} catch (FileNotFoundException e) {
			ErrorHandler.HandleError("Error reading file, file not found: " + filename, e);
			return new String[] { "File Not Found" };
		} catch (UnsupportedEncodingException e) {
			ErrorHandler.HandleError("Error reading file, unsupported encoding: " + filename, e);
			return new String[] { "Unsupported Encoding" };
		} finally {

			String nextLine;
			try {
				while ((nextLine = br.readLine()) != null) {
					// process the line
					input.add(nextLine);
				}
				br.close();
			} catch (IOException e) {
				ErrorHandler.HandleError("IO Exception for file : " + filename, e);
			}

			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return input.toArray(new String[input.size()]);
	}
	
	public static void append(String filename, String[] input) {
		Path file = Paths.get(filename);
		List<String> lines = Arrays.asList(input);
		try {
			Files.write(file, lines, StandardCharsets.UTF_8 ,StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
