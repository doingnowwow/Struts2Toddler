package kr.or.ddit.fileitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;

public interface IFileItemDao {

	
	
		public void insertFileitemInfo(List<FileItemVO> fileItemList) throws SQLException;
		
		
		public FileItemVO fileItemInfo(Map<String, String> params) throws SQLException;
}


