package com.Shop.ShopManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class UserOperations extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new UserOperations().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UserOperations() {
        setTitle("User Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lbl = new JLabel("User Operations");
        lbl.setBounds(170, 20, 120, 20);
        contentPane.add(lbl);

        JButton btnAdd = new JButton("Add User");
        btnAdd.setBounds(50, 70, 120, 25);
        contentPane.add(btnAdd);

        JButton btnDisplay = new JButton("Display User");
        btnDisplay.setBounds(250, 70, 120, 25);
        contentPane.add(btnDisplay);

        JButton btnUpdate = new JButton("Update User");
        btnUpdate.setBounds(50, 150, 120, 25);
        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete User");
        btnDelete.setBounds(250, 150, 120, 25);
        contentPane.add(btnDelete);

        JButton btnBack = new JButton("< back");
        btnBack.setBounds(331, 222, 84, 20);
        contentPane.add(btnBack);

        // Navigation
        btnAdd.addActionListener(e -> {
            new AddUser().setVisible(true);
            dispose();
        });

        btnDisplay.addActionListener(e -> {
            new DisplayUser().setVisible(true);
            dispose();
        });

        btnUpdate.addActionListener(e -> {
            new UpdateUser().setVisible(true);
            dispose();
        });

        btnDelete.addActionListener(e -> {
            new DeleteUser().setVisible(true);
            dispose();
        });

        // 🔙 BACK → LOGIN (USER FLOW)
        btnBack.addActionListener(e -> {
            new LoginFrame(false).setVisible(true);
            dispose();
        });
    }
}
