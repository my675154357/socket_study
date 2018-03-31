package com.yema.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午5:47:45
* @Edit：by Eclipse
* @Description：实现TCP服务程序
* 		java.net.ServerSocket  此类实现服务器套接字
* 		构造方法：ServerSocket(int port)   创建绑定到特定端口的服务器套接字。
         
		很重要：必须获得客户端的套接字Socket对象。        方法accept()  侦听并接受到客户端套接字的连接。
          
*/
public class TCPServer {

	@Test
	public void fun() throws IOException{
		ServerSocket server = new ServerSocket(8888);//服务端有io阻塞效果
		//调用服务器套接字对象中的accept()方法，获取客户端的套接字对象
		Socket socket = server.accept();
		
		//通过客户端套接字对象socket，获取直接输入流。读取客户端发送来的数据
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = is.read(data);
		System.out.println(new String(data,0,len));
		
		//服务端向客户端回数据，字节输出流，通过客户端套接字对象获取直接输出流
		OutputStream os = socket.getOutputStream();
		os.write("收到，谢谢".getBytes());
		
		socket.close();
		server.close();
	}
}
