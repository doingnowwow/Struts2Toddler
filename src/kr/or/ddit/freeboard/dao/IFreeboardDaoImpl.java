package kr.or.ddit.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FreeboardVO;

public class IFreeboardDaoImpl implements IFreeboardDao {

	private static IFreeboardDao dao = new IFreeboardDaoImpl();

	private SqlMapClient client;

	public IFreeboardDaoImpl() {

		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static IFreeboardDao getInstance() {

		return (dao == null) ? dao = new IFreeboardDaoImpl() : dao;

	}

	@Override
	public List<FreeboardVO> freeboardList(Map<String, String> params)
			throws SQLException {

		return client.queryForList("freeboard.FreeboardList", params);
	}

	@Override
	public String insertFreeboardInfo(FreeboardVO freeboardInfo,
			FileItem[] items) throws SQLException {

		return (String) client.insert("freeboard.insertFreeboard",
				freeboardInfo);
	}

	@Override
	public FreeboardVO freeboardInfo(Map<String, String> params)
			throws SQLException {
		client.update("freeboard.updateBOHIT", params);
		return (FreeboardVO) client.queryForObject("freeboard.freeboardInfo",
				params);
	}

	@Override
	public void updateFreeboardInfo(FreeboardVO freeboardInfo)
			throws SQLException {
		client.update("freeboard.updateFreeboard", freeboardInfo);
	}

	@Override
	public void deleteFreeboardInfo(Map<String, String> params)
			throws SQLException {
		client.update("freeboard.deleteFreeboard", params);

	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("freeboard.totalCount", params);
	}

	@Override
	public void insertFreeboardReplyInfo(FreeboardVO freeboardInfo)
			throws SQLException {

		// freeboardInfo : 댓글 데이타 저장
		// 부모글 bo_group, bo_seq, bo_depth

		try {
			client.startTransaction();

			String bo_seq;
			
			if("0".intern() == freeboardInfo.getBo_seq().intern()){
				// 현재의 댓글의 부모글이 루트글
				bo_seq = (String) client.queryForObject("freeboard.incrementSEQ",freeboardInfo);
			}else{
				// 현재의 댓글의 부모글이 댓글
				client.update("freeboard.updateSEQ",freeboardInfo);
				bo_seq = String.valueOf(Integer.parseInt(freeboardInfo.getBo_seq())+1);
			}
			
			
			freeboardInfo.setBo_seq(bo_seq);
			
			
			String bo_depth = String.valueOf(Integer.parseInt(freeboardInfo.getBo_depth())+1);
			freeboardInfo.setBo_depth(bo_depth);
			
			client.insert("freeboard.insertFreeboardReply",freeboardInfo);
			
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}

	}

}
