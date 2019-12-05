package kr.or.ddit.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

//http://localhost/Struts2Toddelr/join/loginCheck.do
//		method=POST		mem_id=값mem_pass=값
public class LoginCheckAction {
	
	// 클라이언트가 전송한 쿼리스트링 취득 
	//	규칙 : 쿼리스트링의 key와 일치하는 전역변수(인스턴스 변수) 선언
	//		  해당 전역변수의 setter 선언시 setter를 통해 쿼리 스트링의 값 주입.
	private String mem_id;
	private String mem_pass;
	
	//서버의 액션 클래스에서 포워딩되는 또는 리다이렉트 또는 포워딩 되는 jsp, tiles, 다른 패키지의 다른 액션에 값을 전달
	// 	규칙 : 액션클래스 내 전역 변수 선언 및 할당된 값의 전달을 위해 getter를 선언 활용하고, 
	//		 ${전역변수명}, request.getAttribute("전역변수명"),
	//		 ValueStack 에서 전역변수명으로 값을 취득할 수 있다.
	//		  * ValueStack : 서블릿 컨테이너가 제공하는 HttpServletRequest의 저장영역을 
	//						 스트럿츠 프레임웍 내 재정의한 저장영역(getter의 반환값, setter를 통해 주입값)
	
	private String message;

	public String execute(){
		// HttpServletRequest, HttpServletResponse 취득
		// Tomcat(Servlet Container) - 웹어플리케이션 - applicatsion(ServletContext)
		// Struts2 프레임웤 - 웹 어플리케이션별 ServletActionContext
		
	HttpServletRequest request=  ServletActionContext.getRequest();
//		String mem_id = request.getParameter("mem_id");
//		String mem_pass = request.getParameter("mem_pass");
	
		HttpSession session = request.getSession(true);
//	HttpServletResponse response = ServletActionContext.getResponse();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id",this.mem_id);
		params.put("mem_pass",this.mem_pass);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		if(memberInfo == null){
			//	<result type="redirectaction"/>
			//	에러아닌 에러가 발생되서 신경쓰임. ...(한글안깨짐)
//			this.message = "회원이 아닙니다.";
			// <result type ="redirect"/>
			try {
				this.message = URLEncoder.encode("회원이 아닙니다.","UTF-8");
			} catch (UnsupportedEncodingException e) {
				session.setAttribute("LOGIN_MEMBERINFO", memberInfo);
				e.printStackTrace();
			}
			
			return "loginForm";
		}else{
			return "memberList";
		}

	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMessage() {
		return message;
	}
}
