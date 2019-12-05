package kr.or.ddit.freeboard.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.fileitem.dao.IFileItemDao;
import kr.or.ddit.fileitem.dao.IFileItemDaoImpl;
import kr.or.ddit.freeboard.dao.IFreeboardDao;
import kr.or.ddit.freeboard.dao.IFreeboardDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;

public class IFreeboardServiceImpl implements IFreeboardService {
	
	private static IFreeboardServiceImpl service = new IFreeboardServiceImpl();
	
	private IFreeboardDao freeboardDao;
	private IFileItemDao fileitemDao;
	
	
	
	public IFreeboardServiceImpl(){
		
		freeboardDao = IFreeboardDaoImpl.getInstance();
		fileitemDao = IFileItemDaoImpl.getInstance();
	}
	
	public static IFreeboardServiceImpl getInstance(){
		
		return (service == null)? service = new IFreeboardServiceImpl() : service;
	}
	
	
	

	@Override
	public List<FreeboardVO> freeboardList(Map<String,String> params) {
		List<FreeboardVO> FreeboardList = null;
		
		try {
			FreeboardList = freeboardDao.freeboardList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return FreeboardList;
	}

	@Override
	public void insertFreeboardInfo(FreeboardVO freeboardInfo, FileItem[] items) {
		
		try {
			// Freeboard table 대상의 게시글 insert
			//	file_bo_no = freeboard table 대상 bo_no(시퀀스)가 할당
			// fileitem table 대상의 첨부파일 정보 insert*2
			// 특정 게시글의 처부파일인것을 설정 : fileitem talbe 내 file_bo_no
			
			String bo_no = freeboardDao.insertFreeboardInfo(freeboardInfo,items);
			//첨부파일 인서트할때 bo_no=> file_bo_no로 활용
			
			List<FileItemVO>  fileItemList = AttachFileMapper.mapping(items,bo_no);
			
			fileitemDao.insertFileitemInfo(fileItemList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FreeboardVO freeboardInfo(Map<String, String> params) {
		
		FreeboardVO	freeboardInfo = null;
		
		try {
			freeboardInfo = freeboardDao.freeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeboardInfo;
	}

	@Override
	public void updateFreeboardInfo(FreeboardVO freeboardInfo) {
		try {
			freeboardDao.updateFreeboardInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFreeboardInfo(Map<String, String> params) {
		try {
			freeboardDao.deleteFreeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount ="0";
		
		
		try {
			
			totalCount = freeboardDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}

	@Override
	public void insertFreeboardReplyInfo(FreeboardVO freeboardInfo) {
		
		try {
			freeboardDao.insertFreeboardReplyInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
