package advance_java.day3.fileHandling;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
	public static void main(String[] args) throws IOException{
		// It wont create physical file, it just pointing to that path
		// Creating the File
		File file = new File("src/test.java");
		System.out.println("File Object Created");
		
		if(file.createNewFile()) {
			System.out.println("File Created");
		}else {
			System.out.println("File Already Exists");
		}
		
		// Writing in File
		FileWriter writer = new FileWriter("src/test.java", true);
		writer.write("Hello");
		writer.close();
		System.out.println("Completed");
		
	}

}


// File - represents a file or folder
// FileWriter - write text to file
// FileReader- read text from file
// BufferedWriter - fast writing
// BufferedReader - fast reading