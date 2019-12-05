package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class IMemberDaoImpl implements IMemberDao {

	private static IMemberDao dao = new IMemberDaoImpl();
	
	private SqlMapClient client;
	

	private IMemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static IMemberDao getInstance() {
		return (dao == null) ? dao = new IMemberDaoImpl() : dao;
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		
		
		return (MemberVO) client.queryForObject("member.memberInfo",params);
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException {
	
		return client.queryForList("member.memberList",params);
	}
	
	@Override
	public List<MemberVO> memberList() throws SQLException {
	
		return client.queryForList("member.memberList");
	}

	@Override
	public void insertMemberInfo(MemberVO memberInfo) throws SQLException {
		client.insert("member.insertMember",memberInfo);

	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) throws SQLException {
		// 동적인 테이블 생성, 시퀀스 생성, 뷰 생성, 유저생성....
		client.update("member.updateMember",memberInfo);
		
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params)
			throws SQLException {

		client.update("member.deleteMember",params);
	}

}
