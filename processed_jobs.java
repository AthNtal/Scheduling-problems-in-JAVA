public class processed_jobs {	
	public Node firstNode,lastNode;
	int size=0,sum=0;
	
	public processed_jobs(){
		firstNode = lastNode = null;	
	}
	
	public void insert(int item){
		Node node= new Node(item);
		if(isEmpty()){
			firstNode=lastNode=node;
		}else{
			lastNode.next=node;
			lastNode=node;
		}
		sum+=item;
		size++;
	}

	public int remove(){
		int removedItem= firstNode.getObject();
		if ( firstNode == lastNode )
			firstNode = lastNode = null;
		else
			firstNode = firstNode.next;
		
		sum-=removedItem;
		size--;
		return removedItem;
	}
	
	int getTime(){
		return sum;
	}
	int getSize(){
		return size;
	}
	
	boolean isEmpty(){
		return size==0;
	}
	public void display(){
		if(isEmpty())return;
		Node current=firstNode;
		while(current!=null){
			System.out.print(current.getObject()+" ");
			current=current.next;
		}
	}
}

