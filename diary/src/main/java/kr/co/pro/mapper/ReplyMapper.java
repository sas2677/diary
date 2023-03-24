//rno int AI PK 
//user varchar(45) 
//redate datetime 
//rebody varchar(45) 
//bno int


package kr.co.pro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import kr.co.pro.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {
	
	//댓글 개수
	@Select("select count(*) from reply")
	int CommentCount();
	
	
	//댓글 리스트 
	@Select("select * from reply where bno=#{bno} order by rno desc")
	List<ReplyDTO> ListAll(int bno);
	
	
	//댓글 작성
	@Insert("insert into reply(user,rebody,bno) values(#{user},#{rebody},#{bno})")
	int register(ReplyDTO dto);
	
	//댓글 상세보기 
	@Select("select * from reply where rno=#{rno}")
	ReplyDTO Selectone(int rno);
	
	
	//댓글 수정
	@Update("update reply set user=#{user},rebody=#{rebody} where rno=#{rno} and bno=#{bno}")
	int update(ReplyDTO dto);
	
	
	//댓글 삭제
	@Delete("delete from reply where rno=#{rno}")
	int delete(int rno);
	
	

}
