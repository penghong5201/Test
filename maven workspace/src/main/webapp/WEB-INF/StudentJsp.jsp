<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>学生列表</TITLE> 

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="student" name="student"
		action=""
		method=post>
		
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										
										<h1 align="center"><font style="color:red">学生数据管理</font></h1>
										
										<a href="AddStudent.jsp">新增学生</a>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>姓名</TD>
													<TD>出生年月</TD>
													<TD>备注</TD>
													<TD>平均成绩</TD>
													<TD>操作</TD>
												</TR>
	<c:forEach items="${page.dataList }" var="stu">
	<TR
		style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
		<TD>${stu.name }</TD>
		<TD><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/></TD>
		<TD>${stu.description }</TD>
		<TD>${stu.avgscore }</TD>
	
<TD>
	<a href="UpdataStu?uuid=${stu.id }">修改</a>
	<a href="DeleteStu?uuid=${stu.id }">删除</a>
</TD>
	</TR>										
												
	</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												当前第[<B>${page.currentPage }</B>]页 共[<B>${page.count }</B>]条记录  共[<B>${page.totalPage }</B>]页<br>
												
												<c:if test="${page.currentPage!=1}">
													[<A href="${pageContext.request.contextPath}/StudentInfo?currentPage=${page.currentPage-1}">前一页</A>]
												</c:if>
												
												<c:if test="${page.currentPage!=page.totalPage }">
													[<A href="${pageContext.request.contextPath}/StudentInfo?currentPage=${page.currentPage+1}">后一页</A>] 
													
												</c:if>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
