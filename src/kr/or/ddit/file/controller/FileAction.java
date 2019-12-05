package kr.or.ddit.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.MemberVO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.opensymphony.xwork2.ModelDriven;

public class FileAction implements ModelDriven<MemberVO> {
	
	private MemberVO memberInfo;
	private String fileName;
	
	public String fileUploadMethod(){
		//interceptor-ref name=fileUpload
	//	MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest();
		
		// 폼필드  : mem_id, mem_pass, mem_name
		// 파일*2 : files*2
		
//		String mem_id = wrapper.getParameter("mem_id");
//		String mem_pass = wrapper.getParameter("mem_pass");
//		String mem_name = wrapper.getParameter("mem_name");
//		
//		// ddit, MVCPatternModel2 : 업로드된 모든(폼필드, 파일) 자원 FileItem 타입.
//		// struts 프레임웍 : 업로드된 모든 (폼필드, 파일) 자원 File 타입.
//		
//		File[] files = wrapper.getFiles("files");
//		String[] content = wrapper.getContentTypes("files");
//		String[] fileNames = wrapper.getFileNames("files");
		
		List<File> files = this.memberInfo.getFiles();
		List<String> fileNames = this.memberInfo.getFilesFileName();
		
		for(int i=0; i<fileNames.size();i++){
			File baseFile = files.get(i);
			if(baseFile.length() > 0){
				File saveFile = new File(GlobalConstant.FILE_PATH,fileNames.get(i));
				
				try {
					FileUtils.copyFile(baseFile, saveFile);
					this.fileName = fileNames.get(i);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "success";
		
	}

	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO();
		return this.memberInfo;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	// 파일 다운로드
	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	
	public String fileDownloadMethod(){
		File downloadFile = new File(GlobalConstant.FILE_PATH,this.fileName);
		this.contentDisposition = "attachment;fileName="+this.fileName;
		this.contentLength = downloadFile.length();
		try {
			this.inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return "success";
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	
}
