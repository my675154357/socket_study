package com.yema.TCPupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
* @Author��yema
* @Create��2018��3��31�� ����6:27:09
* @Edit��by Eclipse
* @Description��TCP�ļ��ϴ�������
* 	ʵ�ֲ��裺
* 		1.ServerSocket�׽��ֶ��󣬼���8000
* 		2.����accept()��ȡ�ͻ������Ӷ���
* 		3.�ͻ������Ӷ����ȡ�ֽ�����������ȡ�ͻ��˷�����ͼƬ
* 		4.����File���󣬰��ϴ����ļ��У��ж��ļ����Ƿ���ڣ��������򴴽���
* 		5.�����ֽ������������Ŀ��File�������ڵ��ļ���
* 		6.�ֽ�����ȡͼƬ���ֽ�����ͼƬд�뵽Ŀ���ļ�����
* 		7.���� �ϴ��ɹ�
* 		8.�ر���Դ
*/
public class TCPServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		Socket socket = server.accept();
		//ͨ���ͻ������Ӷ��󣬻�ȡֱ������������ȡ�ͻ���ͼƬ
		InputStream in = socket.getInputStream();
		File file = new File("F:\\data\\upload");
		if(!file.exists()){
			file.mkdirs();
		}
		
		//��ֹ�ļ�ͬ�������ǣ����¶����ļ����֡�  ��������+����ֵ+6λ�����
		String fileName = "yema"+ System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
		
		//�����ֽ����������ͼƬд��Ŀ���ļ�����
		FileOutputStream fos = new FileOutputStream(file+File.separator+fileName);
		//��дֱ������
		byte[] b = new byte[1024];
		int len = 0;
		//�Ǳ�дһ��b������ֽڣ�����ͻ��һ��b������ֽ�
		//��������������׽����з��͵��ֽڣ���������ֽ�������û��ĩβ������־�ģ���˾ͻᷢ����������β��Ҳ�Ͳ��᷵��-1������Ͳ���������
		while((len=in.read(b)) != -1){
			fos.write(b,0,len);
		}
		//ͨ���ͻ������Ӷ����ȡֱ���������д���ϴ��ɹ�
		socket.getOutputStream().write("�ϴ��ɹ�".getBytes());
		fos.close();
		socket.close();
		server.close();
	}
}
