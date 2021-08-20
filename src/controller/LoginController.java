package controller;

import dao.AccountDAO;
import view.ViewAddEmpoyee;

public class LoginController {
	
	public static boolean findAccount(String uname) {
		if (AccountDAO.findAcc(uname)) return true;
		return false;
	}
	
	public static boolean checkPassword(String uname, String pass) {
		if (AccountDAO.checkPassword(uname, pass)) return true;
		return false;
	}
}
