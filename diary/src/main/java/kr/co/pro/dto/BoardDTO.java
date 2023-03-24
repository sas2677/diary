
package kr.co.pro.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	int bno;
	String title;
	String writer;
	String content;
	LocalDateTime regdate;
	
	//검색필터
	private String type;
	private String keyword;
}
