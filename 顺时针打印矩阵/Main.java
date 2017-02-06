package À≥ ±’Î¥Ú”°æÿ’Û;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static List<String> executeString (List<String> strList,int maxLength){

        List<String> demo = strList;
        String answerList = null;


        int sum=maxLength;


        while(!demo.isEmpty()&&demo.get(0).length()<=sum&&!demo.get(0).equals("")&&demo.get(0)!=null){
            if(answerList==null)
                answerList = demo.get(0);
            else
                answerList = answerList + " " + demo.get(0);
            sum -= (demo.get(0).length()+1);
            demo.remove(0);
        }



        System.out.println(fillchar(answerList,maxLength));

        if(demo!=null&&!demo.equals(""))
            return demo;
        else
            return null;
    }




    public static String fillchar(String str, int maxLength ){
        if (str.length()==maxLength)
            return str;
        String[] demo3 = str.split(" ");

        int charNum =0;
        for(String ss:demo3){
            charNum += ss.length();
        }
        while (charNum!=maxLength){
            for(int i=0;i<demo3.length;i++){
                if(i==0||i!=demo3.length-1){
                    String de = demo3[i];
                    de = de+ " ";
                    demo3[i]=de;
                    charNum++;
                }


                if(charNum==maxLength){
                    String ans=new String();
                    for(String ss:demo3)
                        ans+=ss;
                    return ans;
                }

            }
        }
        return null;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String myString = scan.nextLine();
        String maxLength = scan.nextLine();
        while(myString!=null&&!myString.equals("")&&maxLength!=null&&!maxLength.equals("")){
            String[] strList = myString.split(" ");
            List<String> strstr = new ArrayList(Arrays.asList(strList));
            int maxLengthNum = Integer.parseInt(maxLength);
            List<String> demo2= new ArrayList<String>();
            demo2 = executeString(strstr,maxLengthNum);
            while(demo2!=null&&!demo2.equals("")&&demo2.size()!=0){
                demo2=executeString(demo2,maxLengthNum);
            }
            myString = scan.nextLine();
            if(myString == null|| myString.equals(""))
                break;
            maxLength = scan.nextLine();
        }
    }
}
