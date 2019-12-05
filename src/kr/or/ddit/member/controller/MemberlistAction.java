package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberlistAction {

	private List<MemberVO> memberList ;
	
	
	
	public String execute(){
		IMemberService service = IMemberServiceImpl.getInstance();
		this.memberList = service.memberList();
		
		return "success";
		
	}



	public List<MemberVO> getMemberList() {
		return memberList;
	}
}
