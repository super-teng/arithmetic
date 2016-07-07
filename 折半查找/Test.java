package ’€∞Î≤È’“;

public class Test {
	
	public int seek(int[] target,int element){//9
		int result = 0;
		int left = 0;
		int right = target.length - 1;
		while(left<=right){
			int middle = (left +right)/2;
			if(target[middle] == element){
				result = middle;
				break;
			}else if(target[middle] > element){
				right = middle -1;
			}else if(target[middle] < element){
				left = middle + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] target = {0,1,2,3,4,5,6,7,8,9};
		Test tt = new Test();
		System.out.println(tt.seek(target, 0));
	}
}
