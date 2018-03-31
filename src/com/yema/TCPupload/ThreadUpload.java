package com.yema.TCPupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

/**
* @Author��yema
* @Create��2018��3��31�� ����7:57:46
* @Edit��by Eclipse
* @Description��
*/
public class ThreadUpload implements Runnable{
	
	private Socket socket;

	public ThreadUpload() {
		super();
	}

	public ThreadUpload(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
