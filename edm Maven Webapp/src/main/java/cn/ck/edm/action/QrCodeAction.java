package cn.ck.edm.action;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ck.edm.util.MatrixToImageWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class QrCodeAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QrCodeAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
			getQrCode(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void getQrCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//设置页面不缓存  
		response.setHeader("Cache-Control", "no-cache");
		
		String phone = request.getParameter("phone");
		//String text = "你好 http://192.168.199.126:8080/CSP/core/main/index";
		int width = 120;
		int height = 120;
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode("TEL:"+ phone, BarcodeFormat.QR_CODE, width, height, hints);
		System.out.println("生成二维码");
		 //设置输出的内容的类型为png图像
		response.setContentType(format);
		//写给浏览器 
		MatrixToImageWriter.writeToStream(bitMatrix, format, response.getOutputStream());
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
