<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript'
	src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript'>
	$(function() {
		$('input[value=회원목록]').click(function() {
			$(location).attr('href', '${pageContext.request.contextPath}/member/memberList.do');
		});
		////////////////////////////////////////////////////////////
		$('input[value=회원탈퇴]').click(	function() {
							$(location).attr('href','${pageContext.request.contextPath}/member/deleteMemberInfo.do?mem_id=${memberInfo.mem_id}');
						});
		//////////////////////////////////////////////////////////
		$('input[value=로그아웃]').click(	function() {
			$(location).attr('href','${pageContext.request.contextPath}/join/logout.do');
		});

	});
</script>
</head>
<body>
	<form action='${pageContext.request.contextPath }/member/updateMemberInfo.do' method='POST'>
		<input type='hidden' name='mem_id' value= '${memberInfo.mem_id }' />

		<table>
			<tr>
				<td>아이디</td>
				<td><input type='text' name='mem_id' disabled='disabled'
					value='${memberInfo.mem_id }' /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type='text' name='mem_pass'
					value='${memberInfo.mem_pass }' /></td>
			</tr>
			<tr>
				<td>성명</td>
				<td><input type='text' name='mem_name' disabled='disabled'
					value='${memberInfo.mem_name }' /></td>
			</tr>
			<tr>
				<td>집전화번호</td>
				<td><input type='text' name='mem_hometel'
					value='${memberInfo.mem_hometel }' /></td>
			</tr>
			<tr>
				<td>회사번호</td>
				<td><input type='text' name='mem_comtel'
					value='${memberInfo.mem_comtel }' /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type='text' name='mem_hp'
					value='${memberInfo.mem_hp }' /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type='text' name='mem_mail'
					value='${memberInfo.mem_mail }' /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type='text' name='mem_add1'
					value='${memberInfo.mem_add1 } ' />&nbsp;&nbsp; <input
					type='text' name='mem_add2' value='${memberInfo.mem_add2 }' />
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td><input type='text' name='mem_job'
					value='${memberInfo.mem_job }' /></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type='text' name='mem_like'
					value='${memberInfo.mem_like }' /></td>
			</tr>

			<tr>
				<td colspan='2'><input type='submit' value='회원정보수정' /> 
				<input type='button' value='회원탈퇴' /> 
				<input type='button' value='회원목록' />
				<input type='button' value='로그아웃' />
				</td>

			</tr>
		</table>
	</form>





</body>
</html>