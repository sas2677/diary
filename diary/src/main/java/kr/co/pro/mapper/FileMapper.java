package kr.co.pro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.pro.dto.FileDTO;

@Mapper
public interface FileMapper {

	//사진리스트
	@Select("select * from file")
	List<FileDTO> listAll();
	
	
	//작성
	@Insert("insert into file (filenum,f_writer,f_regdate,filename,f_uuid) values(#{filenum}, #{f_writer},#{filename}, #{f_uuid})")
	int register(FileDTO dto);
	
	//선택조회
	@Select("select * from file where filenum=#{filenum} ")
	FileDTO selectone(int filenum);
	
	//수정
	@Update("update file set filename=#{filename}, f_uuid=#{f_uuid} where filenum=#{filenum}")
	int update(FileDTO dto);
	
	//삭제
	@Delete("delete from file where filenum=#{filenum}")
	int delete(int filenum);
	
	
	
}
