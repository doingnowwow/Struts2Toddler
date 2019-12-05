package kr.or.ddit.member.controller;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertMemberAction implements ModelDriven<MemberVO> {

	private MemberVO memberInfo;
	
	

	public String execute(){
		
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.insertMemberInfo(this.memberInfo);
		
		return "success";
		
	}
	
	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO();
		
		
		
		return this.memberInfo;
	}
	
	public void setMemberInfo(MemberVO memberInfo) {
		this.memberInfo = memberInfo;
	}
	

	
}
