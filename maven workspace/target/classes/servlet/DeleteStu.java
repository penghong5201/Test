package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redisUtil.RedisUtil;

public class DeleteStu extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*response.setContentType("text/html; charset=utf-8");
		response.getWriter().print("你不能直接这样操作！");*/
		RedisUtil ru = new RedisUtil();
	    Jedis redis = ru.getJedis();
		String key = request.getParameter("uuid");
		redis.del(key.getBytes());
		request.getRequestDispatcher("/StudentInfo").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
