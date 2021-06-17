package loginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
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
		placeComponents();
	}

	public static void main(String[] args) {
		new LoginForm();
	}

	public void placeComponents() {
		mainFrame = new JFrame("Login");
		mainFrame.setLayout(null);
		mainFrame.setSize(300, 150);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

		unameLab = new JLabel("Username");
		unameLab.setBounds(10, 10, 80, 25);
		mainFrame.add(unameLab);

		unameTxt = new JTextField(20);
		unameTxt.setBounds(100, 10, 160, 25);
		mainFrame.add(unameTxt);

		passLab = new JLabel("Password");
		passLab.setBounds(10, 40, 80, 25);
		mainFrame.add(passLab);

		passTxt = new JPasswordField(20);
		passTxt.setBounds(100, 40, 160, 25);
		mainFrame.add(passTxt);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(100, 80, 80, 25);
		loginButton.addActionListener(new LoginListner());
		mainFrame.add(loginButton);
	}

	class LoginListner implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String uname = unameTxt.getText();
			char[] pass = passTxt.getPassword();
			if ((LoginInputValidation.isUnameValid(uname)) && (LoginInputValidation.isPassValid(pass))) {
				System.out.println("abc");
			} else {
				JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không hợp lệ");
			}
		}
	}
}
