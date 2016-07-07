package 套接字.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		//服务器端开启一个端口 这底层其实是一个bind绑定套接字到端口上的一个过程
		ServerSocket ss = new ServerSocket(9999);
		
		//等待客户端来进行连接 连接会产生一个相应的套接字 通过套接字来进行读写操作
		Socket socket = ss.accept();
		//进行读操作
		InputStream is = socket.getInputStream();
		//转化为字符读取
		InputStreamReader ir = new InputStreamReader(is);
		//转化为增强的bufferReader来进行逐行读取
		BufferedReader br = new BufferedReader(ir);
		String message = br.readLine();
		System.out.println("客户端说:"+message);
	}
}
