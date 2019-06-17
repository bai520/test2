package com.springcloud.common;

import java.util.Date;

/**
 * 文件上传的工具类
 * @author admin
 *
 */
public class UploadUtils {
	/**
	 * 获得新文件名称（毫秒数+4位随机数）
	 * @return
	 * 		返回新的文件名称
	 */
	public static String getFileName() {
		String fileName = null;
		//获得之间的随机数（1-1000）
		int num = (int)(Math.random()*1000+1);
		//将随机数设置为四位
		String tempNum="000"+ num;
		tempNum = tempNum.substring(tempNum.length() - 4);
		
		Date date = new Date();
		fileName = date.getTime() + tempNum;
		return fileName;
	}
	/**
	 * 返回文件的扩展名
	 * @param fileName  文件名
	 * @return  成功返回文件扩展名，否则返回Null
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
