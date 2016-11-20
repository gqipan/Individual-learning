package org.pan.springmvc.entities;

public class User
{
	 private Integer id;
	 private String userName;
	 private String passWord;
	 private int   	age;
	 private String email;
	 
	 public User(){}

	public User(Integer id, String userName, String passWord, int age,
			String email)
	{
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.age = age;
		this.email = email;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", userName=" + userName + ", passWord="
				+ passWord + ", age=" + age + ", email=" + email + "]";
	}
	 
	 
	 
}
