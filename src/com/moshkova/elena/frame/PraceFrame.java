package com.moshkova.elena.frame;

import com.moshkova.elena.programma.ListProducts;
import com.moshkova.elena.programma.Order;
import com.moshkova.elena.programma.Product;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PraceFrame extends JFrame {

    public PraceFrame(ArrayList<Product> praceList, HashSet<ListProducts> listProduct,HashMap<Integer, Order> orderList ) {
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


        add(panelPrace);
        pack();


        ListSelectionModel setModel = praceTable.getSelectionModel();

        setModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int sellIndex = praceTable.getSelectedRow();
//                TableModel model = praceTable.getModel();
//                Object stroka = model.getValueAt(sellIndex,0);
                Product productX = praceList.get(sellIndex);
                listProduct.add(new ListProducts(productX, 1));

                int x = listProduct.size();
                korzinaText.setText(String.valueOf(x));
                korzinaText.setEnabled(false);
            }

        });


        inButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                OrderFrame frame = new OrderFrame(listProduct, orderList);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });



        }


}
