package kr.co.pro.apicontroller;

import org.springframework.http.ResponseEntity;

import kr.co.pro.dto.BoardDTO;

public interface Boardapicontroller {

	
	ResponseEntity register (BoardDTO dto);
	
	ResponseEntity update(BoardDTO dto);
	
	ResponseEntity delete(BoardDTO dto);
}
