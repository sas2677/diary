package kr.co.pro.Entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	int bno;
	String title;
	String writer;
	String content;
	LocalDateTime regdate;
	 
	//검색필터
	private String type;
	private String keyword;
}
