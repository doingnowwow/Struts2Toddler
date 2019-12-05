package kr.or.ddit.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

public class LogoutAction {
	
	private String message;
	
	public String execute(){
		
		ServletActionContext.getRequest().getSession().invalidate();
		
		try {
			this.message = URLEncoder.encode("로그아웃됫다","UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "loginForm";
		
	}

	public String getMessage() {
		return message;
	}

}
