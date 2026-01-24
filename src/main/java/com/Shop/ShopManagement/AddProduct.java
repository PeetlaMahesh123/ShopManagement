package com.Shop.ShopManagement;

import javax.swing.*;
import java.awt.Color;

public class AddProduct extends JFrame {

    private JTextField txtName, txtPrice, txtDesc, txtCat, txtImg;

    public AddProduct() {
    	getContentPane().setBackground(new Color(192, 192, 192));

        setTitle("Add Product");
        setBounds(100,100,450,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        addLabel("Name",40);
        addLabel("Price",70);
        addLabel("Description",100);
        addLabel("Category",130);
        addLabel("Image URL",160);

        txtName  = addField(40);
        txtPrice = addField(70);
        txtDesc  = addField(100);
        txtCat   = addField(130);
        txtImg   = addField(160);

        JButton add = new JButton("Add Product");
        add.setBackground(new Color(128, 128, 192));
        add.setBounds(150,200,120,25);
        getContentPane().add(add);

        JButton back = new JButton("< back");
        back.setBackground(new Color(128, 128, 192));
        back.setBounds(300,230,100,25);
        getContentPane().add(back);

        // ✅ SAFE ADD PRODUCT
        add.addActionListener(e -> {
            try {
                String name = txtName.getText().trim();
                String priceTxt = txtPrice.getText().trim();

                if (name.isEmpty() || priceTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this, "Name and Price are required");
                    return;
                }

                double price = Double.parseDouble(priceTxt);

                Product p = new Product(
                    name,
                    price,
                    txtDesc.getText(),
                    txtCat.getText(),
                    txtImg.getText()
                );

                ProductDAO.addProduct(p);
                JOptionPane.showMessageDialog(this, "Product Added Successfully");

                // clear fields
                txtName.setText("");
                txtPrice.setText("");
                txtDesc.setText("");
                txtCat.setText("");
                txtImg.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Price must be a number (example: 45000)",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        back.addActionListener(e -> {
            new ProductOperations().setVisible(true);
            dispose();
        });
    }

    private void addLabel(String t,int y){
        JLabel l=new JLabel(t+":");
        l.setBounds(40,y,120,20);
        getContentPane().add(l);
    }

    private JTextField addField(int y){
        JTextField f=new JTextField();
        f.setBounds(180,y,150,20);
        getContentPane().add(f);
        return f;
    }
}
