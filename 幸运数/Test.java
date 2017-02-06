package ĞÒÔËÊı;


	import java.util.HashMap;
	import java.util.Map; 
	import java.util.Scanner; 
	public class Test 
	{ 
		public static Map<Integer, Integer> map=new HashMap<Integer, Integer>(); 
		public static void main(String []args){ 
			Scanner scanner=new Scanner(System.in);
			int num=scanner.nextInt(); 
			for(int i=0;i<num;i++){ 
				int n=scanner.nextInt();
				int temp=find(map,n); 
				int result=1; 
				if (temp!=1) 
				{ 
					result=map.get(temp); 
					}
				for(int i1=temp+1;i1<=n;i1++){ 
					if (f(i1)==g(i1)) 
					{ result++;
					}
				} 
				map.put(n, result); System.out.println(result); 
				}
			} 
		private static int find(Map<Integer, Integer> map2,int n) 
		{ for(int i=n;i>=1;i--){ 
			if (map.get(Integer.valueOf(i))!=null) { 
				return i; } } return 1; } 
		public static int f(int x){ 
					int m=0; while(x>0){ m=m+x%10; x=x/10; } return m; } public static int g(int x){ 
					int m=0; while(x>0){ m=m+x%2; x=x/2; }
				return m; }
				}

