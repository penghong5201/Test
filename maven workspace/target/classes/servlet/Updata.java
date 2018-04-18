package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redisUtil.RedisUtil;
import serializeUtil.SerializeUtil;

import entity.Student;

public class Updata extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print("你不能直接这样操作！");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RedisUtil ru = new RedisUtil();
	    Jedis redis = ru.getJedis();
	    
		Student stu = new Student();
		stu.setId(request.getParameter("id"));
		stu.setName(request.getParameter("name"));
		String birthday = request.getParameter("birthday");
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd"); 	
		
		try {
			Date date = dataFormat.parse(birthday);
			stu.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stu.setDescription(request.getParameter("description"));
		stu.setAvgscore(Integer.parseInt(request.getParameter("avgscore")));
		
		if(redis.exists(stu.getId().getBytes())){
			redis.set(stu.getId().getBytes(), SerializeUtil.serialize(stu));
		}else{
			System.out.print("不存在此用户");
		}
		
		request.getRequestDispatcher("/StudentInfo").forward(request, response);
	}

}
