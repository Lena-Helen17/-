package com.moshkova.elena.gui;

import com.moshkova.elena.models.Order;
import com.moshkova.elena.models.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashSet;
import  javax.swing.*;

public class OrderListFrame extends JFrame{

    public OrderListFrame(HashMap<Integer, Order> orderList, LinkedHashSet<Product> praceList) {
        setTitle("Список заказов");
        setSize(800, 800);


        JPanel  panelListOrder = new JPanel();
       // panelListOrder.setBackground(Color.CYAN);
        panelListOrder.setLayout(new GridBagLayout());

        OrderListModel model = new OrderListModel();
        JTable listOrderTable = new JTable(model);
        JScrollPane orderListScrollPane = new JScrollPane(listOrderTable);   //прокрутка
        //orderListScrollPane.setPreferredSize(new Dimension(600, 600));

        for (HashMap.Entry<Integer, Order> pair : orderList.entrySet()) {
            String[] str = new String[4];
            str[0] = String.valueOf(pair.getKey());
            str[1] = String.valueOf(pair.getValue().getDataStart());
            str[2] = pair.getValue().getPerson().toString();
            str[3] = pair.getValue().getStatusOrder();
            model.addDate(str);
        }

        JButton inButton = new JButton("Открыть");

        panelListOrder.add(orderListScrollPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelListOrder.add(inButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(2, 2, 2, 2), 0, 0));



        add(panelListOrder);
        pack();

        inButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = listOrderTable.getSelectedRow();
                if (selectedRow >= 0) {
                   Integer x = Integer.valueOf((String) model.getValueAt(selectedRow,0));
                    System.out.println(x);
                    Order orderX = orderList.get(x);
                OrderFrame frame = new OrderFrame(orderX, x, orderList, praceList);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                dispose();
                }
            }
        });


    }
}
