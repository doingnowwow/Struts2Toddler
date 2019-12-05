package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;

public interface IFileItemService {

	
	public void insertFileitemInfo(List<FileItemVO> fileItemList);
	
	public FileItemVO fileItemInfo(Map<String,String> params);
}
