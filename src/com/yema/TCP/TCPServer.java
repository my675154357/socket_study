package com.yema.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
* @Author��yema
* @Create��2018��3��31�� ����5:47:45
* @Edit��by Eclipse
* @Description��ʵ��TCP�������
* 		java.net.ServerSocket  ����ʵ�ַ������׽���
* 		���췽����ServerSocket(int port)   �����󶨵��ض��˿ڵķ������׽��֡�
         
		����Ҫ�������ÿͻ��˵��׽���Socket����        ����accept()  ���������ܵ��ͻ����׽��ֵ����ӡ�
          
*/
public class TCPServer {

	@Test
	public void fun() throws IOException{
		ServerSocket server = new ServerSocket(8888);//�������io����Ч��
		//���÷������׽��ֶ����е�accept()��������ȡ�ͻ��˵��׽��ֶ���
		Socket socket = server.accept();
		
		//ͨ���ͻ����׽��ֶ���socket����ȡֱ������������ȡ�ͻ��˷�����������
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = is.read(data);
		System.out.println(new String(data,0,len));
		
		//�������ͻ��˻����ݣ��ֽ��������ͨ���ͻ����׽��ֶ����ȡֱ�������
		OutputStream os = socket.getOutputStream();
		os.write("�յ���лл".getBytes());
		
		socket.close();
		server.close();
	}
}
