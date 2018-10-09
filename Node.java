public class Node {
		 int data;
		 Node next;
		 
		Node(int data,Node next){
			this.data=data;
			this.next=next;
		}
		
		Node(int data){
			this(data, null);
			}
		//getter
		int getObject(){return data;}
		//setter
		void setObject(int data){this.data=data;}
		
		Node getNext(){
			return next;
		}
	}


