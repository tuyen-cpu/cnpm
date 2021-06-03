package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.ViewAddEmpoyee;
import view.ViewEmployeeManager;

import model.Employee;

public class ControllerMangaEmpl {
	ViewEmployeeManager viewEmployeeManager;
	ViewAddEmpoyee viewAddEmpoyee;

	public ControllerMangaEmpl() {
		viewEmployeeManager = new ViewEmployeeManager("Quản lý nhân viên");
		viewEmployeeManager.getBtnAdd().addActionListener(e -> showPopupForm());

	}

	public void showPopupForm() {
		
		viewAddEmpoyee = new ViewAddEmpoyee();
		if (viewAddEmpoyee.option() == JOptionPane.OK_OPTION) {
			checkInput();
		}
	}

	public void checkInput() {
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
		}
		if (!String.valueOf(viewAddEmpoyee.getTxtPassword().getPassword())
				.equals(String.valueOf(viewAddEmpoyee.getTxtPasswordConfirm()
						.getPassword()))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không khớp",
					"Thông báo", JOptionPane.ERROR_MESSAGE);
			showPopupForm();
		}
	}
}
