package kr.or.ddit.fileitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.IFileItemDao;
import kr.or.ddit.fileitem.dao.IFileItemDaoImpl;
import kr.or.ddit.vo.FileItemVO;

public class IFileItemServiceImpl implements IFileItemService {
	
	
	private static IFileItemService service = new IFileItemServiceImpl();
	
	private IFileItemDao dao;
	
	private IFileItemServiceImpl(){
		
		dao = IFileItemDaoImpl.getInstance();
		
		
	}
	
	public static IFileItemService getInstance(){
		
		return (service == null) ? service = new IFileItemServiceImpl() : service;
	}
	
	
	
	

	@Override
	public void insertFileitemInfo(List<FileItemVO> fileItemList) {
		// TODO IFileItemServiceImpl 에서 IFileItemDaoImpl의 해당 메서드 호출시 작성 예약

	}

	@Override
	public FileItemVO fileItemInfo(Map<String, String> params) {
		FileItemVO fileItemInfo = null;
		try {
			fileItemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileItemInfo;
	}

}
