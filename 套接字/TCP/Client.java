package 套接字.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		//初始化客户端的套接字通过IP 以及开放的端口号来准确的找到服务器入口并与其进行通信
		Socket socket = new Socket("127.0.0.1",9999);
		
		//通过套接字来获取输出流
		OutputStream os = socket.getOutputStream();
		
		//把原始字节流输出转化为字符流输出
		PrintWriter pw = new PrintWriter(os);
		
		System.out.println("请输入信息");
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		//把用户输入信息给发送到缓冲中
		pw.println(message);
		//刷新缓冲把信息发送给服务器
		pw.flush();
		
	}
}
