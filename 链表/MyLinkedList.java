package Á´±í;

public class MyLinkedList<E> {
	@SuppressWarnings("hiding")
	public class Node<E>{
		private E value;
		private Node<E> before;
		private Node<E> after;
		
		public Node(){
			
		}
		public Node(E value,Node<E> before,Node<E> after){
			this.value = value;
			this.before = before;
			this.after = after;
		}
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node<E> getBefore() {
			return before;
		}
		public void setBefore(Node<E> before) {
			this.before = before;
		}
		public Node<E> getAfter() {
			return after;
		}
		public void setAfter(Node<E> after) {
			this.after = after;
		}
	}
	private Node<E> header;
	public MyLinkedList(){
		header = new Node<E>(null,null,null);
		header.setBefore(header);
		header.setAfter(header);
	}
	//value before after
	public void add(E value){
		Node<E> n = new Node<E>(value,header.getBefore(),header);
		n.getBefore().setAfter(n);
		n.getAfter().setBefore(n);
	}
	public int length(){
		int i = 0;
		Node<E> n = header.getAfter();
		if(n == header){
			return i;
		}
		while(n!=header){
			n = n.getAfter();
			i++;
		}
		return i;
	}
	public E get(int index){
		Node<E> result = header;
		while(index>=0){
			result = result.getAfter();
			index--;
		}
		return result.getValue();
	}	
}
