package com.yema.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
* @Author：yema
* @Create：2018年3月31日 下午5:35:53
* @Edit：by Eclipse
* @Description：实现TCP客户端，连接到服务器，和服务器实现数据交换
* 		实现TCP客户端的类：java.net.Socket 此类实现客户端套接字（也可以就叫“套接字”）。套接字是两台机器间通信的端点。
* 
* 		Socket(String host, int port)   创建一个流套接字并将其连接到指定主机上的指定端口号。
* 		注意：此构造方法只要运行，就会和服务器进行连接。连接失败就抛出异常
* 
* 		getOutputStream() 返回此套接字的输出流。 作用：将数据输出到服务器
* 		getInputStream() 返回此套接字的输入流。  作用：从服务端写数据
          
        一旦TCP建立好了连接。客户端和服务器数据交换，必须使用套接字对象Socket中获取的IO流。
*/
public class TCPClient {

	@Test
	public void fun() throws IOException{
		
		//创建Socket对象，连接服务器
		Socket socket = new Socket("127.0.0.1",8888);
		
		//通过客户端的套接字对象Socket的方法，获取字节输出流，将数据写入服务器
		OutputStream os = socket.getOutputStream();
		os.write("服务器OK".getBytes());
		
		//读取服务器发回的数据，使用socket套接字对象中的字节输入流
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = is.read(data);
		System.out.println(new String(data,0,len));
		
		socket.close();
	}
}
