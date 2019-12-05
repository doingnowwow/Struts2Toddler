package kr.or.ddit.member.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateMemberAction implements ModelDriven<MemberVO> {
	
	//클라이언트로부터 전송된 쿼리스트링의 키와 일치하는 전역변수가 선언되고 , 해당 전역변수의 setter가 존재하면
	// ValeuStack의 일시적 저장된 쿼리스트링의 값이 setter를 통해 주입되어 활용.
	// 인터셉터 params : ValueStack에 저장된 쿼리스트링을 setter를 통해 주입처리.
	
	// <interceptor-ref name="modelDriven"/>
	//  	규칙 : 클래스 implements ModelDriven<T>
	//		interveptor modelDriven : 대량의 쿼리스트링과 맵핑처리될 객체를 ValueStack에 저장
	//								  interceptor params가 쿼리스트링의 키를 기준으로
	//								  modelDriven이 저장한 객체의 선언된 변수와 setter를 
	//								  쿼리스트링 값을 모두 주입.

	private MemberVO memberInfo;
	
	public String execute(){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		
//		MemberVO memberInfo = new MemberVO();
//		
//		try {
//			BeanUtils.populate(memberInfo, request.getParameterMap());
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
		
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.updateMemberInfo(this.memberInfo);
		
		return "success"	;
		
	}

	@Override
	public MemberVO getModel() {
		//  액션 메서드 콜백 전 getModel()가 우선 콞백
		//  ValueStack에 저장될 맵핑 대상 VO의 인스턴스를 반환
		//	(ValueStack 에 저장)
		//   인터셉터 params가 VO에 쿼리스트링의 값을 맵핑 주입
		
		this.memberInfo = new MemberVO();
		
		
		return this.memberInfo;
	}
}
