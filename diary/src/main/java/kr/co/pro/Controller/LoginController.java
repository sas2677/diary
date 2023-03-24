package kr.co.pro.Controller;

import java.io.Console;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.pro.Entity.User;
import kr.co.pro.dto.UserDTO;
import kr.co.pro.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@ResponseBody
	@PostMapping("/idcheck")
	public String idcheck(UserDTO dto) throws Exception {
		int user = loginservice.getId(dto);
		String message = null;
		if (user == 0) {// 사용할 수 있다. db에서 찾았는데없으니까
			message = "success";
		} else {// 사용할 수 없다.
			message = "fail";
		}
		return message;

	}

	@ResponseBody
	@PostMapping("/nicknamecheck")
	public String namecheck(UserDTO dto) throws Exception {
		int name = loginservice.getnickname(dto);
		String message = null;
		if (name == 0) {// 사용할 수 있다. db에서 찾았는데없으니까
			message = "success";
		} else {// 사용할 수 없다.
			message = "fail";
		}
		return message;

	}

	@GetMapping("/login/signupform")
	public String signupform() {

		return "login/signupform";
	}

	@PostMapping("/login/signup")
	public String signup(UserDTO dto) {
		System.out.println(dto);
		loginservice.signup(dto);

		return "redirect:/";
	}

	@GetMapping("login/loginform")
	public String loginform() {

		return "login/loginform";
	}

	@PostMapping("/login/loginpro")
	public String login(UserDTO dto, HttpServletRequest req) {

		HttpSession session = req.getSession();
		UserDTO login = loginservice.login(dto);
		System.out.println("로그인정보 : " + login.toString());

		
		  if(login.getId() == null) { session.setAttribute("loginuser", null);
		  System.out.println("실패"); }else { session.setAttribute("loginuser", login);
		  System.out.println("성공"); }
		  
		
		return "redirect:/";
	}

	@GetMapping("login/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}

}
