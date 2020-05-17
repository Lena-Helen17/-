package com.moshkova.elena.frame;

import com.moshkova.elena.programma.ListProducts;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;

public class OrderFrame extends JFrame {

    public OrderFrame(HashSet<ListProducts> hashSet)  {
        setTitle("Форма заказа");
        setSize(new Dimension(900, 400));
        setLayout(new GridBagLayout());

        //______________________________________________________   данные о персоне
        JPanel panelPerson = new JPanel();
       // panelPerson.setBackground(Color.CYAN);
        panelPerson.setLayout(new GridBagLayout());

        JLabel namePerson = new JLabel("Фамилия и имя:");
        JLabel adresDostavki = new JLabel("Адрес:");
        JLabel telefonNumber = new JLabel("Номер телефона:");
        JTextField namePersonText = new JTextField(20);
        JTextField adresDostavkiText = new JTextField();
        JTextField telefonNumberText = new JTextField();


        panelPerson.add(namePerson, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPerson.add(namePersonText, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPerson.add(adresDostavki, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPerson.add(adresDostavkiText, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPerson.add(telefonNumber, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelPerson.add(telefonNumberText, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

//------------------------------------------------------  информационная панель
        JPanel panelInfo = new JPanel();
        //panelInfo.setBackground(Color.RED);
        panelInfo.setLayout(new GridBagLayout());

        JLabel dataOrder = new JLabel("Дата создания заказа:");
        JLabel place = new JLabel("Процент скидки:");
        JLabel statuc = new JLabel("Статус заказа:");
        JTextField dataOrderText = new JTextField(10);
        JTextField placeText = new JTextField(10);
        JTextField statucText = new JTextField(10);


        panelInfo.add(dataOrder, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(dataOrderText, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(place, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(placeText, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(statuc, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(statucText, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

//________________________________________________________    товары из корзины
        JPanel panelBascket = new JPanel();
       // panelBascket.setBackground(Color.PINK);
        panelBascket.setLayout(new GridBagLayout());

        BasketListModel btm = new BasketListModel();
        JTable productList = new JTable(btm);
        JScrollPane productListScrollPane = new JScrollPane(productList);   //прокрутка
       productListScrollPane.setPreferredSize(new Dimension(900,300));

        Iterator<ListProducts> it = hashSet.iterator();
        Double summa = 0.0;

        while (it.hasNext()) {
            ListProducts x = it.next();
            String[] str = new String[3];
            str[0] = x.getProduct().getName();
            str[1] = String.valueOf(x.getCount());
            str[2] = String.valueOf(x.getPriceCheckList());
            summa = summa + x.getPriceCheckList()*x.getCount();
            btm.addDate(str);
            System.out.println(str[0]);
        }

        JButton deletButton = new JButton("Удалить");
        JButton changeButton = new JButton("Изменить");
        JLabel vsego = new JLabel("Общая сумма:");
        JTextField vsegoText = new JTextField(10);
        vsegoText.setText(String.valueOf(summa));

        // btm.getValueAt(1,1);
        panelBascket.add(productListScrollPane, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(deletButton, new GridBagConstraints(0,1 , 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(changeButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(vsego, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(vsegoText, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

 //________________________________________________ нижняя панель
        JPanel panelDown = new JPanel();
       // panelDown.setBackground(Color.GRAY);

        JButton saveButton = new JButton("Сохранить");

        panelDown.add(saveButton);

 //________________________________________________

        add(panelPerson, new GridBagConstraints(0, 0, 1, 1 , 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(panelInfo, new GridBagConstraints(1, 0, 1, 1 , 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(panelBascket, new GridBagConstraints(0,1 , 2, 1, 1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        add(panelDown, new GridBagConstraints(0, 2,2 , 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        pack();
    }
}
