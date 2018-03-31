package com.yema.UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午4:26:25
* @Edit：by Eclipse
* @Description：实现UDP协议的发送端。
* 		采用键盘循环输入
*/
public class UDPSend {

	/**	    
	 * @throws IOException 
	 */
	@Test
	public void fun() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		
		while(true){
			String message = sc.nextLine();
			byte[] data = message.getBytes();
			DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);				
			ds.send(dp);
		}
		
		//ds.close();
	}
}
