package ru.perm.v;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageJSON0 {
	@JsonProperty
	private Integer id=0;

	@JsonProperty
	private String name="";

	public MessageJSON0() {
	}

	public MessageJSON0(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MessageJSON0{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

}
