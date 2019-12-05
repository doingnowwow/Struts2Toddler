<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
	
	클라이언트 단 파일 업로드 : <form enctype = multipart/form-data>
							ajax({})
							
	파일 업로드 환경
	1. http://commons.apache.org	
			commons-fileupload-1.2.2.jar
			commons-io-2.6.jar
	2. WEB-INF/lib		import								
	

-->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jqueyr-latest.js"></script>
<script type="text/javascript">

	$(function(){
		
		$('form').submit(function(){
			
			var flag = true;
			$('input[type-file]').each(function( index, inputTag){
				
				if(!/\.(jpg|jpeg|gif|png)$/.test($(inputTag).val().toLowerCase() )){
						alert('이미지 파일만 업로드 할 수 있슴');
						flag = false;
						
				}
				
			})
			
			return flag;
			
		})
		
		
	})
</script>
</head>
<body>
<!-- 
	form 태그 enctype = "application/x-www-form-urlencoded" 일반 서브밋 요청(쿼리 스트링의 값은 문자열)
			 enctype = "multipart/form-data"
			 			파일 서브밋 요청(쿼리스트링의 값은 바이너리 스트리밍을 활용)
	form 태그 파일 서브밋 요청시 :  method = "POST"		 			
 -->

<form action="${pageContext.request.contextPath }/file/fileUpload.do" method="POST" enctype="multipart/form-data">
	<table>
		<tr>
			
			<td>아이디</td>
			<td><input type="text"  name = "mem_name"/></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="text" name = "mem_pass" /></td>
		</tr>
		<tr>
			
			<td>성명</td>
			<td><input type="text" name = "mem_name"  /></td>
		</tr>
		<tr>
			<td>파일1</td>
			<td><input type="file" name="files"/></td>
		</tr>
		<tr>
			<td>파일2</td>
			<td><input type="file"   name="files"/></td>
		</tr>
		<tr>
			<td colspan="2"></td>
			<td><input type="submit" value="파일전송" /></td>
		</tr>
	</table>
</form>	
<img src="/files/${param.fileName }" alt=""  width="200px" height="250px" onclick="javascript:location.href='${pageContext.request.contextPath}/file/fileDownload.do?fileName=${param.fileName }';"/>
	
</body>
</html>