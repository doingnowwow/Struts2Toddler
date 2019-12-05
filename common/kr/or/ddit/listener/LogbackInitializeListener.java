package kr.or.ddit.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import kr.or.ddit.utiles.LogbackInitialize;


//ServletContextListener : application(ServletContext)의 생성, 소멸 시 전파되는 이벤트 청취자 자격 부여
//ServletcontextAttributeListenr : 저장영역 값 저장 application.setAttribute(키,값)
//								 : 저장영역 값 저장 application.setAttribute(키,값)
//								 : 저장영역 값 저장 application.setAttribute(키,값)	
//								전파되는 이벤트 청취자 자격 부여 
public class LogbackInitializeListener implements ServletContextListener,
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("application(ServletContext)가 application.setAttribute(키,값) 저장영역 내 저장시 전파되는 이벤트 청취자");


	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("application(ServletContext)가 application.setAttribute(키) 저장영역 내 삭제시 전파되는 이벤트 청취자");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("application(ServletContext)가 application.setAttribute(동일키,다른값) 저장영역 내 갱신시 전파되는 이벤트 청취자");
	}

	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("application(ServletContext)가 소멸시 전파되는 이벤트");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		System.out.println("application(ServletContext)가 최초 인스턴스화 시 전파되는 이벤트");
		LogbackInitialize.init();
	}

}
