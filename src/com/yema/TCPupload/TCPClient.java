package com.yema.TCPupload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
* @Author��yema
* @Create��2018��3��31�� ����6:16:50
* @Edit��by Eclipse
* @Description��ʵ��TCP���ļ��ϴ�
* 	ʵ�ֲ��裺
* 		1.socket�׽������ӷ�����
* 		2.ͨ��socket��ȡ�ֽ��������дͼƬ
* 		3.ʹ���Լ��������󣬶�ȡͼƬ����ԴFileInputSrteam
* 		4.��ȡͼƬ��ʹ���ֽ����������ͼƬд���������� �����ֽ�������л���
* 		5.ͨ��socket�׽��ֻ�ȡֱ������������ȡ���������صĳɹ���Ϣ
* 		6.�ر���Դ
*/
public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",8000);
		//��ȡֱ�����������ͼƬд��������
		OutputStream out = socket.getOutputStream();
		//�����ֽ�����������ȡ�����ϵ�����ԴͼƬ
		FileInputStream fis = new FileInputStream("F:\\data\\mn.jpg");
		//��ʼ��дֱ������
		int len = 0;
		byte[] b = new byte[1024];
		//��߶�һ��b������ֽڣ��Ǳ߾ͻ����һ��b������ֽ�
		//���������ͼƬ�ֽ�ʱ���Զ���ĩβ�ģ����ܷ���-1��
		while((len=fis.read(b)) != -1){
			out.write(b,0,len);
		}
		//����д�����ݺ�Ӧ�ø�������д��ֹ���У����߷����������д���ˣ������������
		socket.shutdownOutput();
		
		//��ȡֱ������������ȡ�������ϴ��ɹ�����Ϣ
		InputStream in = socket.getInputStream();
		
		//read()������û�����ݶ���ʱ���һֱ�ȴ����ͻ���һֱ�ڵĵȴ����������سɹ���Ϣ����ˣ�����������߳�����
		len = in.read(b);
		System.out.println(new String(b,0,len));
		
		fis.close();
		socket.close();
	}
}
