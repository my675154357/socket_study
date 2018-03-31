package com.yema.TCPupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
* @Author：yema
* @Create：2018年3月31日 下午6:27:09
* @Edit：by Eclipse
* @Description：TCP文件上传服务器
* 	实现步骤：
* 		1.ServerSocket套接字对象，监听8000
* 		2.方法accept()获取客户端连接对象
* 		3.客户端连接对象获取字节输入流，读取客户端发来的图片
* 		4.创建File对象，绑定上传的文件夹（判断文件夹是否存在，不存在则创建）
* 		5.创建字节输出流，数据目的File对象所在的文件夹
* 		6.字节流读取图片，字节流将图片写入到目的文件夹中
* 		7.返回 上传成功
* 		8.关闭资源
*/
public class TCPServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		Socket socket = server.accept();
		//通过客户端连接对象，获取直接输入流，读取客户端图片
		InputStream in = socket.getInputStream();
		File file = new File("F:\\data\\upload");
		if(!file.exists()){
			file.mkdirs();
		}
		
		//防止文件同名被覆盖，重新定义文件名字。  规则：域名+毫秒值+6位随机数
		String fileName = "yema"+ System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
		
		//创建字节输出流，将图片写到目的文件夹中
		FileOutputStream fos = new FileOutputStream(file+File.separator+fileName);
		//读写直接数组
		byte[] b = new byte[1024];
		int len = 0;
		//那边写一个b数组的字节，这里就会读一个b数组的字节
		//但是这里读的是套接字中发送的字节，这里面的字节内容是没有末尾结束标志的，因此就会发生读不到结尾，也就不会返回-1。这里就产生了阻塞
		while((len=in.read(b)) != -1){
			fos.write(b,0,len);
		}
		//通过客户端连接对象获取直接输出流。写回上传成功
		socket.getOutputStream().write("上传成功".getBytes());
		fos.close();
		socket.close();
		server.close();
	}
}
