package com.yema.TCPupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @Author��yema
* @Create��2018��3��31�� ����8:02:18
* @Edit��by Eclipse
* @Description��
*/
public class TCPThreadServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		while(true){
			//��ȡ��һ���ͻ��ˣ����뿪�����߳�
			Socket socket = server.accept();
			new Thread(new ThreadUpload(socket)).start();
		}
	}
}
