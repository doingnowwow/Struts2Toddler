package kr.or.ddit.hello.controller;

//커맨드 컨트롤러
//	규칙 : String|void execute(){} 액션 메서드
//		  예외로 execute() 메서드명이 변경 가능.
public class HelloAction {

	public String execute(){
		// Model 레이어 접점
		// View 결졍(반환값)
		System.out.println("HelloAction의 execute()콜백");
		return "success";
	}
}
