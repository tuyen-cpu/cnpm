package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ControllerMangaEmpl;

public class ViewEmployeeManager {
	JButton btnAdd;
	JFrame frame;
	public ViewEmployeeManager(String title) {
		JFrame frame = new JFrame(title);
		btnAdd = new JButton("add");
		frame.add(btnAdd);
		frame.setSize(1920, 1080);
		frame.setLayout(new FlowLayout());
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
