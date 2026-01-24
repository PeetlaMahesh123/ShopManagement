package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Color;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUser;
    private JTextField txtPass;

    private boolean productFlow; // true → ProductOperations

    public LoginFrame(boolean productFlow) {
        this.productFlow = productFlow;

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblUser = new JLabel("Enter Username:");
        lblUser.setBounds(60, 85, 120, 20);
        contentPane.add(lblUser);

        JLabel lblPass = new JLabel("Enter Password:");
        lblPass.setBounds(60, 130, 120, 20);
        contentPane.add(lblPass);

        txtUser = new JTextField();
        txtUser.setBounds(190, 85, 120, 20);
        contentPane.add(txtUser);

        txtPass = new JTextField();
        txtPass.setBounds(190, 130, 120, 20);
        contentPane.add(txtPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(128, 128, 192));
        btnLogin.setBounds(150, 180, 100, 25);
        contentPane.add(btnLogin);

        JButton btnBack = new JButton("< back");
        btnBack.setBackground(new Color(128, 128, 192));
        btnBack.setBounds(320, 220, 90, 25);
        contentPane.add(btnBack);

        // 🔐 ADMIN LOGIN CHECK
        btnLogin.addActionListener(e -> {

            String username = txtUser.getText();
            String password = txtPass.getText();

            if (username == null || username.trim().isEmpty()
                    || password == null || password.trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please enter username and password");
                return;
            }

            boolean isAdmin =
                    UserDAO.validateAdmin(username, password);

            if (isAdmin) {
                JOptionPane.showMessageDialog(this,
                        "Admin Login Successful");

                if (productFlow) {
                    new ProductOperations().setVisible(true);
                } else {
                    new UserOperations().setVisible(true);
                }

                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Only ADMIN can login",
                        "Access Denied",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ⬅ BACK
        btnBack.addActionListener(e -> {
            new WelcomeFrame().setVisible(true);
            dispose();
        });
    }
}
