//filenum int AI PK 
//f_writer varchar(45) 
//f_regdate varchar(45) 
//filename varchar(500) 
//f_uuid varchar(200) 
//filecol varchar(45)


package kr.co.pro.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {
	
	int filenum;
	String f_writer;
	String f_regdate;
	String filename;
	String f_uuid;
	String filecol;

}
