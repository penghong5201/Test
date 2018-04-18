package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redisUtil.RedisUtil;
import serializeUtil.SerializeUtil;

import entity.Page;
import entity.Student;

public class StudentInfo extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		//实例redis工具类
		RedisUtil ru = new RedisUtil();
	    Jedis redis = ru.getJedis();
	    Page page = new Page();
	    //未排序的list集合
	    List<Student> list1 =new ArrayList<Student>();
	    Set s = redis.keys("*");
	    Iterator it = s.iterator();
	    
	    while(it.hasNext()){
	    	String key = (String) it.next();
	    	byte[] value = redis.get(key.getBytes());    	
	    	Student stu = (Student) SerializeUtil.unserialize(value);
	    	list1.add(stu);
	    }
	    //调用方法排序
	   /* if(list1.size()==0||list1==null){
	    	request.setAttribute("list", list1);
	    	System.out.print("11");
	    	request.getRequestDispatcher("/WEB-INF/StudentJsp.jsp").forward(request, response);
	    }else{*/
	    	 List<Student> list = SortList(list1);
	    	 if(list.size()==0){
	    		 request.getRequestDispatcher("/WEB-INF/StudentJsp.jsp").forward(request, response);
	    	 }else{
	    		 request.setAttribute("list", list);
	 	 	    if(request.getParameter("currentPage")==null){
	 	 	    	page.setCurrentPage(1);
	 	 	    }else{
	 	 	    	page.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
	 	 	    }
	 	 	    request.setAttribute("page", page);
	 	 	    //request.getRequestDispatcher("/WEB-INF/StudentJsp.jsp").forward(request, response);
	 	 	    request.getRequestDispatcher("/PageList").forward(request, response);
	    	 }
	 	    
	    //}
	   
	}
	
	 //排序，Collections工具类，sort静态方法对list进行排序
	 //采用策略排序，该策略倒序排列
    public List<Student> SortList(List<Student> list){
    	if(list.size()>0){
    		Collections.sort(list, new Comparator<Student>(){  
                @Override  
                public int compare(Student s1, Student s2){  
                    if(s1.getAvgscore()>s2.getAvgscore()){  
                    	//System.out.print(s1.getAvgscore().compareTo(s2.getAvgscore()));
                        return 1;  
                    }  
                    if(s1.getAvgscore()==s2.getAvgscore()){  
                        return 0;  
                    }  
                    return -1;  
                }  
            }); 
    	}
         
        return list;  
    }

	
}
