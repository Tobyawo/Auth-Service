package com.cs544.authservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role{

	private Integer id;

	private String name;

	private String description;

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}


	@Override
	public String toString() {
		return this.name;
	}


}
