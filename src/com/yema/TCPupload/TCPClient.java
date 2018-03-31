package com.yema.TCPupload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
* @Author：yema
* @Create：2018年3月31日 下午6:16:50
* @Edit：by Eclipse
* @Description：实现TCP的文件上传
* 	实现步骤：
* 		1.socket套接字连接服务器
* 		2.通过socket获取字节输出流，写图片
* 		3.使用自己的流对象，读取图片数据源FileInputSrteam
* 		4.读取图片。使用字节输出流，将图片写到服务器。 采用字节数组进行缓冲
* 		5.通过socket套接字获取直接输入流，读取服务器发回的成功消息
* 		6.关闭资源
*/
public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",8000);
		//获取直接输出流，将图片写到服务器
		OutputStream out = socket.getOutputStream();
		//创建字节输入流，读取本机上的数据源图片
		FileInputStream fis = new FileInputStream("F:\\data\\mn.jpg");
		//开始读写直接数组
		int len = 0;
		byte[] b = new byte[1024];
		//这边读一个b数组的字节，那边就会接收一个b数组的字节
		//这里读本地图片字节时可以读到末尾的，就能返回-1。
		while((len=fis.read(b)) != -1){
			out.write(b,0,len);
		}
		//这里写完数据后，应该给服务器写中止序列，告诉服务器，这边写完了，服务器别等了
		socket.shutdownOutput();
		
		//获取直接输入流，读取服务器上传成功的消息
		InputStream in = socket.getInputStream();
		
		//read()方法在没有内容读的时候就一直等待。客户端一直在的等待服务器返回成功消息，因此，这里出现了线程阻塞
		len = in.read(b);
		System.out.println(new String(b,0,len));
		
		fis.close();
		socket.close();
	}
}
