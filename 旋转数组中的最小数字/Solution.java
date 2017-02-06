package 旋转数组中的最小数字;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	if(array.length == 0){
            return 0;
        }
        int i = 0;
        if(array[i] < array[array.length-1]){
            return array[i];
        }else{
            while(i<array.length && array[i] <= array[++i]);
            return array[i];
        }
    }
}