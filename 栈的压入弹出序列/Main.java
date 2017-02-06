package 栈的压入弹出序列;

import java.util.Scanner;



public class Main{
	private static int dx[]={1,0,-1,0};  
	private static int dy[]={0,1,0,-1}; 
	private static int map[][] = {  
	    {0,1,0,0}, 
	    {0,0,0,1},  
	    {1,0,1,0},  
	    {0,0,0,0},   
	};
	private static int x,y,ex,ey,min,c; 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
	    int n = sc.nextInt();  
	    while(n-- > 0)  
	    {  
	        x = sc.nextInt();
	        y = sc.nextInt();
	        ex = sc.nextInt();
	        ey = sc.nextInt();
	        map[x][y]=1;  
	        c=0;
	        min=Integer.MAX_VALUE;  
	        m.dfs(x,y,c);  
	        map[x][y]=0;  
	        System.out.println(min);
	    }  
	    sc.close();
	}
	void dfs(int x,int y,int c)  
	{  
	    int i;  
	    if(x==ex&&y==ey)  
	    {  
	        if(c<min)  
	            min=c;  
	        return ;  
	    }  
	    for(i=0;i<4;i++)  
	    {  
	        int nx=x+dx[i];  
	        int ny=y+dy[i];  
	        if(map[nx][ny]==0&&c+1<min)  
	        {  
	            map[nx][ny]=1;  
	            dfs(nx,ny,c+1);  
	            map[nx][ny]=0;  
	        }  
	    }  
	}
}
 

