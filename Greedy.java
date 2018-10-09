public class Greedy {
	public static void main(String[] args) {
		// we load the file 
		readFile file=new readFile();
		file.loadFile("input.txt");
		//-------------------------
		
		//We pass the values from the .txt file to a list
		processed_jobs jobs=new processed_jobs();
		file.setList(jobs);
		
		
		MaxPQ<Processor> pq=new MaxPQ<Processor>(file.getProcessors(),new ProcessorComparator());
		
		for(int i=0;i<file.getProcessors();i++){
			if(i==0||i==1){
			Processor p=new Processor(i+2);
			pq.insert(p);
			}
			if(i==2){
			Processor p=new Processor(i-1);
			pq.insert(p);
			}


		}
		
		for(int i=0;i<file.getJobs();i++){
			Processor ptemp=new Processor(0);
			ptemp=pq.getMin();
			ptemp.addJobs(jobs.remove());
			pq.insert(ptemp);
		}
		
		if(file.getJobs()<100){
			for(int i=0;i<file.getProcessors();i++){
				Processor temp=new Processor(0);
				temp=pq.getMin();
				System.out.print("id: "+temp.getId()+" load = "+temp.getActiveTime()+" :   ");
				temp.printJobs();
				System.out.println();
				if(i==(file.getProcessors()-1)){
					System.out.println("Makespan = "+temp.getActiveTime());
				}
			}
		}else{
			for(int i=0;i<file.getProcessors();i++){
				Processor temp=new Processor(0);
				temp=pq.getMin();
				if(i==(file.getProcessors()-1)){
					System.out.println("Makespan = "+temp.getActiveTime());
				}
			}
		}
	}
}

