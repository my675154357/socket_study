package com.yema.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.junit.Test;

/**
* @Author��yema
* @Create��2018��3��31�� ����4:45:38
* @Edit��by Eclipse
* @Description��ʵ��UDP���ն�
* 		ʵ�ַ�װ���ݰ� java.net.DatagramPacket �����յ����ݷ�װ
* 		ʵ�����ݴ��� java.net.DatagramSocket ���շ����������ݰ�
* 
* 		���ն˻���io����Ч����Ҫ�����н��նˣ������з��Ͷˡ������͵����ݻᶪʧ�����ն�Ҳ�ղ���
*/
public class UDPReceive {

	/**
	 * ʵ�ֲ��裺
	 * 	1.����DatagramSocket���󣬰󶨶˿ںţ�Ҫ�ͷ��Ͷ˵Ķ˿ں�һ��
	 * 	2.�����ֽ����飬׼�����շ���������
	 * 	3.�������ݰ�����DatagramPacket
	 * 	4.����DatagramSocket����ķ���receive()���������ݲ��������ݰ���
	 *  5.�������ȡ�������ݣ�
	 *    �����˵�IP��DatagramPacket�ķ���getAddress() ��ȡ���Ͷ˵�IP������InetAddress����
	 *    ���յ��ֽ�����DatagramPacket�ķ���getLength() ��ȡ�����ֽ���
	 *    ���Ͷ˵Ķ˿ںţ�DatagramPacket�ķ���getPort() ��ȡ���Ͷ˵Ķ˿ں�
	 *  ��
	 *  6.�ر���Դ
	  
	 * @throws IOException
	 */
	@Test
	public void fun() throws IOException{
		//�������ݰ��������DatagramSocket���󶨶˿ں�
		DatagramSocket ds = new DatagramSocket(6000);//���ն˻���io����Ч��
		
		//�����ֽ�����
		byte [] data = new byte[1024];
		
		//�������ݰ����󣬴����ֽ�����
		DatagramPacket dp = new DatagramPacket(data,data.length);
		
		//����ds����ķ���receive()�������ݰ�
		ds.receive(dp);
		
		//��ȡ�ֽ���
		int length = dp.getLength();
		//��ȡ���Ͷ˵�IP
		String ip = dp.getAddress().getHostAddress();
		//��ȡ���Ͷ˵Ķ˿ں�
		int port = dp.getPort();
		
		System.out.println(ip+"ͨ��"+port+"�˿ڣ����͵���Ϣ�����ǣ���"+new String(data,0,length)+"��");
		
		ds.close();
		
	}
}
