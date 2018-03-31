package com.yema.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午4:45:38
* @Edit：by Eclipse
* @Description：实现UDP接收端
* 		实现封装数据包 java.net.DatagramPacket 将接收的数据封装
* 		实现数据传输 java.net.DatagramSocket 接收发送来的数据包
* 
* 		接收端会有io阻塞效果，要先运行接收端，再运行发送端。否则发送的数据会丢失，接收端也收不到
*/
public class UDPReceive {

	/**
	 * 实现步骤：
	 * 	1.创建DatagramSocket对象，绑定端口号，要和发送端的端口号一致
	 * 	2.创建字节数组，准备接收发来的数据
	 * 	3.创建数据包对象DatagramPacket
	 * 	4.调用DatagramSocket对象的方法receive()，接收数据并放在数据包中
	 *  5.拆包，获取数据内容（
	 *    发送人的IP：DatagramPacket的方法getAddress() 获取发送端的IP，返回InetAddress对象
	 *    接收的字节数：DatagramPacket的方法getLength() 获取数据字节数
	 *    发送端的端口号：DatagramPacket的方法getPort() 获取发送端的端口号
	 *  ）
	 *  6.关闭资源
	  
	 * @throws IOException
	 */
	@Test
	public void fun() throws IOException{
		//创建数据包传输对象DatagramSocket，绑定端口号
		DatagramSocket ds = new DatagramSocket(6000);//接收端会有io阻塞效果
		
		//创建字节数组
		byte [] data = new byte[1024];
		
		//创建数据包对象，传递字节数组
		DatagramPacket dp = new DatagramPacket(data,data.length);
		
		//调用ds对象的方法receive()传递数据包
		ds.receive(dp);
		
		//获取字节数
		int length = dp.getLength();
		//获取发送端的IP
		String ip = dp.getAddress().getHostAddress();
		//获取发送端的端口号
		int port = dp.getPort();
		
		System.out.println(ip+"通过"+port+"端口，发送的消息内容是：“"+new String(data,0,length)+"”");
		
		ds.close();
		
	}
}
