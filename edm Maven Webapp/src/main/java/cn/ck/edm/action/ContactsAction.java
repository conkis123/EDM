package cn.ck.edm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ck.edm.bean.BsGrid;
import cn.ck.edm.bean.Contacts;
import cn.ck.edm.util.FileUtil;

public class ContactsAction extends HttpServlet {

    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;

	/**
	 * Constructor of the object.
	 */
	public ContactsAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
		try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

		List<Contacts> list = (List<Contacts>)FileUtil.readObjectFromFile("data/contacts.bin");

		PrintWriter writer = response.getWriter();
		
		BsGrid bs = new BsGrid();
		bs.setCurPage(Integer.parseInt(curPage));
		
		if(list == null || list.size() == 0){
			bs.setTotalRows(0);
			bs.setData(null);
		}else{
			bs.setTotalRows(list.size());
			bs.setData(list);
		}
		bs.setSuccess(true);
		
		writer.print(objectMapper.writeValueAsString(bs));
		writer.flush();
		writer.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
