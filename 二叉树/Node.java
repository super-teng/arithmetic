package ¶þ²æÊ÷;

public class Node {
	private String data;
	private Node leftNode;
	private Node rightNode;
	
	public Node(){
		
	}
	public Node(String data,Node leftNode,Node rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}
