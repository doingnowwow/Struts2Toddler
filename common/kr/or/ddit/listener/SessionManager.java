package kr.or.ddit.listener;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import kr.or.ddit.vo.MemberVO;

public class SessionManager implements HttpSessionAttributeListener,
		HttpSessionListener {

	public static SessionManager sessionMGR = null;

	// String : 세션아이디
	// Object : 세션
	public static Hashtable<String, Object> sessionMonitor = null;

	public SessionManager() {
		if (sessionMonitor == null) {
			sessionMonitor = new Hashtable<String, Object>();
		}
	}

	public static synchronized SessionManager getInstance() {
		if (sessionMGR == null) {
			sessionMGR = new SessionManager();
		}

		return sessionMGR;

	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {

		HttpSession newSession = event.getSession();
		synchronized (sessionMonitor) {

			sessionMonitor.put(newSession.getId(), newSession);
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession removeSession = event.getSession();
		synchronized (sessionMonitor) {

			sessionMonitor.remove(removeSession.getId());
		}
	}

	//loginCheck.jsp	session(currnetLoginSession).getId;
	//					mem_id, mem_pass
	public boolean loginDuplicationCheck(String currnetSessionID,String mem_id){
		
		boolean flag = false;
		Enumeration<Object> sessions = sessionMonitor.elements();
		while(sessions.hasMoreElements()){
			 // SessionMonitor 에서 저장된 세션을 순차 접근 
			HttpSession session = (HttpSession) sessions.nextElement();
			
			MemberVO memberInfo = (MemberVO) session.getAttribute("LOGIN_MEMBERINFO");
			if(memberInfo != null ) {
				if(mem_id.intern() == memberInfo.getMem_id().intern() && currnetSessionID.intern() != session.getId()){
					session.invalidate();
					flag = true;
				}
			}
			
		}
		return flag;
	}


	public int clientCNT(){
		
		//현재  웹 어플리케이션 서비스를 활용하는 모든 클라이언트 범위
		return sessionMonitor.size();
		
	}
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

}
