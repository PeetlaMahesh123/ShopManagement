package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class UpdateUser extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId, txtName, txtPass, txtAge, txtRole;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new UpdateUser().setVisible(true));
    }

    public UpdateUser() {
        setTitle("Update User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        addLabel("User ID", 40);
        addLabel("Username", 70);
        addLabel("Password", 100);
        addLabel("Age", 130);
        addLabel("Role (ADMIN / USER)", 160);

        txtId   = addField(40);
        txtName = addField(70);
        txtPass = addField(100);
        txtAge  = addField(130);
        txtRole = addField(160);

        JButton btnName = new JButton("Update Name");
        btnName.setBackground(new Color(128, 128, 192));
        btnName.setBounds(330, 70, 140, 22);
        contentPane.add(btnName);

        JButton btnPass = new JButton("Update Password");
        btnPass.setBackground(new Color(128, 128, 192));
        btnPass.setBounds(330, 100, 140, 22);
        contentPane.add(btnPass);

        JButton btnAge = new JButton("Update Age");
        btnAge.setBackground(new Color(128, 128, 192));
        btnAge.setBounds(330, 130, 140, 22);
        contentPane.add(btnAge);

        JButton btnRole = new JButton("Update Role");
        btnRole.setBackground(new Color(128, 128, 192));
        btnRole.setBounds(330, 160, 140, 22);
        contentPane.add(btnRole);

        JButton btnBack = new JButton("< Back");
        btnBack.setBackground(new Color(128, 128, 192));
        btnBack.setBounds(360, 220, 100, 25);
        contentPane.add(btnBack);

        // ✅ UPDATE USERNAME
        btnName.addActionListener(e -> {
            UserDAO.updateUsername(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText()
            );
            JOptionPane.showMessageDialog(this, "Username Updated");
        });

        // ✅ UPDATE PASSWORD
        btnPass.addActionListener(e -> {
            UserDAO.updatePassword(
                    Integer.parseInt(txtId.getText()),
                    txtPass.getText()
            );
            JOptionPane.showMessageDialog(this, "Password Updated");
        });

        // ✅ UPDATE AGE
        btnAge.addActionListener(e -> {
            UserDAO.updateAge(
                    Integer.parseInt(txtId.getText()),
                    Integer.parseInt(txtAge.getText())
            );
            JOptionPane.showMessageDialog(this, "Age Updated");
        });

        // ✅ UPDATE ROLE
        btnRole.addActionListener(e -> {
            UserDAO.updateRole(
                    Integer.parseInt(txtId.getText()),
                    Role.valueOf(txtRole.getText().toUpperCase())
            );
            JOptionPane.showMessageDialog(this, "Role Updated");
        });

        btnBack.addActionListener(e -> {
            new UserOperations().setVisible(true);
            dispose();
        });
    }

    private void addLabel(String text, int y) {
        JLabel lbl = new JLabel(text + ":");
        lbl.setBounds(40, y, 150, 20);
        contentPane.add(lbl);
    }

    private JTextField addField(int y) {
        JTextField txt = new JTextField();
        txt.setBounds(190, y, 120, 20);
        contentPane.add(txt);
        return txt;
    }
}
