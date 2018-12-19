

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {

	private String path;
	private boolean appendToFile = false;

	public WriteFile(String filePath) {
		this.path = filePath;
	}

	public WriteFile(String filePath, boolean appendToFile) {
		this.path = filePath;
		this.appendToFile = appendToFile;
	}

	public void writeToFile(String text) throws IOException {
		FileWriter w = new FileWriter(path, appendToFile);
		PrintWriter pw = new PrintWriter(w);
		pw.printf("%s" + "%n", text);
		pw.close();
		System.out.println("WriteFile wrote to file " + path);
	}
}
