package com.springcloud.common;

import java.util.Date;

/**
 * �ļ��ϴ��Ĺ�����
 * @author admin
 *
 */
public class UploadUtils {
	/**
	 * ������ļ����ƣ�������+4λ�������
	 * @return
	 * 		�����µ��ļ�����
	 */
	public static String getFileName() {
		String fileName = null;
		//���֮����������1-1000��
		int num = (int)(Math.random()*1000+1);
		//�����������Ϊ��λ
		String tempNum="000"+ num;
		tempNum = tempNum.substring(tempNum.length() - 4);
		
		Date date = new Date();
		fileName = date.getTime() + tempNum;
		return fileName;
	}
	/**
	 * �����ļ�����չ��
	 * @param fileName  �ļ���
	 * @return  �ɹ������ļ���չ�������򷵻�Null
	 */
	public static String getExtendedName(String fileName) {
		if(fileName == null || fileName.length() == 0) {
			return null;
		}
		int index = fileName.lastIndexOf(".");
		if(index == -1) {
			return null;
		}
		
		return fileName.substring(index);
	}
	//public static void main(String[] args) {
		//for(int i=0; i<=20; i++)
		//System.out.println(getExtendedName("abcd.efg.jpg"));
	//}

}