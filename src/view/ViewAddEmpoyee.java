package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewAddEmpoyee {
	JLabel lblName, lblUserName, lblPassword, lblPasswordConfirm, lblPhoneNum,
	lblAddress;
JTextField txtName, txtUserName, txtPhoneNum, txtAdress;
JPasswordField txtPassword, txtPasswordConfirm;
JPanel pnName, pnUser, pnPassword, pnPasswordConfirm, pnAdress, pnPhone;
JPanel pnPopup;
int optionpane;
Dimension sizeLabel,sizeTextField;
public ViewAddEmpoyee(){
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

	sizeLabel = new Dimension(80, 30);
	sizeTextField = new Dimension(200, 30);
	Font font = new Font("Arial", Font.PLAIN, 17);
	pnName.add(lblName);
	pnName.add(txtName);
	lblName.setPreferredSize(sizeLabel);
	txtName.setPreferredSize(sizeTextField);
	txtName.setFont(font);
	

	pnUser.add(lblUserName);
	pnUser.add(txtUserName);
	lblUserName.setPreferredSize(sizeLabel);
	txtUserName.setPreferredSize(sizeTextField);
	txtUserName.setFont(font);
	
	pnPassword.add(lblPassword);
	pnPassword.add(txtPassword);
	lblPassword.setPreferredSize(sizeLabel);
	txtPassword.setPreferredSize(sizeTextField);
	txtPassword.setFont(font);
	
	pnPasswordConfirm.add(lblPasswordConfirm);
	pnPasswordConfirm.add(txtPasswordConfirm);
	lblPasswordConfirm.setPreferredSize(sizeLabel);
	txtPasswordConfirm.setPreferredSize(sizeTextField);
	txtPasswordConfirm.setFont(font);
	
	pnPhone.add(lblPhoneNum);
	pnPhone.add(txtPhoneNum);
	lblPhoneNum.setPreferredSize(sizeLabel);
	txtPhoneNum.setPreferredSize(sizeTextField);
	txtPhoneNum.setFont(font);
	
	pnAdress.add(lblAddress);
	pnAdress.add(txtAdress);
	lblAddress.setPreferredSize(sizeLabel);
	txtAdress.setPreferredSize(sizeTextField);
	txtAdress.setFont(font);
	
	pnPopup.add(pnName);
	pnPopup.add(pnUser);
	pnPopup.add(pnPassword);
	pnPopup.add(pnPasswordConfirm);
	pnPopup.add(pnAdress);
	pnPopup.add(pnPhone);
	optionpane= JOptionPane.showOptionDialog(null, pnPopup, "Thêm nhân viên",
			JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
			new String[] { "Lưu", "Hủy" }, "default");
	
}
public int option(){
	return optionpane;
}

public JTextField getTxtAdress() {
	return txtAdress;
}
public void setTxtAdress(String txtAdress) {
	this.txtAdress.setText(txtAdress);
}
public JTextField getTxtName() {
	return txtName;
}
public void setTxtName(String txtName) {
	this.txtName.setText(txtName);
}
public JTextField getTxtUserName() {
	return txtUserName;
}
public void setTxtUserName(String txtUserName) {
	this.txtUserName.setText(txtUserName);
}
public JTextField getTxtPhoneNum() {
	return txtPhoneNum;
}
public void setTxtPhoneNum(String txtPhoneNum) {
	this.txtPhoneNum.setText(txtPhoneNum);
}
public JPasswordField getTxtPassword() {
	return txtPassword;
}
public void setTxtPassword(String txtPassword) {
	this.txtPassword.setText(txtPassword);;
}
public JPasswordField getTxtPasswordConfirm() {
	return txtPasswordConfirm;
}
public void setTxtPasswordConfirm(String txtPasswordConfirm) {
	this.txtPasswordConfirm.setText(txtPasswordConfirm); ;
}

}
