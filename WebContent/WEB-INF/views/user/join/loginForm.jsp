<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 서식</title>
<script type = 'text/javascript'>
if(eval('${!empty param.message}')){
	alert('${param.message}');
	
}

</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/join/loginCheck.do" method="POST">

		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mem_id" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="text" name="mem_pass" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인" /> <a
					href='${pageContext.request.contextPath }/member/memberForm.do'>회원가입을 해주세요.</a></td>
			</tr>
		</table>
	</form>
</body>
</html>