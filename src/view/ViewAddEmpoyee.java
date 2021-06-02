package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Employee;
import controller.ControllerMangaEmpl;

public class ViewAddEmpoyee {
	JLabel lblName, lblUserName, lblPassword, lblPasswordConfirm, lblPhoneNum,
			lblAddress;
	JTextField txtName, txtUserName, txtPhoneNum, txtAdress;
	JPasswordField txtPassword, txtPasswordConfirm;
	JPanel pnName, pnUser, pnPassword, pnPasswordConfirm, pnAdress, pnPhone;
	JPanel pnPopup;
	int btnSave, btnCancel;

	public ViewAddEmpoyee() {
		initControls();
		checkOptionPopupAddEmployee();

	}

	public void initControls() {
		pnPopup = new JPanel(new GridLayout(0, 1));
		pnName = new JPanel();
		pnUser = new JPanel();
		pnPassword = new JPanel();
		pnPasswordConfirm = new JPanel();
		pnPhone = new JPanel();
		pnAdress = new JPanel();
		lblName = new JLabel("Tên:");
		txtName = new JTextField();
		lblUserName = new JLabel("Tên tài khoản:");
		txtUserName = new JTextField();
		lblPassword = new JLabel("Mật khẩu:");
		txtPassword = new JPasswordField();
		lblPasswordConfirm = new JLabel("Xác nhận MK:");
		txtPasswordConfirm = new JPasswordField();
		lblPhoneNum = new JLabel("SĐT: ");
		txtPhoneNum = new JTextField();
		lblAddress = new JLabel("Địa chỉ");
		txtAdress = new JTextField();

		pnName.add(lblName);
		pnName.add(txtName);
		lblName.setPreferredSize(new Dimension(80, 20));
		txtName.setPreferredSize(new Dimension(200, 20));
		pnName.setLayout(new FlowLayout());
		pnUser.add(lblUserName);
		pnUser.add(txtUserName);
		lblUserName.setPreferredSize(new Dimension(80, 20));
		txtUserName.setPreferredSize(new Dimension(200, 20));
		pnPassword.add(lblPassword);
		pnPassword.add(txtPassword);
		lblPassword.setPreferredSize(new Dimension(80, 20));
		txtPassword.setPreferredSize(new Dimension(200, 20));
		pnPasswordConfirm.add(lblPasswordConfirm);
		pnPasswordConfirm.add(txtPasswordConfirm);
		lblPasswordConfirm.setPreferredSize(new Dimension(80, 20));
		txtPasswordConfirm.setPreferredSize(new Dimension(200, 20));
		pnPhone.add(lblPhoneNum);
		pnPhone.add(txtPhoneNum);
		lblPhoneNum.setPreferredSize(new Dimension(80, 20));
		txtPhoneNum.setPreferredSize(new Dimension(200, 20));
		pnAdress.add(lblAddress);
		pnAdress.add(txtAdress);
		lblAddress.setPreferredSize(new Dimension(80, 20));
		txtAdress.setPreferredSize(new Dimension(200, 20));
		pnPopup.add(pnName);
		pnPopup.add(pnUser);
		pnPopup.add(pnPassword);
		pnPopup.add(pnPasswordConfirm);
		pnPopup.add(pnAdress);
		pnPopup.add(pnPhone);
	}

	public int showForm() {
		return JOptionPane.showOptionDialog(null, pnPopup, "Thêm nhân viên",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
				new String[] { "Lưu", "Hủy" }, "default");
	}

	public void checkOptionPopupAddEmployee() {
		int result = showForm();
		if (result == JOptionPane.OK_OPTION) {
			checkInput();

			String name = txtName.getText();
			String phoneNum = txtPhoneNum.getText();
			String address = txtAdress.getText();
			Employee e = new Employee(name, phoneNum, address);
			System.out.println(e.toString());

		} else {
			System.out.println("Cancelled");
		}
	}

	public void checkInput() {
		if (txtName.getText().equals("") || txtUserName.getText().equals("")
				|| String.valueOf(txtPassword.getPassword()).equals("")
				|| String.valueOf(txtPasswordConfirm.getPassword()).equals("")) {
			JPanel t = new JPanel();
			t.add(new JButton("s"));
			JOptionPane.showMessageDialog(t, "Vui lòng nhập đủ thông tin",
					"Thông báo", JOptionPane.ERROR_MESSAGE);
			checkOptionPopupAddEmployee();
		}
	}
}
