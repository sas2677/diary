
//bno int
//title String
//content String
//regdate date
//filename String
//uuid	String

package kr.co.pro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import kr.co.pro.dto.BoardDTO;
import kr.co.pro.dto.Criteria;



@Mapper
public interface BoardMapper {

	
	  //전체조회
	  
//	 @Select("select * from board")
//	 List<BoardDTO> list();
	
	 @Select("select * from board order By bno desc limit #{skip}, #{amount}")
	 List<BoardDTO>List(Criteria cri);


	@Select("select count(*) from board ")
	int gettotal(Criteria cri);

	// 글 작성
	@Insert("insert into board(title, writer,content) values(#{title}, #{writer},#{content})")
	int register(BoardDTO dto);

	// 선택조회
	@Select("select * from board where bno = #{bno}")
	BoardDTO selectOne(int bno);

	// 수정
	@Update("update board set title = #{title}, writer=#{writer}, content = #{content} where bno=#{bno} ")
	int update(BoardDTO dto);

	// 삭제
	@Delete("delete from board where bno = #{bno}")
	int delete(int bno);
	
	
	//검색
	@Select("SELECT * from board WHERE title LIKE CONCAT('%', #{keyword},'%') || writer LIKE CONCAT('%', #{keyword},'%') || content LIKE CONCAT('%', #{keyword},'%')")
	int getSearch(BoardDTO dto);
	
	
	
	
	
	
	

}
