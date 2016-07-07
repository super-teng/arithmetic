package √Ê ‘–°À„∑®;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
	
	public static List<String> getMaxSameSubStr(String str1, String str2, boolean includeSelf)
    {
		//String a = "abceLoveXyzasfdalllllfdsafdsfds";
		//String b = "erebgdLovegureererfdsfdsalllllfdsafdsa";
        String shortStr = str1.length() > str2.length()? str2: str1;
        String longStr = str1.length() > str2.length()? str1: str2;
        String temp = "";
        int subLength = 0;
        List<String> sameSubs = new ArrayList<String>();
        for(int i = 0; i < shortStr.length(); i++)
        {
            for(int j = i + 2; j <= shortStr.length(); j++)
            {
                temp = shortStr.substring(i, j);
                boolean flag1 = includeSelf && longStr.indexOf(temp) > 0;
                boolean flag2 = !includeSelf && !temp.equals(shortStr) && longStr.indexOf(temp) > 0;
                 
                if(flag1 || flag2)
                {
                    if(temp.length() > subLength)
                    {
                        subLength = temp.length();
                        sameSubs.clear();
                        sameSubs.add(temp);
                    }
                    else if(temp.length() == subLength)
                    {
                        sameSubs.add(temp);
                    }
                }
            }
        }
         
        return sameSubs;
    }
	public static void main(String[] args){
		String a = "abceLoveXyzasfdalllllfdsafdsfds";
		String b = "erebgdLovegureererfdsfdsalllllfdsafdsa";
		List<String> result = Test04.getMaxSameSubStr(a, b, true);
		for(String s:result){
			System.out.println(s);
		}
	}
}
