package view;

import dao.ProductDAO;
import model.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ViewAddProduct extends JFrame implements ActionListener {
    private JTextField tfId, tfNamePro, tfPhoneNum, tfPrice, tfQuantity, tfBranch, tfDescriptions;
    private JButton btAdd;
    private JTextArea taDes;
    private JTable tbInfor;

    public ViewAddProduct(){
        super("ViewAddProduct");
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(6,2));
        p1.add(new JLabel("Id"));
        p1.add(tfId = new JTextField(10));
        p1.add(new JLabel("Tên sản phẩm:"));
        p1.add(tfNamePro = new JTextField(10));
        p1.add(new JLabel("Giá:"));
        p1.add(tfPrice = new JTextField(10));
        p1.add(new JLabel("Số lượng:"));
        p1.add(tfQuantity = new JTextField(10));
        p1.add(new JLabel("Thương hiệu:"));
        p1.add(tfBranch = new JTextField(10));
        p1.add(new JLabel("Mô tả:"));
        p1.add(tfDescriptions = new JTextField(10));
        add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(btAdd = new JButton("Thêm sản phẩm"));
        add(p2, BorderLayout.CENTER);
        btAdd.addActionListener(this);
        
       
    }
    
    public void setColor(Component c) {
   
    	
    }



    public static void main(String[] args) {
        ViewAddProduct frame = new ViewAddProduct();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btAdd){
        	int id = Integer.parseInt(tfId.getText());
            String namePro = tfNamePro.getText();
            double price = Double.parseDouble(tfPrice.getText());
            int quantity = Integer.parseInt(tfQuantity.getText());
            String branch = tfBranch.getText();
            String descriptions = tfDescriptions.getText();
            
            Product pro = new Product(id, namePro, price, quantity, branch, descriptions);
            ProductDAO pd = new ProductDAO();
            pd.insert(pro);
            pd.view();

        }
    }
}

