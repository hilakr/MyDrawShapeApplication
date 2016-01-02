package draw.hila.com;

public class MyDrawShapeApplication {


	public static void main(String[] args) {
		
		ReadFile file = new ReadFile();
		file.openFile();
		file.parseFile();
		final MyWindow window = new MyWindow();
		
		//final DrawShape panel = new DrawShape();
		   
    }

}
