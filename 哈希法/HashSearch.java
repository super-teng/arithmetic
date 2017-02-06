package 哈希法;

/*
 * --------------Super 腾------------------
 */
public class HashSearch {
	
	private static Object[] hash = new Object[100];//哈希表初始值为10个单位
	
	public static void main(String[] args){
		//插入数据存入哈希表中
		String a = "abc";
		String b = "def";
		String c = "ghi";
		String d = "jkl";
		String e = "mno";
		String f = "pqr";
		String g = "stu";
		String h = "vwx";
		String i = "yz";
		InsertHash(a);
		InsertHash(b);
		InsertHash(c);
		InsertHash(d);
		InsertHash(e);
		InsertHash(f);
		InsertHash(g);
		InsertHash(h);
		InsertHash(i);
		//定位式查找某一特定元素
		int result = hashSearch("mno");
		System.out.println("您输入的字符串为:mno");
		System.out.println("当前在哈希表中的索引为:"+result);
		System.out.println("哈希表中索引为"+"'"+result+"'"+"处的字符串为"+hash[result]);
	}
	
	//建立hash表
	public static void InsertHash(String data){
		int index = hashFunction(data);
		//把取中当做哈希表中索引
		if(hash[index] == null){
			hash[index] = data;
		}else{
			solveClash(index,data);
		}
	}
	//平方取中法
	public static int hashFunction(String data){
		//把字符串转化为字符用来求和之后进行平方运算
		char[] d = data.toCharArray();
		int temp = 0;
		for(int i=0;i<d.length;i++){
			temp += (int)d[i];
		}
		temp = temp*temp;
		//对平方的数值进行取中
		int index = 0;
		String s = String.valueOf(temp);
		//取的整数的中间两位 借助了字符串下面的方法
		index += Integer.parseInt(String.valueOf(s.charAt(s.length()/2-1)))*10;
		index += Integer.parseInt(String.valueOf(s.charAt(s.length()/2)));
		return index;
	}
	//解决插入冲突的方法
	public static void solveClash(int index,String data){
		//进行线性开放地址法解决冲突
		for(int i=1;index+i<100;i++){
			if(hash[index+i] == null){
				hash[index+i] = data;
				break;
			}
		}
	}
	//通过hash算法定位式查找元素
	public static int hashSearch(String data){
		int index = hashFunction(data);
		return index;
	}
}
