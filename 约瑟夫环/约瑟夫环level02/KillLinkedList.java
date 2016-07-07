package 约瑟夫环.约瑟夫环level02;

import 约瑟夫环.MyLinkedList.Place;

public class KillLinkedList {
	//内部类表示当前节点所在的位置
	public class Place{
		private String place;
		private Place before;
		private Place after;
		public Place(){
			
		}
		public Place(String place,Place before,Place after){
			this.place = place;
			this.before = before;
			this.after = after;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public Place getBefore() {
			return before;
		}
		public void setBefore(Place before) {
			this.before = before;
		}
		public Place getAfter() {
			return after;
		}
		public void setAfter(Place after) {
			this.after = after;
		}
	}
	private Place header = new Place(null,null,null);
	
	public KillLinkedList(){
		header.setBefore(header);
		header.setAfter(header);
	}
	
	public Place getHeader() {
		return header;
	}

	public void setHeader(Place header) {
		this.header = header;
	}

	//添加节点
	public void add(String index){
		Place p = new Place(index,null,null);
		//后面为头结点
		p.setAfter(header);
		//前面为当前头结点的后一个
		p.setBefore(header.getBefore());
		//分别告知两边的下一个节点的情况
		p.getBefore().setAfter(p);
		p.getAfter().setBefore(p);
	}
	//获取当前某一元素
	public Place get(int index){ //1
		Place result = header;
		while(index>0){
			if(result.getAfter()!=header){
				result = result.getAfter();
				index--;
			}else{
				System.out.println("输入索引号码有误");
				return null;
			}
		}
		return result;
	}
	//获取当前链表长度
	public int size(){
		int length = 0;
		Place temp = header.getAfter();
		while(temp!=header){
			length++;
			temp = temp.getAfter();
		}
		return length;
	}
	//移除当前的节点  
	public void remove(Place p){
		Place before = p.getBefore();
		Place after = p.getAfter();
		before.setAfter(after);
		after.setBefore(before);
		p = null;
		System.gc();
	}
}
