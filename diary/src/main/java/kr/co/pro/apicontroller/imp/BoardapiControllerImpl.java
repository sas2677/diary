package kr.co.pro.apicontroller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pro.apicontroller.Boardapicontroller;
import kr.co.pro.dto.BoardDTO;
import kr.co.pro.service.Boardservice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardapiControllerImpl implements Boardapicontroller {

	@Autowired
	private Boardservice boardService;
	
	@Override
	@PostMapping("/board")
	public ResponseEntity<BoardDTO> register(@RequestBody BoardDTO dto) {
		System.out.println("API 컨트롤러 테스트 로그");
		
		  if(dto == null){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
		  
		  System.out.println(dto.toString());
	        int result = boardService.register(dto);


	        if(result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override	
	@PutMapping("/board")
	public ResponseEntity<BoardDTO> update(@RequestBody BoardDTO dto) {
		System.out.println(dto.getBno());
	    int result = boardService.update(dto);
	    System.out.println(String.valueOf(result));
        if (result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@DeleteMapping("/board")
	public ResponseEntity<BoardDTO> delete(@RequestBody BoardDTO dto) {
		int bno = dto.getBno();
		int result = boardService.delete(bno);
		if (result == 0){ 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
		}

        return ResponseEntity.status(HttpStatus.OK).build();
}
	
}
