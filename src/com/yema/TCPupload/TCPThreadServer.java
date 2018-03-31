package com.yema.TCPupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @Author：yema
* @Create：2018年3月31日 下午8:02:18
* @Edit：by Eclipse
* @Description：
*/
public class TCPThreadServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		while(true){
			//获取到一个客户端，必须开启新线程
			Socket socket = server.accept();
			new Thread(new ThreadUpload(socket)).start();
		}
	}
}
