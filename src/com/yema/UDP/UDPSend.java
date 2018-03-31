package com.yema.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

/**
* @Author��yema
* @Create��2018��3��31�� ����4:26:25
* @Edit��by Eclipse
* @Description��ʵ��UDPЭ��ķ��Ͷˡ�
* 		java.net.DatagramPacket ʵ�����ݷ�װ���࣬�����ڡ���װ�䡱�ĸ���
		java.net.DatagramSocket ʵ�����ݴ�����࣬�����ڡ���ͷ���ĸ���
		
	�׽��֣���������IP�Ͷ˿ںŵĶ���У��׽���
*/
public class UDPSend {

	/**
	 * ʵ�ֲ��裺
	 * 	1.����DatagramPacket���󣬷�װ���ݣ����ն˵ĵ�ַ�Ͷ˿ڣ������ջ���ַ�ĸ��
	 *  2.����DatagramSocket����
	 *  3.����DatagramSocket�ķ���send���������ݰ�
	 *  4.�ر���Դ���������Ҳ�ǵ���ϵͳ��Դ�ģ����Դ��������Ҫ�ر�ϵͳ��Դ��
	 *  
	 *  ���췽����DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
			    DatagramSocket() 
			    
	 * @throws IOException 
	 */
	@Test
	public void fun() throws IOException{
		
		//�������͵�����
		byte[] data = "���UDP".getBytes();	
		
		//����һ��InetAddress���󣬷�װ�Լ���IP
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		
		//�������ݰ����󣬷�װҪ���͵����ݣ����ն�IP���˿� ����data���ݣ���ȫ��ֱ�ӣ����͵�inet���˿�Ϊ6000��
		DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);				
		
		//�����������ͺͽ������ݱ������׽��֡����ȿ��Է���Ҳ���Խ��գ���Ϊ���ǡ���ͷ���ĸ��������������
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		
		ds.close();
	}
}
