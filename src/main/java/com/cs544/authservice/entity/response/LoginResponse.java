package com.cs544.authservice.entity.response;


import com.cs544.authservice.ResponseCodeEnum;
import com.cs544.authservice.entity.request.LoggedInUser;
import lombok.Data;


@Data
public class LoginResponse extends ResponseData {


	private LoggedInUser loggedInUser;
	private String token;


	public LoginResponse(ResponseCodeEnum code, String description){
		setCode(code.getCode());
		setDescription(description);
	}



}
