package 最长公共字串;

//由中心向两边扩展法。时间复杂度为O(n^2)，空间复杂度为O(1)，稍好，并且易于理解，推荐使用
public class Test {	
	private static String longestPalindrome(String str){  
        int n=str.length();  //获取当前字符串的长度
        if(str==""){ 		//假如为空直接返回空串 
            return "";  
        }  
        String longest=str.substring(0, 1);  //截取第一个字符
        for(int i=0;i<n-1;i++){  		
            String p1=expandAroundCenter(str,i,i);  //判断奇数时的情况
            if(p1.length()>longest.length()){  
                longest=p1;  
            }  
            String p2=expandAroundCenter(str,i,i+1);  //判断偶数的情况
            if(p2.length()>longest.length()){  
                longest=p2;  
            }  
        }  
        return longest;       
    }  
      
    private static String expandAroundCenter(String str,int l,int r){  
        int n=str.length();       
        while(l>=0&&r<=n-1&&str.charAt(l)==str.charAt(r)){  
            l--;  
            r++;  
        }         
        /** 
         * 这里要注意,c++中的str.substr(beginIndex,length)的后一个参数是从beginIndex开始的长度，      
         * 而java中的str.substring(beginIndex,endIndex)的后一个参数是一个下标，应不小于beginIndex, 
         * 并且在获取的字符串中,不包括该下标， 
         */  
        return str.substring(l+1, r);         
    }  
    public static void main(String[] args){  
//        String str="djdslkAABCDEAfjdl1234321skjflkdsjfkldsababasdlkfjsdwieowowwpw";  
//        String s=longestPalindrome(str);  
//        System.out.println(s); 
    	String s = "abc";
    	System.out.println(s.substring(0,1));
    }

}
