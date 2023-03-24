package kr.co.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pro.dto.ReplyDTO;
import kr.co.pro.mapper.ReplyMapper;

@Service
public class Replyservice {

	
	@Autowired
	private ReplyMapper replymapper;
	
	//댓글개수
	public int CommentCount() {
		
		return replymapper.CommentCount();
	}
	
	
	//댓글리스트
	public List<ReplyDTO> ListAll(int bno){
		return replymapper.ListAll(bno);
	}
	
	//댓글 작성 
	public int register(ReplyDTO dto) {
		
		return replymapper.register(dto);
	}
	
	//댓글 상세보기
	public ReplyDTO selectone(int rno) {
		
		
		return replymapper.Selectone(rno);
	}
	
	//댓글 수정
	public int update(ReplyDTO dto) {
		
		
		return replymapper.update(dto);
	}
	
	
	//댓글 삭제
	public int delete(int rno){
		
		
		return replymapper.delete(rno);
	}
}
