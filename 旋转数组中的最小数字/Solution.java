package 旋转数组中的最小数字;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
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