package 套接字.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class receive {
	public static void main(String[] args) throws IOException{
		//数据包开放端口
		DatagramSocket socket = new DatagramSocket(9999);
		byte[] b = new byte[1024];
		//确定数据包接受的长度
		DatagramPacket dp = new DatagramPacket(b,b.length);
		//把信息放入到数据包中存入到字节数组B中
		socket.receive(dp);
		//把字节信息转成字符串的形式
		String message = new String(b,0,dp.getLength());
		System.out.println("发送发说:"+message);
	}
}
