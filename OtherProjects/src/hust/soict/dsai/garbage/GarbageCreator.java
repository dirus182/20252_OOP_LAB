package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
	public static void main(String[] args) {
		String filename = "test.exe"; // Hãy copy 1 file bất kỳ nặng nặng vào thư mục dự án và đổi tên ở đây
		byte[] inputBytes = { 0 };
		long startTime, endTime;

		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
			startTime = System.currentTimeMillis();
			String outputString = "";
			for (byte b : inputBytes) {
				outputString += (char) b;
			}
			endTime = System.currentTimeMillis();
			System.out.println("Time: " + (endTime - startTime));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}