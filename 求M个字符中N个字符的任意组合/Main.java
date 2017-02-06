package 求M个字符中N个字符的任意组合;


public class Main {
	
	private int n = 0;
	
	public void find(int count,int index,String result,char[] origin){
		if(count == n){
			System.out.println(result);
			count = 0;
			result = "";
		}else{
			if(index > origin.length - 1){
				return ;
			}
			find(count+1,index+1,result + origin[index],origin);//假如选中的时候
			find(count,index+1,result,origin);//假如没有选中
		}
	}
	
	
	public static void main(String[] args){
		Main m = new Main();
		char[] origin = {'a','b','c','d','e'};
		m.n = 2;
		String result = "";
		m.find(0, 0, result, origin);
	}
}
