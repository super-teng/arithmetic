package Ë³Ğò²éÕÒ;

public class Test {
	public int sort(int[] target,int j){
		target[target.length-1] = j;
		int result = 0;
		for(int i=0;i<target.length;i++){
			if(target[i] == j){
				result = i;
				break;
			}
		}
		return result+1;
	}
	public static void main(String[] args){
		int[] target = {3,7,5,4,3,2,8,9,1,0};
		Test tt = new Test();
		System.out.println(tt.sort(target, 8));
	}
}
