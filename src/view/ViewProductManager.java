package view;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerMangaEmpl;
import custom.StyledButtonUI;

public class ViewProductManager extends JPanel{
    JButton btnAdd;
    JFrame frame;

    public ViewProductManager() {
        Icon icon = new ImageIcon(getClass(). getClassLoader(). getResource("images/iconAdd.png"));
        btnAdd = new JButton("Thêm sản phẩm",icon);
        add(btnAdd);
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

}