<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd

">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add</title>
</head>
<body>
	<center><h3 style="color:red">添加学生信息</h3></center>
	<form action="StudentServlet" method="post">
		<table align="center" border="1" width="300px" cellpadding="0" cellspacing="0">
			<tr>
				<th>姓名</th>
				<td ><input type="text" name="name" size="34"/></td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td><input type="Date" name="birthday" size="34"/></td>
			</tr>
			<tr>
				<th>备注</th>
				<td><input type="text" name="description" size="34"/></td>
			</tr>
			<tr>
				<th>平均分</th>
				<td><input type="text" name="avgscore" size="34"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" width="200px" onclick="return check(this.form)"/>&nbsp;
				
				</td>
			</tr>
			
		</table>
		
		
		
	
	</form>



</body>
<script type="text/javascript">
	function check(form){
		if(form.name.value==''){
			alert("请输入姓名");
			form.name.focus;
			return false;
		}else{
			if(form.name.value.length>40){
			alert("名字过长！最多不超多40字符");
			form.name.focus();
			return false;
			}
		}
		if(form.birthday.value==''){
			alert("选择出生日期哦");
			form.birthday.focus();
			return false;
		}
		
		if(form.description.value.length>40){
			alert("备注过长！最多不超多40字符");
			form.description.focus();
			return false;
		}
		if(form.avgscore.value==''){
			alert("平均分不能为空");
			form.avgscore.focus();
			return false;
		}else{
			var reg=/^([1-9]\d{0,1}|100|0)$/;
			if(reg.test(form.avgscore.value)){
				return true;
			}else{
				alert("平均分是0-100的整数哟");
				form.avgscore.focus();
				return false;
			}
		}
	}
</script>
</html>
