package 约瑟夫环;

public class MyLinkedList {
	//内部类 place用于包裹链表的节点信息 包含当前位置信息 前一个节点和后一个节点
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
	public Place header = new Place(null,null,null);
	public MyLinkedList(){
		header.setBefore(header);
		header.setAfter(header);
	}
	//添加元素的方法
	public void add(String value){
		Place p = new Place(value,null,null);
		p.setAfter(header);
		p.setBefore(header.getBefore());
		p.getBefore().setAfter(p);
		p.getAfter().setBefore(p);
	}
	//按索引号获得元素
	public Place get(int index){
		Place result = header;
		while(index>0){
			if(result.getAfter()!=header){
				result = result.getAfter();
				index--;
			}else{
				System.out.println("输入索引超过链表长度或当前链表为空");
				System.exit(0);
			}
		}
		return result;
	}
	//判断元素的长度
	public int size(){
		int length =0 ;
		Place result = header;
		while(result.getAfter()!=header){
			result = result.getAfter();
			length++;
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
