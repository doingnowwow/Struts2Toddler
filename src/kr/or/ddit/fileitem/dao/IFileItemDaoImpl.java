package kr.or.ddit.fileitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;

public class IFileItemDaoImpl implements IFileItemDao {
	
	private static IFileItemDao dao = new IFileItemDaoImpl();
	
	private SqlMapClient client;
	private IFileItemDaoImpl(){
		
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFileItemDao getInstance(){
		return (dao==null) ? dao = new IFileItemDaoImpl() : dao;
	}
	

	@Override
	public void insertFileitemInfo(List<FileItemVO> fileItemList)
			throws SQLException {
		
		try{
			client.startTransaction();
			
		for(FileItemVO fileItemInfo : fileItemList){
			// 첨부파일 최대 2개  : insert 최대 2번 
			//		1. insert 성공 , 2. inser 성공 commit
			//		1. insert 성공,  2. insert 실패 rollback
			//		1. insert 실패 
			// 	 Commit  : startTransaction() -> commitTransaction() -> endTransaction()
			//	Rollback : 	startTransaction() -> 에러발생 commitTransaction() 호춣 x 
			//					-> endTransaction()
			
				client.insert("fileitem.insertFileItem",fileItemInfo);
				
				
			}
		client.commitTransaction();
		}finally{
			
			client.endTransaction();
		}

	}

	@Override
	public FileItemVO fileItemInfo(Map<String, String> params)
			throws SQLException {
		return (FileItemVO) client.queryForObject("fileitem.fileItemInfo",params);
	}

}
