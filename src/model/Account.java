package model;

public class Account {
private int idEmployee;
private String userName;
private String password;
private int role;
public Account(int idEmployee, String userName, String password, int role) {
	super();
	this.idEmployee = idEmployee;
	this.userName = userName;
	this.password = password;
	this.role = role;
}
public Account(){
	
}
public int getIdEmployee() {
	return idEmployee;
}
public void setIdEmployee(int idEmployee) {
	this.idEmployee = idEmployee;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}

}
