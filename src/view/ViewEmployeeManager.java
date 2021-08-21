package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerMangaEmpl;
import custom.StyledButtonUI;

public class ViewEmployeeManager extends JPanel{
	JButton btnAdd;
	JFrame frame;
	public ViewEmployeeManager(String title) {
		
		Icon icon = new ImageIcon(getClass(). getClassLoader(). getResource("images/iconAdd.png"));
		btnAdd = new JButton("Thêm nhân viên",icon);
		add(btnAdd);
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

}
