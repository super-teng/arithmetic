package 快排算法;

import java.util.Stack;

//非递归的实现方式，通过使用一个栈来模拟递归栈的使用
public class Test03 {
	public static void main(String[] args){
		Test03 tt = new Test03();
		int[] array = {13,5213,52,1,6,37,352,27,25,63,7};
		tt.sort(array);
		for(int i : array){
			System.out.print(i +" ");
		}
	}
	//排序的主要方法，用这个方法来模拟递归中的递归栈的操作
	//这个其实就相当于原递归方法中递归调用本方法的两行代码
	public void sort(int[] array){
		if(array == null || array.length == 0){
			return ;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(array.length-1);
		while(!stack.isEmpty()){
			int right = stack.pop();
			int left = stack.pop();
			if(right <= left){
				continue;
			}
			int middle = getLocation(array,left,right);
			if(left < middle-1){
				stack.push(left);
				stack.push(middle-1);
			}
			if(right > middle+1){
				stack.push(middle+1);
				stack.push(right);
			}
		}
	}
	//找出中心位置的方法与原递归快排思路相同
	public int getLocation(int[] array,int left,int right){
		int i = left;
		int j = right;
		int temp = array[i];
		if(left< right){
			while(i<j){
				while(i<j && array[j] > temp){
					j--;
				}
				if(i<j){
					array[i] = array[j];
					i++;
				}
				while(i<j && array[i] < temp){
					i++;
				}
				if(i<j){
					array[j] = array[i];
					j--;
				}
			}
			array[i] = temp;
		}
		return i;
	}
}
