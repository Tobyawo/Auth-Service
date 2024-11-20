package com.cs544.authservice.entity.response;

import com.cs544.authservice.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class UserResponse implements Serializable {

	private static final long serialVersionUID = -1487747275533464940L;
	private Integer code;
	private String description;
	@Setter
    @Getter
    private User user;


	public UserResponse() {
	}


    @Override
	public String toString() {
		return "UserResponse{" +
				"code=" + code +
				", description='" + description + '\'' +
				", user=" + user +
				'}';
	}
}
