package 数组中出现次数超过一半的数字;

import java.util.ArrayList;

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int number = array[0];
        int count = 1;
        for(int i = 1 ;i<array.length;i++){
            if(count == 0){
                number = array[i];
                count ++;
            }
            if(array[i] == number){
                count ++;
            }else{
                count --;
            }
        }
        if(count < 1){
            return 0;
        }else{
            int count2 = 0;
            for(int i =0;i<array.length;i++){
                if(array[i] == number){
                    count2++;
                }
            }
            if(count2 > array.length/2){
                return number;
            }else{
                return 0;
            }
        }
    }
    public static void main(String[] args){
    	int[] a = {5,4,32,2,1};
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    }
}
