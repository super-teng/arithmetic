package 字符串严蔚敏;

public class Main {
	//字符串类
	public class HString{
		public char[] str;
		public int length;
	}
	//串的赋值
	public void assign(HString s,HString t){
		if(s == null || t == null){
			return ;
		}
		s.length = t.length;
		s.str = new char[s.length];
		//如果t为空的话让S也为空
		if(t.str == null){
			s.str = null;
		//如果t为空串的话让S也为空串
		}else if(t.str.length == 0){
			s.str = new char[0];
		//如果不为空串的话
		}else{
			for(int i = 0;i<t.length;i++){
				s.str[i] = t.str[i];
			}
		}
	}
	//串连接
	public void concat(HString s,HString t){
		//将t字符串连接到s字符串后面
		HString temp = new HString();
		//将s自字符串先用temp来hold住
		assign(temp,s);
		//改变s的str数组值以及length长度
		s.length = s.length+t.length;
		s.str = new char[s.length];
		//把temp中的值以及t中的值都copy过来
		//先赋temp的值
		for(int i =0;i<temp.length;i++){
			s.str[i] = temp.str[i];
		}
		//再赋t的值
		int index = temp.length;
		for(int i=0;i<t.length;i++){
			s.str[index++] = t.str[i];
		}
	}
	//子串定位（模式匹配） 
	//判断t是在s中的那个位置，返回位置索引，如果不是当前的子串的话就返回0
	public int index(HString s,HString t){
		//第一个字符串的指针
		int first = 0;
		//第二个字符串的指针
		int second = 0;
		//进行查找
		while(first < s.length && second < t.length){
			//如相等指针++
			if(s.str[first] == t.str[second]){
				first ++ ;
				second ++;
				//不等second归0first退至上次开始+1位置
			}else{
				first = first - second + 1;
				second = 0;
			}
		}
		//判断最终second是否等于t长度
		if(second == t.length){
			return first - second;
		}else {
			return 0;
		}
	}
	//KMP
	public int KMP(HString s,HString t){
		//获得前缀数组
		int[] next = getNext02(t);
		//操作S数组
		int i = 0;
		//操作T数组指针，从1到t.length，为0时并不表示索引位置，而是表示为当前S位置字符不管T如何滑动均不能相等
		//也就是当前的next[1]的时候，这个时候已经表示了当前没有了前缀
		int j = 1;
		while(i<s.length && j<=t.length){
			//当前两位置元素相等的时候进行++操作,j==0是因为当T数组如何滑动也不能与S数组当前i位置对应时，应让
			//i数组指针索引++，然后在进行比较，这个0是特殊标示
			if(j == 0 || s.str[i] == t.str[j-1]){
				i++;
				j++;
				//如果不等进行滑动操作，滑动距离为next数组的值
			}else{
				j = next[j];
			}
		}
		if(j>t.length){
			return i-t.length;
		}else{
			return 0;
		}
	}
	//前缀函数next
	public int[] getNext(HString t){
		//创建长度为字符串长度的前缀数组
		int[] next = new int[t.length+1];
		//数组的指针
		int i = 1;
		//前缀索引，当J为0的时候没有必要进行判断，说明当前位置的前缀和后缀相等的肯定没有
		int j = 0;
		//索引为1位置为0，这里之所以不从0进行判断是因为考虑到KMP算法中的需要和下一位比较的需求
		next[1] = 0;
		while(i<t.length){
			//如果前缀中均不包含符合关系的集合，或当前新加入索引位置节点相同的话 ++操作
			if( j == 0 || t.str[i-1] == t.str[j-1]){
				i++;
				j++;
				next[i] = j;
				//回溯
			}else{
				j = next[j];
			}
		}
		return next;
	}
	//改进的前缀next函数
	//当存在特殊情况时候进行改进
	public int[] getNext02(HString t){
		//创建长度为字符串长度的前缀数组
		int[] next = new int[t.length+1];
		//数组的指针
		int i = 1;
		//前缀索引，当J为0的时候没有必要进行判断，说明当前位置的前缀和后缀相等的肯定没有
		int j = 0;
		//索引为1位置为0，这里之所以不从0进行判断是因为考虑到KMP算法中的需要和下一位比较的需求
		next[1] = 0;
		while(i<t.length){
			//如果前缀中均不包含符合关系的集合，或当前新加入索引位置节点相同的话 ++操作
			if( j == 0 || t.str[i-1] == t.str[j-1]){
				i++;
				j++;
				if(t.str[i-1]!=t.str[j-1]){
					next[i] = j;
				}else{
					next[i] = next[j];
				}
				
				//回溯
			}else{
				j = next[j];
			}
		}
		return next;
	}
	public static void main(String[] args){
		Main m = new Main();
		HString t = m.new HString();
		//因为没有在初始化阶段赋值就需要这样操作
		t.str = new char[]{'1','2','3','4','5'};
		t.length = t.str.length;
		HString s = m.new HString();
		m.assign(s, t);
		System.out.println("赋值：");
		System.out.println(s.length);
		for(int i = 0;i<s.length;i++){
			System.out.print(s.str[i]+" ");
		}
		//串连接
		m.concat(s, t);
		System.out.println();
		System.out.println("连接：");
		System.out.println(s.length);
		for(int i = 0;i<s.length;i++){
			System.out.print(s.str[i]+" ");
		}
		System.out.println();
		HString temp = m.new HString();
		temp.length = 3;
		temp.str = new char[]{'3','4','5'};
		System.out.println(m.index(t, temp));
		System.out.println("KMP");
		HString s1 = m.new HString();
		HString s2 = m.new HString();
		s1.str = new char[]{'a','b','c','a','b','c','a','b','c','d','a','b','c','a','b',};
		s1.length = s1.str.length;
		s2.str = new char[]{'a','b','c','d'};
		s2.length = s2.str.length;
		System.out.println("数组1");
		for(int i =0 ;i<s1.str.length;i++){
			System.out.print(s1.str[i]+" ");
		}
		System.out.println();
		System.out.println("数组2");
		for(int i=0;i<s2.str.length;i++){
			System.out.print(s2.str[i]+" ");
		}
		System.out.println();
		System.out.println("索引位置"+m.KMP(s1, s2));
	}
}
