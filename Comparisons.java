
public class Comparisons {

	public static void main(String[] args) {
		int N=0;
		for(int w=0;w<3;w++){
			int makespan=0;
			int proc=0;
			int makespan2=0;
			int proc2=0;
			for(int i=0;i<10;i++){
				//writing the file
				writeFiles wFiles=new writeFiles();
				String s="data_"+w+"_"+i+".txt";
				if(w==0){
					N=100;
					wFiles.createFile(s,N);
				}else if(w==1){
					N=500;
					wFiles.createFile(s,N);
				}else{
					N=1000;
					wFiles.createFile(s,N);
				}
				//reading the file for algorithm1
				readFile rFiles=new readFile();
				rFiles.loadFile(s);

				//executing algorithm1
				processed_jobs jobs=new processed_jobs();
				rFiles.setList(jobs);
				MaxPQ<Processor> pq=new MaxPQ<Processor>(rFiles.getProcessors(),new ProcessorComparator());
			
				for(int j=0;j<rFiles.getProcessors();j++){
					Processor p=new Processor(j+1);
					pq.insert(p);
				}
			
				for(int j=0;j<rFiles.getJobs();j++){
					Processor ptemp=new Processor(0);
					ptemp=pq.getMin();
					ptemp.addJobs(jobs.remove());
					pq.insert(ptemp);
				}
				for(int j=0;j<rFiles.getProcessors();j++){
					Processor temp=new Processor(0);
					temp=pq.getMin();
					if(j==(rFiles.getProcessors()-1)){
					 	makespan+=temp.getActiveTime();
					 }	
				}
			
				proc=rFiles.getProcessors();
				//end of algorithm1
				//-----------------------------------------------------------------
				//executing algorithm2
				readFile rFiles2=new readFile();
				rFiles2.loadFile(s);
			
				processed_jobs jobs2=new processed_jobs();
				rFiles2.setList(jobs2);
				
				//pass lists values to an array
				int[] array=new int[rFiles2.getJobs()];
				for(int j=0;j<array.length;j++){
					array[j]=jobs2.remove();
				}

				//sorting this array
				Sort sort=new Sort();
				sort.mergesort(array, 0, array.length-1);
			
				MaxPQ<Processor> pq2=new MaxPQ<Processor>(rFiles2.getProcessors(),new ProcessorComparator());
			
				for(int j=0;j<rFiles2.getProcessors();j++){
					Processor p2=new Processor(j+1);
					pq2.insert(p2);
				}

				for(int j=0;j<rFiles2.getJobs();j++){
					Processor ptemp2=new Processor(0);
					ptemp2=pq2.getMin();
					ptemp2.addJobs(array[j]);
					pq2.insert(ptemp2);
				}
			
				for(int j=0;j<rFiles2.getProcessors();j++){
					Processor temp2=new Processor(0);
					temp2=pq2.getMin();
					if(j==(rFiles2.getProcessors()-1)){
						 makespan2+=temp2.getActiveTime();
					}
				}
				proc2=rFiles.getProcessors();
			}
			double m_o=makespan/proc;
			System.out.println("Greedy makespan for "+N+": "+(int)m_o);
			double m_o_2=makespan2/proc2;
			System.out.println("Sort makespan for "+N+": "+(int)m_o_2);
			System.out.println();
			System.out.println();
		}		
	}
}
