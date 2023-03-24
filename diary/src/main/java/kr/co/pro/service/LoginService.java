package kr.co.pro.service;

import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.pro.Entity.User;
import kr.co.pro.dto.UserDTO;
import kr.co.pro.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginmapper;
	
	
	//아이디 중복
	public int getId(UserDTO dto) throws Exception {
		int result = loginmapper.getId(dto);
		
		return result;
		
	}
	
	//닉네임 중복
	public int getnickname(UserDTO dto) throws Exception{
		
		int result =loginmapper.getnickname(dto);
		
		return result;
	}
	
	
	// 회원가입
	public void signup(UserDTO dto) {
		
		loginmapper.create(dto);
	}
	
	//로그인
	public UserDTO login(UserDTO dto){
		
		
		return loginmapper.login(dto);
	}
	//로그인 수정
	public int update(UserDTO dto) {
		
		return loginmapper.update(dto);
	}
	
	//로그인 삭제
	public int delete(int num) {
		
		return loginmapper.delete(num);
	}
	
	
	
	
}
