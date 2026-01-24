package com.Shop.ShopManagement;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DisplayUser extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new DisplayUser().setVisible(true));
    }

    public DisplayUser() {
        setTitle("Display Users");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 450);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        String[] cols = {"UID", "Username", "Password", "Age", "Role"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        List<User> users = UserDAO.getAllUsers();
        for (User u : users) {
            model.addRow(new Object[]{
                    u.getUid(),
                    u.getUsername(),
                    u.getPassword(),
                    u.getAge(),
                    u.getRole()
            });
        }

        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        contentPane.add(sp, BorderLayout.CENTER);

        JButton btnBack = new JButton("< Back");
        contentPane.add(btnBack, BorderLayout.SOUTH);

        btnBack.addActionListener(e -> {
            new UserOperations().setVisible(true);
            dispose();
        });
    }
}
