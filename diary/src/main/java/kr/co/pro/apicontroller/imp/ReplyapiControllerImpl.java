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
import kr.co.pro.apicontroller.ReplyapiController;
import kr.co.pro.dto.ReplyDTO;
import kr.co.pro.service.Replyservice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ReplyapiControllerImpl implements ReplyapiController {

		@Autowired
		private Replyservice service;
		
		@Override
		@PostMapping("/reply")
		public ResponseEntity<ReplyDTO> register(@RequestBody ReplyDTO dto) {
			System.out.println("API 컨트롤러 테스트 로그");
			
			  if(dto == null){
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		        }
			  
			  
		        int result = service.register(dto);
		        System.out.println("생성된 댓글 dto"+ dto.toString());


		        if(result == 0){
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		        }

		        return ResponseEntity.status(HttpStatus.OK).build();
		}

		@Override	
		@PutMapping("/reply")
		public ResponseEntity<ReplyDTO> update(@RequestBody ReplyDTO dto) {
			System.out.println(dto.getBno());
		    int result = service.update(dto);
		    System.out.println(String.valueOf(result));
	        if (result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	        return ResponseEntity.status(HttpStatus.OK).build();
		}

		@Override
		@DeleteMapping("/reply")
		public ResponseEntity<ReplyDTO> delete(@RequestBody ReplyDTO dto) {
			int rno = dto.getRno();
			int result = service.delete(rno);
			if (result == 0){ 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
			}

	        return ResponseEntity.status(HttpStatus.OK).build();
	}
		
	}



