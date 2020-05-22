package com.moshkova.elena.frame;

import com.moshkova.elena.programma.ListProducts;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;

public class BasketFrame extends JFrame {

    public BasketFrame(HashSet<ListProducts> hashSet) {
        setTitle("Корзина");
        setSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        BasketListModel btm = new BasketListModel();
        JTable productList = new JTable(btm);
        JScrollPane productListScrollPane = new JScrollPane(productList);   //прокрутка
        productListScrollPane.setPreferredSize(new Dimension(400,400));

        JButton addButten = new JButton("Добавить");
        JButton deletButten = new JButton("Удалить");
        JButton allButten = new JButton("Оформить заказ");

         Iterator<ListProducts> it = hashSet.iterator();

            while (it.hasNext()) {
                ListProducts x = it.next();
                String[] str = new String[3];
            str[0] = x.getProduct().getName();
            str[1] = String.valueOf(x.getCount());
            str[2] = String.valueOf(x.getOrderPrice());
            btm.addDate(str);
                System.out.println(str[0]);
            }
        // btm.getValueAt(1,1);




        add(productListScrollPane, new GridBagConstraints(0, 0, 3, 1 , 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));
        add(addButten, new GridBagConstraints(0, 1, 1, 1 , 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(deletButten, new GridBagConstraints(1, 1, 1, 1 , 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(allButten, new GridBagConstraints(2, 1, 1, 1 , 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

       // allButten.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                OrderFrame frame = new OrderFrame(HashSet<ListProducts> hashSet);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
//            }
      //  });
    }

}
