package kr.co.pro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.pro.Entity.Reply;
import kr.co.pro.dto.ReplyDTO;
import kr.co.pro.service.Boardservice;
import kr.co.pro.service.Replyservice;

@Controller
public class ReplyController {

	@Autowired
	Replyservice replyService;
	
	@Autowired
	Boardservice boardservice;

	@RequestMapping("/list") // 댓글 리스트
	@ResponseBody
	private List<ReplyDTO> list(Model model,ReplyDTO dto) throws Exception {

		return replyService.ListAll(dto.getBno());
	}
	
	
	
	
	@GetMapping("/reply/replyregister")
	public String registerform(@RequestParam("bno") int bno,Model model) {
		
		model.addAttribute("selectdata",boardservice.selectone(bno));
		model.addAttribute("bnoData", bno);
		return "/reply/replyregister";
	}

	
	
	@GetMapping("/reply/edit")
	public String editform(@RequestParam("rno") int rno, Model model,ReplyDTO dto) {

		  model.addAttribute("replydata", replyService.selectone(rno));
		  System.out.println(toString());

		return "/reply/reply-edit-form";
	}
	
	
	
//	@PostMapping("/registerPro")
//	@ResponseBody
//	public Object register(@RequestParam String data) throws Exception {
//		
//		return "data";
//	}
//

	
	
	

}
