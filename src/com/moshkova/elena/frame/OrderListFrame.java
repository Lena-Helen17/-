package com.moshkova.elena.frame;

import com.moshkova.elena.programma.Order;


import java.awt.*;
import java.util.HashMap;
import  javax.swing.*;

public class OrderListFrame extends JFrame{

    public OrderListFrame(HashMap<Integer, Order> orderList) {
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
            String[] str = new String[3];
            str[0] = String.valueOf(pair.getKey());
            str[1] = String.valueOf(pair.getValue().getDataStart());
            str[2] = pair.getValue().getPerson().toString();
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


    }
}
