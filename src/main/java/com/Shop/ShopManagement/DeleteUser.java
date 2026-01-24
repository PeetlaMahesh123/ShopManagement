package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class DeleteUser extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new DeleteUser().setVisible(true));
    }

    public DeleteUser() {
        setTitle("Delete User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 220);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lbl = new JLabel("User ID:");
        lbl.setBounds(70, 70, 100, 20);
        contentPane.add(lbl);

        txtId = new JTextField();
        txtId.setBounds(150, 70, 120, 20);
        contentPane.add(txtId);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(128, 128, 192));
        btnDelete.setBounds(140, 120, 100, 25);
        contentPane.add(btnDelete);

        JButton btnBack = new JButton("< Back");
        btnBack.setBackground(new Color(128, 128, 192));
        btnBack.setBounds(260, 160, 100, 25);
        contentPane.add(btnBack);

        btnDelete.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                UserDAO.deleteUser(id);
                JOptionPane.showMessageDialog(this, "User Deleted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID");
            }
        });

        btnBack.addActionListener(e -> {
            new UserOperations().setVisible(true);
            dispose();
        });
    }
}
