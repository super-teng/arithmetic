package 面试算法.二维数组中查找;

public class Solution {
	//思路：从二维数组的左下角进行查找，大于时候往右移动，小于时候往左移动
    public boolean Find(int [][] array,int target) {
       int length = array.length-1;//纵坐标的值
       int index = 0;//横坐标的值
       boolean flag = false;
       while(length>=0 && index<=array[length].length-1){
    	   int temp = array[length][index];//左下角的值
    	   //左下角的值大于传入值的时候
    	   if(temp > target){
    		   length--;//纵坐标减减
    	   //左下角的值小于传入值的时候
    	   }else if(temp <target){
    	       index++;//横坐标加加   
    	   }else{
    		   flag = true;
    		   break;
    	   }
       }
       return flag;
    }
    public static void main(String[] args){
    	int i = 5;
    	int[][] re = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
    	Solution s = new Solution();
    	System.out.println(s.Find(re, i));
    }
}