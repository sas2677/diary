//rno int AI PK 
//user varchar(45) 
//redate varchar(45) 
//rebody varchar(45)


package kr.co.pro.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
	
	int rno;
	String user;
	LocalDateTime redate;
	String rebody;
	int bno;
	
	

}
