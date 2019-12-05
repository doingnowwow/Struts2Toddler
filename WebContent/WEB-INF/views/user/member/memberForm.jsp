<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/validation.js'></script>
<script type='text/javascript'>

$(function(){
			$('form').submit(function(){	
				if(!$('input[name=mem_id]').val().validationID()){
						alert('아이디를 바르게 입력해주세요');	
						return false;
			}
				if(!$('input[name=mem_pass]').val().validationPWD()){
						alert('비밀번호를 바르게 입력해주세요');		
						return false;
					}
				if(!$('input[name=mem_name]').val().validationNM()){
						alert('이름을 바르게 입력해주세요');										
						return false;
					}
					var regno = $('input[name=mem_regno1]').val() + '-' +  $('input[name=mem_regno2]').val();
				if(!regno.validationREGNO()){						
						alert('주민등록번호를 바르게 입력해주세요');							
						return false;
					}
		
				if(!$('input[name=mem_bir]').val().validationBIR()){
						alert('생일을 바르게 입력해주세요');							
						return false;
					}
		
				if(!$('input[name=mem_hometel]').val().validationHOMETEL()){
						alert('집전화번호를 바르게 입력해주세요');											
						return false;
					}
				if(!$('input[name=mem_comtel]').val().validationCOMTEL()){
						alert('회사전화번호를 바르게 입력해주세요');											
						return false;
					}
				if(!$('input[name=mem_hp]').val().validationHP()){
						alert('휴대폰번호를 바르게 입력해주세요');								
						return false;
					}
				if(!$('input[name=mem_mail]').val().validationMAIL()){
						alert('이메일을 바르게 입력해주세요');										
						return false;
					}
	
				})
		
				
		$('#idcheck').click(function(){
			
			if(!$('input[name=mem_id]').val().validationID()){
					alert('아이디를 바르게 입력해주세요');	
					return false;
						
					}
					
					$.ajax({
						
						type : 'post'
						,url : '${pageContext.request.contextPath}/member/idCheck.do'
						,dataType : 'json'
						,data :{mem_id :$('input[name=mem_id]').val() }
						,error : function(result){
							
								alert(result.status);
						}
						,success : function(result){
							
								alert(result.flag);
						}
						
					})

					
					
				
			
				
				
		});
			
			
			
			
})

		</script>

</head>
<body>


<form action='${pageContext.request.contextPath }/member/insertMemberInfo.do' method='POST'>           
			<table>                                                             
				<tr>                                                            
					<td>아이디</td>                                             
					<td><input type='text' name ='mem_id'  />
						<input type="button" value="아이디중복검사" id="idcheck" />
					</td>              
				</tr>                                                           
				<tr>                                                            
					<td>패스워드</td>                                           
					<td><input type='text' name='mem_pass'/></td>               
				</tr>                                                           
				<tr>                                                            
					<td>성명</td>                                               
					<td><input type='text' name='mem_name' /></td>              
				</tr>                                                           
				<tr>                                                            
					<td>주민등록번호</td>                                       
					<td>                                                        
					<input type='text' name='mem_regno1' />                     
					<input type='text' name='mem_regno2' />                     
					</td>                                                       
				</tr>                                                           
				<tr>                                                            
					<td>생일</td>                                               
					<td><input type='text' name='mem_bir'/></td>                
				</tr>                                                           
				                                                                
				<tr>                                                            
					<td>집전화번호</td>                                         
					<td><input type='text' name='mem_hometel'/></td>            
				</tr>                                                           
				<tr>                                                            
					<td>회사번호</td>                                           
					<td><input type='text' name='mem_comtel'/></td>             
				</tr>                                                           
				<tr>                                                            
					<td>휴대폰</td>                                             
					<td><input type='text' name='mem_hp' /></td>                
				</tr>                                                           
				<tr>                                                            
					<td>이메일</td>                                             
					<td><input type='text' name='mem_mail' /></td>              
				</tr>                                                           
				<tr>                                                            
					<td>우편번호</td>                                           
					<td><input type='text' name='mem_zip'/></td>                
				</tr>                                                           
				                                                                
				<tr>                                                            
					<td>주소</td>                                               
					<td><input type='text' name='mem_add1' />&nbsp;&nbsp;       
						<input type='text' name='mem_add2' />                   
						</td>                                                   
				</tr>                                                           
				<tr>                                                            
					<td>직업</td>                                               
					<td><input type='text' name='mem_job'/></td>                
				</tr>                                                           
				<tr>                                                            
					<td>취미</td>                                               
					<td><input type='text' name='mem_like' /></td>              
				</tr>                                                           
                                                                                
				<tr>                                                            
					<td colspan='2'><input type='submit' value='회원가입' /></td>
				</tr>                                                           
			</table>                                                            
		</form>  


</body>
</html>