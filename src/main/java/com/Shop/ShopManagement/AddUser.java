package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class AddUser extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtName, txtPass, txtAge, txtRole;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new AddUser().setVisible(true));
    }

    public AddUser() {
        setTitle("Add User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        addLabel("Username", 60);
        addLabel("Password", 90);
        addLabel("Age", 120);
        addLabel("Role (ADMIN / USER)", 150);

        txtName = addField(60);
        txtPass = addField(90);
        txtAge = addField(120);
        txtRole = addField(150);

        JButton btnAdd = new JButton("Add User");
        btnAdd.setBackground(new Color(128, 128, 192));
        btnAdd.setBounds(150, 190, 120, 25);
        contentPane.add(btnAdd);

        JButton btnBack = new JButton("< Back");
        btnBack.setBackground(new Color(128, 128, 192));
        btnBack.setBounds(300, 220, 100, 25);
        contentPane.add(btnBack);

        // ✅ ADD USER (DB)
        btnAdd.addActionListener(e -> {
            try {
                User user = new User(
                        txtName.getText(),
                        txtPass.getText(),
                        Integer.parseInt(txtAge.getText()),
                        Role.valueOf(txtRole.getText().toUpperCase())
                );

                UserDAO.addUser(user);
                JOptionPane.showMessageDialog(this,
                        "User Added Successfully");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid Input. Check Age / Role");
            }
        });

        btnBack.addActionListener(e -> {
            new UserOperations().setVisible(true);
            dispose();
        });
    }

    private void addLabel(String text, int y) {
        JLabel lbl = new JLabel(text + " :");
        lbl.setBounds(50, y, 150, 20);
        contentPane.add(lbl);
    }

    private JTextField addField(int y) {
        JTextField txt = new JTextField();
        txt.setBounds(200, y, 150, 20);
        contentPane.add(txt);
        return txt;
    }
}
