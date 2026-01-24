package com.Shop.ShopManagement;

import javax.swing.*;
import java.awt.Color;

public class UpdateProduct extends JFrame {

    public UpdateProduct() {

        setTitle("Update Product");
        setBounds(100,100,500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        String[] labels = {
            "Product ID","Name","Price","Description","Category","Image URL"
        };

        JTextField[] fields = new JTextField[6];
        int y = 40;

        for (int i = 0; i < labels.length; i++) {

            JLabel l = new JLabel(labels[i] + ":");
            l.setBounds(30, y, 120, 20);
            getContentPane().add(l);

            fields[i] = new JTextField();
            fields[i].setBounds(150, y, 120, 20);
            getContentPane().add(fields[i]);

            // ❌ no update button for Product ID
            if (i != 0) {

                JButton b = new JButton("Update");
                b.setBounds(290, y, 100, 20);
                getContentPane().add(b);

                int idx = i;
                b.addActionListener(e -> {

                    String idText = fields[0].getText().trim();

                    // ✅ VALIDATION FIRST
                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(
                            this,
                            "Please enter Product ID first",
                            "Missing ID",
                            JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }

                    try {
                        int id = Integer.parseInt(idText);

                        switch (idx) {
                            case 1:
                                ProductDAO.updateName(id, fields[1].getText());
                                break;

                            case 2:
                                ProductDAO.updatePrice(
                                    id,
                                    Double.parseDouble(fields[2].getText())
                                );
                                break;

                            case 3:
                                ProductDAO.updateDescription(
                                    id, fields[3].getText()
                                );
                                break;

                            case 4:
                                ProductDAO.updateCategory(
                                    id, fields[4].getText()
                                );
                                break;

                            case 5:
                                ProductDAO.updateImage(
                                    id, fields[5].getText()
                                );
                                break;
                        }

                        JOptionPane.showMessageDialog(
                            this, "Product Updated Successfully"
                        );

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(
                            this,
                            "Enter valid numeric Product ID / Price",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                });
            }

            y += 30;
        }

        JButton back = new JButton("< back");
        back.setBackground(new Color(128, 128, 192));
        back.setBounds(350, 220, 100, 25);
        getContentPane().add(back);

        back.addActionListener(e -> {
            new ProductOperations().setVisible(true);
            dispose();
        });
    }
}
