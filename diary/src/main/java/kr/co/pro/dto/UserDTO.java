package kr.co.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

		int num;
		String id;
		String password;
		String nickname;
		String userRole;
}
