package com.yema.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午3:49:26
* @Edit：by Eclipse
* @Description：java.net.InetAddress 表示互联网中的IP地址，这个类没有构造方法。
*/
public class InetAddressDemo {

	@Test
	public void fun1() throws UnknownHostException{
		//静态方法：String InetAddress.getLocalHost()  获取本地主机名和ip地址
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);
		
		//获取本地主机ip
		String hostAddress = localHost.getHostAddress();
		System.out.println(hostAddress);
		
		//获取本地主机名
		String hostName = localHost.getHostName();
		System.out.println(hostName);
		
		//获取其他主机名和ip地址。传递主机名
		InetAddress byName = InetAddress.getByName("www.baidu.com");//111.13.100.91
		System.out.println(byName);
		
	}
}
