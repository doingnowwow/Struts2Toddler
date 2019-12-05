package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class DeleteMemberAction {

	private String mem_id;
	private MemberVO memberInfo;

	public String execute() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);

		IMemberService service = IMemberServiceImpl.getInstance();

		service.deleteMemberInfo(params);

		return "success";

	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public MemberVO getMemberInfo() {
		return (MemberVO) memberInfo;
	}

}
