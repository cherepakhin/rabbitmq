package ru.perm.v;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageJSON1 {
	@JsonProperty
	private Integer id1=0;

	@JsonProperty
	private String name1="";

	public MessageJSON1() {
	}

	public MessageJSON1(Integer id, String name) {
		this.id1 = id;
		this.name1 = name;
	}

	public Integer getId1() {
		return id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	@Override
	public String toString() {
		return "MessageJSON1{" +
				"id1=" + id1 +
				", name1='" + name1 + '\'' +
				'}';
	}

}
