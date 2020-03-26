package examplefx.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -8125318939878993641L;
	
	private String username;
	private String fullName;
	private int age;
	
	
	public User(String name, String fullName, int age) {
		this.username = name;
		this.age = age;
		this.fullName = fullName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return String.format("User [username=%s, fullName=%s, age=%s]", username, fullName, age);
	}
	
	
}
