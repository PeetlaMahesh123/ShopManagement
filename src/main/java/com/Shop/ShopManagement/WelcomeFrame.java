package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class WelcomeFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new WelcomeFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public WelcomeFrame() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lbl = new JLabel("Welcome to Shop");
        lbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl.setBounds(164, 37, 150, 25);
        contentPane.add(lbl);

        JButton btnUser = new JButton("User Management");
        btnUser.setBackground(new Color(128, 128, 255));
        btnUser.setBounds(50, 120, 150, 25);
        contentPane.add(btnUser);

        JButton btnProduct = new JButton("Product Management");
        btnProduct.setBackground(new Color(128, 128, 255));
        btnProduct.setBounds(230, 120, 170, 25);
        contentPane.add(btnProduct);

        // USER MANAGEMENT → LOGIN
        btnUser.addActionListener(e -> {
            new LoginFrame(false).setVisible(true);
            dispose();
        });

        // PRODUCT MANAGEMENT → LOGIN
        btnProduct.addActionListener(e -> {
            new LoginFrame(true).setVisible(true);
            dispose();
        });
    }
}
