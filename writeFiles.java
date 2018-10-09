import java.io.*;
import java.util.Random;
public class writeFiles {
	
	public void createFile  (String path, int jobs){
		File f = null;
		BufferedWriter writer = null;
		
		try	{
			f = new File(path);
		}
		catch (NullPointerException e) {
			System.err.println ("File not found.");
		}

		try	{
			writer = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream(f)));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}
		
		
		double d1=Math.sqrt(jobs);
		int processors=(int)d1;
		try{
			writer.write(processors+"\n"+jobs+"\n");
		
			for(int i=0;i<jobs;i++){
				Random dice=new Random();
				int number=1+dice.nextInt(100);
				
				writer.write(number+"\n");
			}
		}catch (IOException e) {
			System.err.println("Write error!");
		}
		
		try {
			writer.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
}
