package com.yema.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
* @Author��yema
* @Create��2018��3��31�� ����3:49:26
* @Edit��by Eclipse
* @Description��java.net.InetAddress ��ʾ�������е�IP��ַ�������û�й��췽����
*/
public class InetAddressDemo {

	@Test
	public void fun1() throws UnknownHostException{
		//��̬������String InetAddress.getLocalHost()  ��ȡ������������ip��ַ
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);
		
		//��ȡ��������ip
		String hostAddress = localHost.getHostAddress();
		System.out.println(hostAddress);
		
		//��ȡ����������
		String hostName = localHost.getHostName();
		System.out.println(hostName);
		
		//��ȡ������������ip��ַ������������
		InetAddress byName = InetAddress.getByName("www.baidu.com");//111.13.100.91
		System.out.println(byName);
		
	}
}
