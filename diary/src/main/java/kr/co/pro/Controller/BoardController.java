package kr.co.pro.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.pro.dto.BoardDTO;
import kr.co.pro.dto.Criteria;
import kr.co.pro.dto.PageDTO;
import kr.co.pro.service.Boardservice;
import kr.co.pro.service.Replyservice;



@Controller
public class BoardController {
	
	
	@Autowired
	Boardservice service;
	
	@Autowired
	Replyservice replyService;
	
	
	
	//게시판 리스트
	@GetMapping("/board/list")
	public String list(Model model,Criteria cri){
		List<BoardDTO> list = service.list(cri);
		
		int total = service.boardListCnt(cri);
		PageDTO pageMaker = new PageDTO(cri,total);
		
		model.addAttribute("listdata",list);
		model.addAttribute("pageMaker",pageMaker);
	
		
		return "board/boardlist";
	}

	
	//게시판 작성 폼
	@GetMapping("/board/registerform")
	public String registerform() {
	
		return "board/register";
	}
	
	//게시판 상세보기 
	@GetMapping("/board/selectOne/{bno}")
	public String SelectOne(@PathVariable("bno") int bno, Model model,BoardDTO dto) {
		System.out.println(service.selectone(dto.getBno()));
		model.addAttribute("selectdata", service.selectone(dto.getBno()));
		model.addAttribute("replydata", replyService.ListAll(bno));
		
		
		return "board/selectone";
	}
	
	
	
	
	//게시판 수정
	@GetMapping("/board/edit")
	public String updateform(Model model, BoardDTO dto) {
	
		model.addAttribute("update", service.selectone(dto.getBno()));
		
		return "/board/board-edit-form";	
	}
	
	
	//todolist
	@GetMapping("/board/todolist")
	public String todolist() {
		
		
		
		return "board/todolist";
	}

}