package com.yema.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
* @Author��yema
* @Create��2018��3��31�� ����5:35:53
* @Edit��by Eclipse
* @Description��ʵ��TCP�ͻ��ˣ����ӵ����������ͷ�����ʵ�����ݽ���
* 		ʵ��TCP�ͻ��˵��ࣺjava.net.Socket ����ʵ�ֿͻ����׽��֣�Ҳ���ԾͽС��׽��֡������׽�������̨������ͨ�ŵĶ˵㡣
* 
* 		Socket(String host, int port)   ����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ںš�
* 		ע�⣺�˹��췽��ֻҪ���У��ͻ�ͷ������������ӡ�����ʧ�ܾ��׳��쳣
* 
* 		getOutputStream() ���ش��׽��ֵ�������� ���ã������������������
* 		getInputStream() ���ش��׽��ֵ���������  ���ã��ӷ����д����
          
        һ��TCP�����������ӡ��ͻ��˺ͷ��������ݽ���������ʹ���׽��ֶ���Socket�л�ȡ��IO����
*/
public class TCPClient {

	@Test
	public void fun() throws IOException{
		
		//����Socket�������ӷ�����
		Socket socket = new Socket("127.0.0.1",8888);
		
		//ͨ���ͻ��˵��׽��ֶ���Socket�ķ�������ȡ�ֽ��������������д�������
		OutputStream os = socket.getOutputStream();
		os.write("������OK".getBytes());
		
		//��ȡ���������ص����ݣ�ʹ��socket�׽��ֶ����е��ֽ�������
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = is.read(data);
		System.out.println(new String(data,0,len));
		
		socket.close();
	}
}
