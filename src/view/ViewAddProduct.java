package view;

import dao.ProductDAO;
import model.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewAddProduct extends JFrame implements ActionListener {
	private JTextField tfId, tfNamePro, tfPhoneNum, tfPrice, tfQuantity, tfBrand, tfDescriptions, tfResult;
	private JButton btAdd;
	private JTextArea taDes;
	private JTable tbInfor;
	private JOptionPane jPane;

//    private ViewAddProduct jFrame = new ViewAddProduct();
	public ViewAddProduct() {
		super("ViewAddProduct");
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new GridLayout(7, 2));
		p1.add(new JLabel("Id"));
		p1.add(tfId = new JTextField(10));
		p1.add(new JLabel("Tên sản phẩm:"));
		p1.add(tfNamePro = new JTextField(10));
		p1.add(new JLabel("Giá:"));
		p1.add(tfPrice = new JTextField(10));
		p1.add(new JLabel("Số lượng:"));
		p1.add(tfQuantity = new JTextField(10));
		p1.add(new JLabel("Thương hiệu:"));
		p1.add(tfBrand = new JTextField(10));
		p1.add(new JLabel("Mô tả:"));
		p1.add(tfDescriptions = new JTextField(10));
		add(p1, BorderLayout.NORTH);

		JPanel p2 = new JPanel(new GridLayout(2, 1));
		p2.add(btAdd = new JButton("Thêm sản phẩm"));
		p2.add(tfResult = new JTextField(10));
		add(p2, BorderLayout.CENTER);
		tfResult.setEditable(false);
		tfResult.setForeground(Color.red);
		btAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if (tfId.getText().equals("") || tfNamePro.getText().equals("") || tfPrice.getText().equals("") || tfQuantity.getText().equals("")
					|| tfBrand.getText().equals("") || tfDescriptions.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui long nhap day du thong tin");

			} else {
				int id = Integer.parseInt(tfId.getText());
				String namePro = tfNamePro.getText();
				double price = Double.parseDouble(tfPrice.getText());
				int quantity = Integer.parseInt(tfQuantity.getText());
				String branch = tfBrand.getText();
				String descriptions = tfDescriptions.getText();
				Product pro = new Product(id, namePro, price, quantity, branch, descriptions);
				ProductDAO pd = new ProductDAO();
				Boolean check = pd.insert(pro);
				if (check == true) {
					tfBrand.setText("");
					tfId.setText("");
					tfNamePro.setText("");
					tfPrice.setText("");
					tfQuantity.setText("");
					tfDescriptions.setText("");
					JOptionPane.showMessageDialog(null, "Them thanh cong");

				}

				pd.view();
			}
			}
		});

	}

//    public void setNewText(JTextField tf, String text) {
//    	tf.setText(text);
//   	
//    }

	public static void main(String[] args) {
		ViewAddProduct frame = new ViewAddProduct();
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			int id = Integer.parseInt(tfId.getText());
			String namePro = tfNamePro.getText();
			double price = Double.parseDouble(tfPrice.getText());
			int quantity = Integer.parseInt(tfQuantity.getText());
			String branch = tfBrand.getText();
			String descriptions = tfDescriptions.getText();
//			if (tfNamePro.getText().equals("") || tfPrice.getText().equals("") || tfQuantity.getText().equals("")
//					|| tfBrand.getText().equals("") || tfDescriptions.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, "Vui long nhap day du thong tin");
//
//			} else {
//				Product pro = new Product(id, namePro, price, quantity, branch, descriptions);
//				ProductDAO pd = new ProductDAO();
//				Boolean check = pd.insert(pro);
//				if (check == true) {
//					tfBrand.setText("");
//					tfId.setText("");
//					tfNamePro.setText("");
//					tfPrice.setText("");
//					tfQuantity.setText("");
//					tfDescriptions.setText("");
//
//				}
//
//				pd.view();
//			}

		}
	}
}
