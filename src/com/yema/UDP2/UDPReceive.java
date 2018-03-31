package com.yema.UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.junit.Test;

/**
* @Author��yema
* @Create��2018��3��31�� ����4:45:38
* @Edit��by Eclipse
* @Description��ʵ��UDP���ն�
			ѭ������
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
			
			System.out.println(ip+"ͨ��"+port+"�˿ڣ����͵���Ϣ�����ǣ���"+new String(data,0,length)+"��");
		}
		
		//ds.close();
	}
}
