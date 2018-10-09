

public class Processor {
	 int id;
	// We create an empty list
	 processed_jobs list = new processed_jobs();
	 
	 public Processor(int id){
		 this.id=id;
	 }
	
	int getActiveTime(){
		int active_time=0;
		for(int i=0;i<list.getSize();i++){
			int tmp=list.remove();
			active_time+=((Integer)tmp).intValue();
			list.insert(tmp);
		}
		return active_time;
	}
	int getId(){
		return id;
	}
	 
	 public int compareTo(Processor B){
		 if(getActiveTime()==B.getActiveTime()){
			 return 0;
		 }else if(getActiveTime()>B.getActiveTime()){
			 return 1;
		 }else{
			 return -1;
		 }
	 }
	 public void addJobs(int processing_time){
		 list.insert(processing_time);
	 }
	 public void printJobs(){
		 list.display();
	 }
}
