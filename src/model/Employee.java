package model;

public class Employee {
private int id;
	private String name;
	private String phoneNum;
	private String address;
	public Employee( String name, String phoneNum, String address) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
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
@Override
	public String toString() {
		
		return name+"//"+phoneNum+"//"+address;
	}
}
