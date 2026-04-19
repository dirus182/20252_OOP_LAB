package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
		String filename = "test.exe";
		byte[] inputBytes = { 0 };
		long startTime, endTime;

		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
			startTime = System.currentTimeMillis();

			// Dùng StringBuilder để tối ưu hiệu suất
			StringBuilder outputStringBuilder = new StringBuilder();
			for (byte b : inputBytes) {
				outputStringBuilder.append((char) b);
			}

			endTime = System.currentTimeMillis();
			System.out.println("Time: " + (endTime - startTime));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}