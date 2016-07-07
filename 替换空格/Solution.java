package 替换空格;

import java.util.ArrayList;

public class Solution {
	//正常思路时间复杂度为O（N^2）
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
    	String s = str.toString();
        char[] st = s.toCharArray();
        for(int i =0;i<st.length;i++){
        	if(st[i] == ' '){
            	result.append("%20");    
            }else{
                result.append(st[i]);
            }
        }
        return result.toString();
    }
    //从后往前进行加载这样效率更加高效时间复杂度O（N）
    public String replaceSpace2(StringBuffer str) {
        String s = str.toString();
        int count = 0;
        char[] c1 = s.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(c1[i] == ' '){
                count++;
            }
        }
        char[] c2 = new char[c1.length+count*2];
        int index = c2.length-1;
  	  for(int i=c1.length-1;i>=0;i--){
            if(c1[i]!=' '){
                c2[index--] = c1[i];
            }else{
                c2[index--] = '0';
                c2[index--] = '2';
                c2[index--] = '%';
            }
        }
        String result = new String(c2);
        ArrayList al = new ArrayList();
        Stack st = new Stack();
        st.i
        return result;
    }
}
