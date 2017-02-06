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
<<<<<<< HEAD
    public double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }else if(exponent == 0){
            return 1;
        }else if(exponent == 1){
            return base;
        }else if(exponent > 1){
        	
           double result = Power(base,exponent>>1);
           
           result *= result;
           if((exponent & 0x1) == 1){
               result *= base;
           }
          
           return result;
        }else {
        	
            exponent *= -1;
          
            double result = Power(base,exponent);
            result = 1/result;
            return result;
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.Power(2, -3));
    }
=======
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
}