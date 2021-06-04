package model;

public class Employee {
	private int id;
	private String name;
	private String phoneNum;
	private String address;
	private String userName;
	public Employee( String name, String phoneNum, String address,String userName) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.userName= userName;
	}
	public Employee(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
@Override
	public String toString() {
		
		return name+"//"+phoneNum+"//"+address;
	}
}
