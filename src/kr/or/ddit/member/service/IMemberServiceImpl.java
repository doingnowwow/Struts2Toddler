package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.IMemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class IMemberServiceImpl implements IMemberService {

	// 싱글톤 패턴
	private static IMemberService service = new IMemberServiceImpl();
	private IMemberDao dao;

	private IMemberServiceImpl() {
		dao = IMemberDaoImpl.getInstance();
	}

	public static IMemberService getInstance() {
		return (service == null) ? service = new IMemberServiceImpl() : service;

	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;
		try {
			memberInfo = dao.memberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) {
		List<MemberVO> memberList = null;
		try {
			memberList = dao.memberList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;

	}
	
	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> memberList = null;
		try {
			memberList = dao.memberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;

	}

	@Override
	public void insertMemberInfo(MemberVO memberInfo) {
		try {
			dao.insertMemberInfo(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) {

		try {
			dao.updateMemberInfo(memberInfo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) {

		try {
			dao.deleteMemberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
