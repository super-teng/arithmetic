package 斐波那契数列.变态版本的青蛙跳格子;

public class Solution {
    public int JumpFloorII(int target) {
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
                array[i] = 2*array[i-1];
            }
            return array[array.length-1];
        }
    }
    //超屌的方法！！！！
    public int JumpFloorII2(int target) {
        if(target == 0){
            return 0;
        }else{
            return 1 << --target;
        }
    }
}