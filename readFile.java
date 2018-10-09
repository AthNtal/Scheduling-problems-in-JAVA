import java.io.*;
public class readFile {
	processed_jobs lJobs= new processed_jobs();
	int jobs=0;
	int processors=0;
	
	public void loadFile(String data){
		File f=null;
		BufferedReader reader=null;
		String line;	
		try{
			f = new File(data);
		}catch(NullPointerException e){
			System.err.println("File not found.");
		}	
		
		try{
			reader = new BufferedReader(new FileReader(f));
		}catch(FileNotFoundException e){
			System.err.println("Error opening file");
		}
					
		try{
			line=reader.readLine();
			while(line!=null){
					processors=Integer.parseInt(line.substring(0));
					line=reader.readLine();
					jobs=Integer.parseInt(line.substring(0));
					line=reader.readLine();
					  
					for(int i=0;i<jobs;i++){
					    lJobs.insert(Integer.parseInt(line.substring(0)));
						line =reader.readLine();
					}
				
			}
		}catch(IOException e){
			System.out.println("Error reading line...");
		}
		
		try{
			reader.close();
		}catch(IOException e){
			System.err.println("Error closing file...");
		}
	}
	
	int getJobs(){
		return jobs;
	}
	int getProcessors(){
		return processors;
	}
	 
	void setList(processed_jobs list){
		for(int i=0;i<jobs;i++){
		list.insert(lJobs.remove());
		}
	}
}


