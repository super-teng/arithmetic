package 整数逆序后放入数组中递归实现;

public class Main {
	
	private int[] array;
	private int index = 0;
	
	public int[] transfer(int number){
		String num = String.valueOf(number);
		array = new int[num.length()];
		return this.trans(num);
	}
	
	public int[] trans(String number){
		if(number != null && number.length() > 0 ){
			index = number.length()-1;
			array[index] = number.charAt(0) - 48 ;
			this.trans(number.substring(1));
		}
		return array;
	}
	
	public int[] tt(int number,int[] arr){
		if(number > 0){
			arr[index++] = number % 10;
			number = number / 10;
			this.tt(number, arr);
		}
		return arr;
	}
	
	
	public static void main(String[] args){
		Main m = new Main();
		int number = 1234567890;
		int[] result = m.transfer(number);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
		System.out.println();
		int [] arr = new int[10];
		int[] reuslt = m.tt(number, arr);
		for(int i=0;i<reuslt.length;i++){
			System.out.print(reuslt[i]+" ");
		}
	}
}
