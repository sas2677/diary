package kr.co.pro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.pro.dto.UserDTO;



@Mapper
public interface LoginMapper {
	//아이디 중복확인
	@Select("select count(*) from user where id= #{id}")
	int getId(UserDTO dto);
	
	//닉네임 중복확인
	@Select("select count(*) from user where nickname=#{nickname}")
	int getnickname(UserDTO dto);
	
	//회원가입
	@Insert("insert into user(id, password, nickname) values(#{id},#{password},#{nickname})")
	int create(UserDTO dto);

	//로그인
	@Select("select * from user where id = #{id} and password =#{password}")
	UserDTO login(UserDTO dto);

	//수정하기
	@Update("update user set id=#{id}, password=#{password}, nickname=#{nickname} where num=#{num}")
	int update(UserDTO dto);
	
	
	//삭제하기
	@Delete("delete * from user where num=#{num}")
	int delete(int num);
	
}
