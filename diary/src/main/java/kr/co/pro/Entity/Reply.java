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
public class Reply {

	int rno;
	String user;
	LocalDateTime redate;
	String rebody;
	int bno;
}
