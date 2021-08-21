package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.text.View;

import controller.ControllerMangaEmpl;

public class ViewMain {
	
public ViewMain(String title){
	
	
	
	ControllerMangaEmpl c= new ControllerMangaEmpl();
	ViewEmployeeManager viewEmMan= new ViewEmployeeManager("Quản lý nhân viên");
	JFrame frame = new JFrame(title);
	 JTextArea ta=new JTextArea(200,200);  
	    JPanel p1=new JPanel();  
	    p1.add(viewEmMan);
	    viewEmMan.getBtnAdd().addActionListener(e -> c.showPopupForm());
	    JPanel p2=new JPanel();  
	 JTabbedPane tp=new JTabbedPane();  
	    tp.setBounds(50,50,200,200);  
	    tp.add("Quản lý nhân viên",p1);  
	    tp.add("Quản lý sản phẩm",p2);  
	   
	    
	    
	    frame.add(tp);
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
}

}
