package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProductOperations extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ProductOperations().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ProductOperations() {
        setTitle("Product Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lbl = new JLabel("Product Operations");
        lbl.setBounds(160, 30, 150, 20);
        contentPane.add(lbl);

        JButton btnAdd = new JButton("Add Product");
        btnAdd.setBounds(40, 90, 130, 25);
        contentPane.add(btnAdd);

        JButton btnDisplay = new JButton("Display Product");
        btnDisplay.setBounds(250, 90, 130, 25);
        contentPane.add(btnDisplay);

        JButton btnUpdate = new JButton("Update Product");
        btnUpdate.setBounds(40, 160, 130, 25);
        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete Product");
        btnDelete.setBounds(250, 160, 130, 25);
        contentPane.add(btnDelete);

        JButton btnBack = new JButton("< back");
        btnBack.setBounds(320, 220, 90, 25);
        contentPane.add(btnBack);

        // Navigation
        btnAdd.addActionListener(e -> {
            new AddProduct().setVisible(true);
            dispose();
        });

        btnDisplay.addActionListener(e -> {
            new DisplayProduct().setVisible(true);
            dispose();
        });

        btnUpdate.addActionListener(e -> {
            new UpdateProduct().setVisible(true);
            dispose();
        });

        btnDelete.addActionListener(e -> {
            new DeleteProduct().setVisible(true);
            dispose();
        });

        // 🔙 BACK → LOGIN (PRODUCT FLOW)
        btnBack.addActionListener(e -> {
            new LoginFrame(true).setVisible(true);
            dispose();
        });
    }
}
