package 斐波那契数列.青蛙跳格子;
public class Solution {
    public int JumpFloor(int target) {
		if(target == 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            int[] array = new int[target];
            array[0] = 1;
            array[1] = 2;
            for(int i=2;i<array.length;i++){
                array[i] = array[i-1]+array[i-2];
            }
            return array[array.length-1];
        }
    }
}