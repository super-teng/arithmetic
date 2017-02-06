package 二维数组中的查找;

public class Solution {
	 public boolean Find(int [][] array,int target) {
	       boolean result = false;
	       if(array != null && array.length != 0){
	           int width = 0;
	           int height = array.length-1;
	           while(height>=0 && width<array[height].length){
	              int temp = array[height][width];
	              if(target>temp){
	                  width++;
	              }else if(target<temp){
	                  height--;
	              }else{
	                  result = true;
	                  break;
	              }
	           }
	       }else{
	           result = false;
	       }
	       return result;
	    }
}
