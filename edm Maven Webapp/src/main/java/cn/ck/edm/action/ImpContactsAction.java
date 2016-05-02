package cn.ck.edm.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import cn.ck.edm.bean.BsGrid;
import cn.ck.edm.bean.Contacts;
import cn.ck.edm.util.ExcelUtil;
import cn.ck.edm.util.FileUtil;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ImpContactsAction extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public ImpContactsAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //设置编码格式 
		response.setContentType("text/html");   //设置数据格式
		
		String pageSize = request.getParameter("pageSize");
		String curPage = request.getParameter("curPage");
		String sortName = request.getParameter("sortName");
		String sortOrder = request.getParameter("sortOrder");
		
		//文件
		File file = new File("D:\\SWSK\\4月更新员工通讯录201600422c.xls");
		 //读取excel模板
        POIFSFileSystem fs = new POIFSFileSystem(file);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        //读取第一个sheet内容
        HSSFSheet sheet = wb.getSheetAt(0);
        
        List<Contacts> list = new ArrayList<Contacts>();
        String tempDep = "";
        String tempDepChild = "";

		for(int i = 3, j = sheet.getLastRowNum(); i < j; i++){
			HSSFRow row = sheet.getRow(i);
			Contacts bean = new Contacts();
			int cellNum = -1;
			
			bean.setNo(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			
			String dep = ExcelUtil.getCellValue(row.getCell(++cellNum));
			if(dep == null || "".equals(dep)){
				bean.setDep(tempDep);
			}else{
				bean.setDep(dep);
				tempDep = dep;
			}
			
//			String depChild = ExcelUtil.getCellValue(row.getCell(++cellNum));
//			if(depChild == null || "".equals(depChild)){
//				bean.setDepChild(tempDep);
//			}else{
//				bean.setDepChild(depChild);
//				tempDepChild = depChild;
//			}
			
			bean.setPost(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			bean.setName(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			String sex = ExcelUtil.getCellValue(row.getCell(++cellNum));
			if("男".equals(sex)){
				bean.setSex(1);
			}else if("女".equals(sex)){
				bean.setSex(2);
			}
			bean.setWorkPhone(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			bean.setExt(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			bean.setPhone(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			bean.seteEmail(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			bean.setBackupEmail(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			bean.setQq(ExcelUtil.getCellValue(row.getCell(++cellNum)));
			
			list.add(bean);
		}
		//数据持久化
		FileUtil.writeObjectToFile("data/contacts.bin", list);
		
		PrintWriter writer = response.getWriter();
		
		writer.print("[{'success':true,'mess':'导入成功！'}]");
		writer.flush();
		writer.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
	}

}
