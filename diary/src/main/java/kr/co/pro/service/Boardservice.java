package kr.co.pro.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.pro.dto.BoardDTO;
import kr.co.pro.dto.Criteria;
import kr.co.pro.mapper.BoardMapper;


@Service
public class Boardservice {
	
	@Autowired
	private BoardMapper mapper;
	
	
	
	//리스트 
	
	public List<BoardDTO> list(Criteria cri){

		return mapper.List(cri);
	}
	
	//전체 게시글 
	public int boardListCnt(Criteria cri) {
		
		return mapper.gettotal(cri);
	}
	
	//작성
	public int register(BoardDTO dto) {
		
		
		return mapper.register(dto);
	}
	
	//선택조회
	public BoardDTO selectone(int bno) {
		
		return mapper.selectOne(bno);
	}
	
	//수정
	public int update(BoardDTO dto) {
		
		
		return mapper.update(dto);
	}
	
	//삭제
	public int delete(int bno) {
		
		
		return mapper.delete(bno);
	}
	
	//검색
	public 	int getSearch(BoardDTO dto) throws Exception {
		
		
		return mapper.getSearch(dto);
	}



	}
	
	



	


