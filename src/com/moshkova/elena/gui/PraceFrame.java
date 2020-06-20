package com.moshkova.elena.gui;

import com.moshkova.elena.models.ListProducts;
import com.moshkova.elena.models.Order;
import com.moshkova.elena.models.Product;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PraceFrame extends JFrame {

    public PraceFrame(LinkedHashSet<Product> praceSet, HashSet<ListProducts> listProduct,HashMap<Integer, Order> orderList, String disk ) {
        ArrayList<Product> praceList = new ArrayList<>(praceSet);
        setTitle("Прайс Лист");
        setSize(new Dimension(800, 800));

        JPanel panelPrace = new JPanel();
        panelPrace.setLayout(new GridBagLayout());

        PraceTableModel btm = new PraceTableModel();
        JTable praceTable = new JTable(btm);
        JScrollPane pracetListScrollPane = new JScrollPane(praceTable);   //прокрутка
        pracetListScrollPane.setPreferredSize(new Dimension(800, 800));


        for (int i = 0; i < praceList.size(); i++) {
            Product x = praceList.get(i);
            String[] str = new String[4];
            str[0] = String.valueOf(x.getId());
            str[1] = x.getName();
            str[2] = x.getColor();
            str[3] = String.valueOf(x.getPrice());
            btm.addDate(str);
        }

        JButton inButton = new JButton("Оформить заказ");
        JLabel korzina = new JLabel("Корзина");
        JTextField korzinaText = new JTextField(5);
        JButton orderListButton = new JButton("Открыть список заказов");
        orderListButton.setBackground(Color.GREEN);


        panelPrace.add(pracetListScrollPane, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPrace.add(inButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPrace.add(korzina, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.WEST, GridBagConstraints.CENTER,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPrace.add(korzinaText, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.WEST, GridBagConstraints.CENTER,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPrace.add(orderListButton, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.WEST, GridBagConstraints.CENTER,
                new Insets(2, 2, 2, 2), 0, 0));


        add(panelPrace);
        pack();


        ListSelectionModel setModel = praceTable.getSelectionModel();

        setModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int sellIndex = praceTable.getSelectedRow();

                Product productX = praceList.get(sellIndex);
                listProduct.add(new ListProducts(productX, 1, disk));

                int x = listProduct.size();
                korzinaText.setText(String.valueOf(x));
                korzinaText.setEnabled(false);
            }

        });


        inButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                OrderFrame frame = new OrderFrame(listProduct, orderList, disk);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });

        orderListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderListFrame frame = new OrderListFrame(orderList,praceSet);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        }
}
