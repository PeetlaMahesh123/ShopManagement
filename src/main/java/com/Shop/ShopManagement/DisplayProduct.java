package com.Shop.ShopManagement;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class DisplayProduct extends JFrame {

    public DisplayProduct() {

        setTitle("Display Products");
        setBounds(100,100,900,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] cols = {
            "PID","Name","Price","Description","Category","Image URL"
        };
        DefaultTableModel model = new DefaultTableModel(cols,0);

        List<Product> list = ProductDAO.getAllProducts();
        for(Product p : list){
            model.addRow(new Object[]{
                p.getPid(),
                p.getPname(),
                p.getPrice(),
                p.getDescription(),
                p.getCategory(),
                p.getProductImageurl()
            });
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        JButton back = new JButton("< back");
        add(back,BorderLayout.SOUTH);

        back.addActionListener(e -> {
            new ProductOperations().setVisible(true);
            dispose();
        });
    }
}
