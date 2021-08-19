package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ControllerMangaEmpl;
import custom.StyledButtonUI;

public class ViewEmployeeManager {
	JButton btnAdd;
	JFrame frame;
	public ViewEmployeeManager(String title) {
		JFrame frame = new JFrame(title);
		Icon icon = new ImageIcon(getClass(). getClassLoader(). getResource("images/iconAdd.png"));
		btnAdd = new JButton("Add",icon);
		frame.add(btnAdd);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

}
