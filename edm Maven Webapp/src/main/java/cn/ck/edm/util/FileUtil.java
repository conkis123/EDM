package cn.ck.edm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;

public class FileUtil {
	/**
	 * 写入对象到文件
	 * @param obj
	 */
	public static void writeObjectToFile(String filePath, Object obj) {
		File file = new File(filePath);
		FileOutputStream out;
		try {
			out = new FileOutputStream(getResourcePath() +"/"+ file);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(obj);
			objOut.flush();
			objOut.close();
			System.out.println("write object success!");
		} catch (IOException e) {
			System.out.println("write object failed");
			e.printStackTrace();
		}
	}

	/**
	 * 从文件中读取对象
	 * @return
	 */
	public static Object readObjectFromFile(String filePath) {
		Object temp = null;
		File file = new File(getResourcePath() +"/"+ filePath);
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			temp = objIn.readObject();
			objIn.close();
			System.out.println("read object success!");
		} catch (IOException e) {
			System.out.println("read object failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return temp;
	}
	

    /**
     * 获取资源文件根目录
     * @return
     */
    public static String getResourcePath(){
    	try {
			return Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
    }
}
