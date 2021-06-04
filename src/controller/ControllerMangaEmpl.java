package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.AccountDAO;
import dao.EmployeeDAO;
import view.ViewAddEmpoyee;
import view.ViewEmployeeManager;
import model.Account;
import model.Employee;

public class ControllerMangaEmpl {
	ViewEmployeeManager viewEmployeeManager;
	ViewAddEmpoyee viewAddEmpoyee;
	EmployeeDAO employeeDAO;
AccountDAO accountDAO;
	public ControllerMangaEmpl() {
		viewEmployeeManager = new ViewEmployeeManager("Quản lý nhân viên");
		viewEmployeeManager.getBtnAdd().addActionListener(e -> showPopupForm());

	}

	public void showPopupForm() {

		viewAddEmpoyee = new ViewAddEmpoyee();
		if (viewAddEmpoyee.option() == JOptionPane.OK_OPTION) {
			if(checkInput()){
			addEmployee();}
		}
	}
public void addEmployee(){
	Account account = new Account(viewAddEmpoyee.getTxtUserName().getText(),
			String.valueOf(
					viewAddEmpoyee.getTxtPasswordConfirm().getPassword()),1);
	accountDAO = new AccountDAO();
	accountDAO.insert(account);
	Employee e = new Employee(viewAddEmpoyee.getTxtName().getText(),
			viewAddEmpoyee.getTxtPhoneNum().getText(), viewAddEmpoyee
					.getTxtAdress().getText(),viewAddEmpoyee.getTxtUserName().getText());
	employeeDAO = new EmployeeDAO();
	employeeDAO.insert(e);
}
	public boolean checkInput() {
		if (viewAddEmpoyee.getTxtName().getText().equals("")
				|| viewAddEmpoyee.getTxtUserName().getText().equals("")
				|| String
						.valueOf(viewAddEmpoyee.getTxtPassword().getPassword())
						.equals("")
				|| String.valueOf(
						viewAddEmpoyee.getTxtPasswordConfirm().getPassword())
						.equals("")) {

			JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin",
					"Thông báo", JOptionPane.ERROR_MESSAGE);
			showPopupForm();
			return false;
		}
		if (!String.valueOf(viewAddEmpoyee.getTxtPassword().getPassword())
				.equals(String.valueOf(viewAddEmpoyee.getTxtPasswordConfirm()
						.getPassword()))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không khớp",
					"Thông báo", JOptionPane.ERROR_MESSAGE);
			showPopupForm();
			return false;
		}
		return true;
	}
}
