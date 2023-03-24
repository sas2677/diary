package kr.co.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pro.dto.FileDTO;
import kr.co.pro.mapper.FileMapper;

@Service
public class FileService {

	@Autowired
	private FileMapper filemapper;
		
	//전체리스트
	public List<FileDTO> listAll(){
		
		
		return filemapper.listAll();
	}
	
	
	//업로드
	public int register(FileDTO dto) {
		
		return filemapper.register(dto);
	}
	
	//선택조회
	public FileDTO selectone(int filenum) {
		
		return filemapper.selectone(filenum);
		
	}
	
	//수정
	public int update(FileDTO dto) {
		
		return filemapper.update(dto);
	}
	
	//삭제
	public int delete(int filenum) {
		
		return filemapper.delete(filenum);
	}
	
	
}
