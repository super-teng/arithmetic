package 套接字.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class send {
	public static void main(String[] args) throws IOException{
		//通过数据套接字 绑定一个端口
		DatagramSocket ds = new DatagramSocket(8888);
		System.out.println("请输入要发送的信息");
		Scanner sc = new Scanner(System.in);
		String message = sc.next();
		//把用户输入信息变为字节来进行传输
		byte[] b = new byte[1024];
		b = message.getBytes();
		//把数据套接字的字符及长度封装成数据包来进行包装
		DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getByName("127.0.0.1"),9999);
		//把数据包发送出去
		ds.send(dp);
	}
}
