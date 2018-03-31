package com.yema.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午4:26:25
* @Edit：by Eclipse
* @Description：实现UDP协议的发送端。
* 		java.net.DatagramPacket 实现数据封装的类，类似于“集装箱”的概念
		java.net.DatagramSocket 实现数据传输的类，类似于“码头”的概念
		
	套接字：绑定了网络IP和端口号的对象叫，套接字
*/
public class UDPSend {

	/**
	 * 实现步骤：
	 * 	1.创建DatagramPacket对象，封装数据，接收端的地址和端口（类似收货地址的概念）
	 *  2.创建DatagramSocket对象
	 *  3.调用DatagramSocket的方法send，发送数据包
	 *  4.关闭资源（这个传输也是调用系统资源的，所以传递完后需要关闭系统资源）
	 *  
	 *  构造方法：DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
			    DatagramSocket() 
			    
	 * @throws IOException 
	 */
	@Test
	public void fun() throws IOException{
		
		//创建发送的数据
		byte[] data = "你好UDP".getBytes();	
		
		//创建一个InetAddress对象，封装自己的IP
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		
		//创建数据包对象，封装要发送的数据，接收端IP，端口 （把data数据，的全部直接，发送到inet，端口为6000）
		DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);				
		
		//创建用来发送和接收数据报包的套接字。它既可以发送也可以接收，因为它是“码头”的概念。这里用来发送
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		
		ds.close();
	}
}
