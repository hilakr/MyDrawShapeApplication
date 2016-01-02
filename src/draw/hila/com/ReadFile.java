package draw.hila.com;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

	private Scanner x;
	
	public void openFile() {
		try{
			x = new Scanner(new File("Shapes.txt"));
			System.out.println("open succssefully");
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}
