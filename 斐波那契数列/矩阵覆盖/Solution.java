package ì³²¨ÄÇÆõÊıÁĞ.¾ØÕó¸²¸Ç;

public class Solution {
	public int Fibonacci(int n) {
		if(n == 0){
            return 0;
        }else if(n== 1){
            return 1;
        }else{
            int[] array = new int[n+1];
            array[0] = 0;
            array[1] = 1;
            for(int i=2;i<array.length;i++){
                array[i] = array[i-1]+array[i-2];
            }
            return array[n];
        }
    }
}
