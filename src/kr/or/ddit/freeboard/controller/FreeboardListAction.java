package kr.or.ddit.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.freeboard.service.IFreeboardService;
import kr.or.ddit.freeboard.service.IFreeboardServiceImpl;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardListAction {
	
	private List<FreeboardVO> freeboardList;
	
	
	public String execute(){
		
		Map<String, String>params = new HashMap<String, String>();
		params.put("startCount", "5");
		params.put("endCount", "1");
		
		
		IFreeboardService service = IFreeboardServiceImpl.getInstance();
		this.freeboardList = service.freeboardList(params);
		
		return "success";
	}


	public List<FreeboardVO> getFreeboardList() {
		return freeboardList;
	}

}
