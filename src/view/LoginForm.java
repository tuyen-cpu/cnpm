package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.LoginController;

public class LoginForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel unameLab, passLab;
	private JTextField unameTxt;
	private JPasswordField passTxt;
	private JButton loginBtn;

	public JLabel getUnameLab() {
		return unameLab;
	}

	public void setUnameLab(JLabel unameLab) {
		this.unameLab = unameLab;
	}

	public JLabel getPassLab() {
		return passLab;
	}

	public void setPassLab(JLabel passLab) {
		this.passLab = passLab;
	}

	public JTextField getUnameTxt() {
		return unameTxt;
	}

	public void setUnameTxt(JTextField unameTxt) {
		this.unameTxt = unameTxt;
	}

	public JPasswordField getPassTxt() {
		return passTxt;
	}

	public void setPassTxt(JPasswordField passTxt) {
		this.passTxt = passTxt;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Constructor
	public LoginForm() {
		JFrame mainFrame = new JFrame("Login");
		mainFrame.setSize(300, 150);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		mainFrame.add(panel);
		placeComponents(panel);
		
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginForm();
	}

	public void placeComponents(JPanel pane) {
		
		pane.setLayout(null);
		
		unameLab = new JLabel("Username");
		unameLab.setBounds(10, 10, 80, 25);
		pane.add(unameLab);

		unameTxt = new JTextField(20);
		unameTxt.setBounds(100, 10, 160, 25);
		pane.add(unameTxt);

		passLab = new JLabel("Password");
		passLab.setBounds(10, 40, 80, 25);
		pane.add(passLab);

		passTxt = new JPasswordField(20);
		passTxt.setBounds(100, 40, 160, 25);
		pane.add(passTxt);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(100, 80, 80, 25);
		loginButton.addActionListener(new LoginListner());
		pane.add(loginButton);
	}

	class LoginListner implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String uname = unameTxt.getText();
			char[] pass = passTxt.getPassword();
			if ((LoginInputValidation.isUnameValid(uname)) && 
					(LoginInputValidation.isPassValid(pass))) {
				String passwd = new String(pass);
				if (LoginController.findAccount(uname)) {
					if (LoginController.checkPassword(uname, passwd)) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
				}	
			} else {
				JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không hợp lệ");
			}
		}
	}
}
