package controller;

import dao.AccountDAO;
import view.ViewAddEmpoyee;

public class LoginController {
	
	public static boolean findAccount(String uname, String pass) {
		if (AccountDAO.findAcc(uname, pass)) return true;
		return false;
	}
	
	public static void direct() {
		new ViewAddEmpoyee();
	}
}
