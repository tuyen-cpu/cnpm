package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ViewAddEmpoyee;
import view.ViewEmployeeManager;
import view.view;
import model.Employee;

public class ControllerMangaEmpl {
	ViewEmployeeManager viewEmployeeManager;
	view v;

	public ControllerMangaEmpl( ) {
		viewEmployeeManager =new ViewEmployeeManager("x");
		viewEmployeeManager.getBtnAdd().addActionListener(e -> showPopupForm());
	}

	public void showPopupForm() {
		System.out.println("xx");
		v = new view();
		if(v.option()==JOptionPane.OK_OPTION){
			System.out.println(".");
		}
	}
}
