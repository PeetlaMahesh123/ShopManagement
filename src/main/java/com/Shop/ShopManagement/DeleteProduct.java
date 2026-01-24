package com.Shop.ShopManagement;

import javax.swing.*;
import java.awt.Color;

public class DeleteProduct extends JFrame {

    public DeleteProduct() {
    	getContentPane().setBackground(new Color(192, 192, 192));

        setTitle("Delete Product");
        setBounds(100,100,400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel l = new JLabel("Product ID:");
        l.setBounds(60,80,100,20);
        getContentPane().add(l);

        JTextField id = new JTextField();
        id.setBounds(160,80,120,20);
        getContentPane().add(id);

        JButton del = new JButton("Delete");
        del.setBackground(new Color(128, 128, 192));
        del.setBounds(140,130,100,25);
        getContentPane().add(del);

        JButton back = new JButton("< back");
        back.setBackground(new Color(128, 128, 192));
        back.setBounds(260,180,100,25);
        getContentPane().add(back);

        del.addActionListener(e -> {
            ProductDAO.deleteProduct(
                Integer.parseInt(id.getText())
            );
            JOptionPane.showMessageDialog(this,"Product Deleted");
        });

        back.addActionListener(e -> {
            new ProductOperations().setVisible(true);
            dispose();
        });
    }
}
