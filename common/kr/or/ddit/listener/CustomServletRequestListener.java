package kr.or.ddit.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class CustomServletRequestListener implements ServletRequestListener,
		ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		// setAttribute(key,value)
		// key
		String saveKey = event.getName();
		// value
		Object value = event.getValue();
		System.out.println("HttpServletRequest.setAttribute(키,값) 값 저장시 전파되는 이벤트 청취자");
		

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {

		System.out.println("HttpServletRequest.setAttribute(키) 값 삭제시 전파되는 이벤트 청취자");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("HttpServletRequest.setAttribute(동일키, 다른값) 값 갱신시  전파되는 이벤트 청취자");

	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out
				.println("HttpServletRequest 소멸(서버가 클라이언트 대상 응답 전송시)시 전파되는 이벤트 청취자");

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out
				.println("HttpServletRequest 생성(client가 redirect 요청시마다)시 전파되는 이벤트 청취자");

	}

}
