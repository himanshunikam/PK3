import java.util.ArrayList;

public class Queue {
	ArrayList<Integer> items = new ArrayList<Integer>();
	int front, rear = -1;
	
	Queue(){}
	public void enqueue(int element) {
		if(front ==-1) {
			front=0;
		}
		rear++;
		items.set(rear, element);
	}
	public void dequeue() {
		items.remove(front);
		if(front>=rear) {
			front=-1;
			rear=-1;
		}else {
			front++;
		}
	}
	public boolean isEmpty() {
		if(front==-1) {
			return true;
		}else {
			return false;
		}
	}
}
