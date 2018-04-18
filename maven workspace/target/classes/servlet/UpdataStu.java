package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redisUtil.RedisUtil;
import serializeUtil.SerializeUtil;
import entity.Student;

public class UpdataStu extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdataStu() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*response.setContentType("text/html; charset=utf-8");
		response.getWriter().print("你不能直接这样操作！");*/
		RedisUtil ru = new RedisUtil();
	    Jedis redis = ru.getJedis();
		String key = request.getParameter("uuid");
		byte[] value = redis.get(key.getBytes());    	
    	Student stu = (Student) SerializeUtil.unserialize(value);
    	
    	request.setAttribute("stu", stu);
	    request.getRequestDispatcher("UpdataStu.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
