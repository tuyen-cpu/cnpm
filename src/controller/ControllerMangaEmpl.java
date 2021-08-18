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
	String txtNameTemp,txtUserNameTemp,txtAddressTemp,txtPhoneTemp;
	ViewEmployeeManager viewEmployeeManager;
	ViewAddEmpoyee viewAddEmpoyee;
	EmployeeDAO employeeDAO;
	AccountDAO accountDAO;
	String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,10}";
	public ControllerMangaEmpl() {
		this.txtNameTemp="khoitao";
		this.txtUserNameTemp="khoitao";
		this.txtAddressTemp="khoitao";
		this.txtPhoneTemp="khoitao";
		viewEmployeeManager = new ViewEmployeeManager("Quản lý nhân viên");
		viewEmployeeManager.getBtnAdd().addActionListener(e -> showPopupForm());

	}

	public void showPopupForm() {
		
		viewAddEmpoyee = new ViewAddEmpoyee();
		
		if (viewAddEmpoyee.option() == JOptionPane.OK_OPTION) {
			if(checkInput()){
			if(addEmployee()==true){
				showMessageDilogSuccess("Thêm thành công");
			}else{
				showMessageDilogError("Trùng tên đăng nhập");
			}
			}
			
			
		}
	}
public boolean addEmployee(){
	Account account = new Account(viewAddEmpoyee.getTxtUserName().getText(),
			String.valueOf(
					viewAddEmpoyee.getTxtPasswordConfirm().getPassword()),1);
	accountDAO = new AccountDAO();
	if(accountDAO.insert(account)==true){
		
		System.out.println("them xong account");
	}else{
		System.out.println("lỗi account");
		return false;
	}
		
		
	
	Employee e = new Employee(viewAddEmpoyee.getTxtName().getText(),
			viewAddEmpoyee.getTxtPhoneNum().getText(), viewAddEmpoyee
					.getTxtAdress().getText(),viewAddEmpoyee.getTxtUserName().getText());
	employeeDAO = new EmployeeDAO();
	
		
		if(employeeDAO.insert(e)==true){
			System.out.println("them ok employ");
		}else{
			System.out.println("lỗi");
			return false;
		}
	
return true;
	
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
			this.txtNameTemp=viewAddEmpoyee.getTxtName().getText();
			
			this.showMessageDilogError("Vui lòng nhập đủ thông tin");
			showPopupForm();
			return false;
		}
		if (!String.valueOf(viewAddEmpoyee.getTxtPassword().getPassword())
				.equals(String.valueOf(viewAddEmpoyee.getTxtPasswordConfirm()
						.getPassword()))) {
			this.showMessageDilogError("Mật khẩu không khớp");
			showPopupForm();
			return false;
		}
		if(String.valueOf(viewAddEmpoyee.getTxtPassword().getPassword()).matches(pattern)==false){
			this.showMessageDilogError("Tối thiểu tám và tối đa 10 ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một số và một ký tự đặc biệt:");
			showPopupForm();
			return false;
		}
		
		return true;
	}
	public void showMessageDilogError(String error){
		JOptionPane.showMessageDialog(null, error,
				"Thông báo", JOptionPane.ERROR_MESSAGE);
	}
	public void showMessageDilogSuccess(String error){
		JOptionPane.showMessageDialog(null, error,
				"Thông báo", JOptionPane.OK_OPTION);
	}
}
