package kr.co.pro.apicontroller;

import org.springframework.http.ResponseEntity;

import kr.co.pro.dto.ReplyDTO;



public interface ReplyapiController {

	ResponseEntity register (ReplyDTO dto);
	
	ResponseEntity update(ReplyDTO dto);
	
	ResponseEntity delete(ReplyDTO dto);
	
}
