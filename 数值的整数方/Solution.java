package 数值的整数方;

public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0 && exponent!=0){
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
            result = 1.0/result;
            return result;
        }
    }
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
           System.out.println("您输入信息有误");
           return ; 
        }else{
           for(int i=0;i<array.length;i++){
               if((array[i] & 0x1) == 1){ //假如为奇数的话
                   //去找他前面的偶数
                   for (int j = i; j > 0; j--){
                       if (array[j - 1] % 2 == 0){
                           int t = array[j];
                           array[j] = array[j - 1];
                           array[j - 1] = t;
                       }
                   }
               }
           }
        }
    }
}
