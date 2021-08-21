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
	String regexUserName="^[a-z0-9._-]{3,15}$";
	String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,10}";
	public ControllerMangaEmpl() {
		viewEmployeeManager = new ViewEmployeeManager("Quản lý nhân viên");
		viewEmployeeManager.getBtnAdd().addActionListener(e -> showPopupForm());

	}

	public void showPopupForm() {
		viewAddEmpoyee = new ViewAddEmpoyee();
		if (viewAddEmpoyee.option() == JOptionPane.OK_OPTION) {
			if(checkInput()){
			if(addEmployee()==true){
				showMessageDilogSuccess("Thêm nhân viên thành công!");
			}else{
				showMessageDilogError("Trùng tên đăng nhập!");
			}
			}
			
			
		}
	}
public boolean addEmployee(){
	Account account = new Account(viewAddEmpoyee.getTxtUserName().getText().trim(),
			String.valueOf(
					viewAddEmpoyee.getTxtPasswordConfirm().getPassword()).trim(),1);
	accountDAO = new AccountDAO();
	if(accountDAO.insert(account)==true){
	}else{
		return false;
	}
		
	Employee e = new Employee(viewAddEmpoyee.getTxtName().getText(),
			viewAddEmpoyee.getTxtPhoneNum().getText(), viewAddEmpoyee
					.getTxtAdress().getText(),viewAddEmpoyee.getTxtUserName().getText().trim());
	employeeDAO = new EmployeeDAO();
	
		
		if(employeeDAO.insert(e)==true){
		}else{
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
		if(viewAddEmpoyee.getTxtUserName().getText().matches(regexUserName)==false){
			this.showMessageDilogError("Tên đăng nhập phải tối thiểu 3 và tối đa 15 kí tự bao gồm các kí tự từ a-z các chữ số 0 - 9 và một số kí tự đặc biệt: . - _");
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
			this.showMessageDilogError("Mật khẩu tối thiểu tám và tối đa mười ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một số và một ký tự đặc biệt:");
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
		JOptionPane.showMessageDialog(null, error
				);
	}
}
