package 最长公共字串;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static List<String> search(String src,String target){
		String min = src.length()>target.length()?target:src;
		String max = src.length()<target.length()?target:src;
		List<String> list = new ArrayList<String>();
		int length = 0;
		for(int i=0;i<min.length();i++){
			for(int j =i+1;j<=min.length();j++){
				String temp = min.substring(i,j);
				if(!max.contains(temp)){
					break;
				}else{
					if(temp.length() > length){
						list.clear();
						list.add(temp);
						length = temp.length();
					}else if(temp.length() == length){
						list.add(temp);
					}
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		List<String> result = Main.search("bacdafreddsageaecvz", "dafeddds");
		for(String s:result){
			System.out.println(s);
		}
	}
}
