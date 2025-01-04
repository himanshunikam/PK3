
public class List<E> {
	class Entry<E>{
		E element;
		Entry<E> next;
	}
	
	Entry<E> head;
	
	List(){}
	
	public E head() {
		if(head!=null) {
			return head.element;
		}else {
			return null;
		}
	}
	
	public void tail() {
		if(head!=null) {
			head=head.next;
		}
	}
	
	public List<E> add(E newElement){
		Entry<E> newEntry = new Entry<E>();
		newEntry.element=newElement;
		newEntry.next=head;
		head=newEntry;
		return this;
	}
	
	public int length() {
		int len=0;
		Entry<E> e= head;
		while(e!=null) {
			e= e.next;
			len++;
		}
		return len;
	}
	
	
}
