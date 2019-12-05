package kr.or.ddit.utiles;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CryptoInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		// 해당 인터셉터의 비즈니스 로직이 수행 완료시 
		// 액션 클래스의 액션 메서드를 대상으로 접근할 수 있도록3 해줌.
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		
		Map<String, String> publicKeyMap =  CryptoGenerator.generatePairKey(session);
		
		request.setAttribute("publicKeyMap", publicKeyMap);
		
		// 인터셉터가 해당 요청을 처리하는 액션 클래스 내 액션메서드를 콜백 
		// 해당 액션 클래스 내 액션 메서드의 반환값을 취득ㄷ.
		
		//전처리
		String resultValue = invocation.invoke();
		//후처리
		return resultValue;
	}

}
