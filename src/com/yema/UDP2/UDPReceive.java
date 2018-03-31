package com.yema.UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午4:45:38
* @Edit：by Eclipse
* @Description：实现UDP接收端
			循环接收
*/
public class UDPReceive {

	/**
	 * @throws IOException
	 */
	@Test
	public void fun() throws IOException{
		
		DatagramSocket ds = new DatagramSocket(6000);		
		byte [] data = new byte[1024];
		
		while(true){
			DatagramPacket dp = new DatagramPacket(data,data.length);		
			ds.receive(dp);
			
			int length = dp.getLength();
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			
			System.out.println(ip+"通过"+port+"端口，发送的消息内容是：“"+new String(data,0,length)+"”");
		}
		
		//ds.close();
	}
}
