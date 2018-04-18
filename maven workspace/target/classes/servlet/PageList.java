package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Page;
import entity.Student;

public class PageList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> list = (List<Student>) request.getAttribute("list");
		Page page = (Page) request.getAttribute("page");
		//设置每页大小
		page.setPageSize(10);
		//设置开始位置
		page.setStar((page.getCurrentPage()-1)*page.getPageSize());
		//总记录数
		int count = list.size();
		page.setCount(count);
		//总页数
		page.setTotalPage(count%10==0?count/10:count/10+1);
		//每页list
		page.setDataList(list.subList(page.getStar(), count-page.getStar()>page.getPageSize()?page.getStar()+page.getPageSize():count));
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/StudentJsp.jsp").forward(request, response);
	}

}
