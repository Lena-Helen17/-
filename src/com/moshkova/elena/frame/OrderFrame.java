package com.moshkova.elena.frame;

import com.moshkova.elena.Application;
import com.moshkova.elena.Configuration;
import com.moshkova.elena.programma.ListProducts;
import com.moshkova.elena.programma.Order;
import com.moshkova.elena.programma.Person;
import com.moshkova.elena.programma.Product;
import com.moshkova.elena.read_and_writer.FileRead;
import com.moshkova.elena.read_and_writer.ObjectWrite;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class OrderFrame extends JFrame {
    LocalDate dataStart = LocalDate.now();
    Double summa = 0.0;
    Short discaunt;

    public OrderFrame(HashSet<ListProducts> hashSetProducts, HashMap<Integer, Order> orderList, String dis)  {
        ArrayList<ListProducts> listProductsList = new ArrayList<>(hashSetProducts);
        discaunt = Short.valueOf(dis);
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
        //JCheckBox placeYes = new JCheckBox();
        JLabel statuc = new JLabel("Статус заказа:");
        JTextField dataOrderText = new JTextField(10);
        JTextField placeText = new JTextField(10);
        placeText.setText(dis);
        JMenuBar menuBar = new JMenuBar();
        JMenu statucText = new JMenu("                     ");
        JMenuItem menuItem1 = new JMenuItem("Готовится");
        JMenuItem menuItem2 = new JMenuItem("Отгружен");
        JMenuItem menuItem3 = new JMenuItem("Отменён");
        statucText.add(menuItem1);
        statucText.add(menuItem2);
        statucText.add(menuItem3);
        menuBar.add(statucText);


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
//        panelInfo.add(placeYes, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(statuc, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelInfo.add(menuBar, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        dataOrderText.setText(this.dataStart.format(DateTimeFormatter.ofPattern("d.MM.uuuu")));
        menuItem1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
           statucText.setText(menuItem1.getText());
            }
        });
        menuItem2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statucText.setText(menuItem2.getText());
            }
        });
        menuItem3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statucText.setText(menuItem3.getText());
            }
        });

//________________________________________________________    товары из корзины
        JPanel panelBascket = new JPanel();
       // panelBascket.setBackground(Color.PINK);
        panelBascket.setLayout(new GridBagLayout());

        OrderModel model = new OrderModel(listProductsList);
        JTable productListTable = new JTable(model);
        JScrollPane productListScrollPane = new JScrollPane(productListTable);   //прокрутка
       productListScrollPane.setPreferredSize(new Dimension(900,300));


        JButton deletButton = new JButton("Удалить");
        JLabel changeLabel = new JLabel("Изменить количество:");
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JLabel vsego = new JLabel("                              Общая сумма:");
        JTextField vsegoText = new JTextField(10);
        //Обновление суммы
        for (ListProducts product : listProductsList) {
            summa = summa + product.getOrderPrice();
        }
        vsegoText.setText(String.valueOf(summa));

        // btm.getValueAt(1,1);
        panelBascket.add(productListScrollPane, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(deletButton, new GridBagConstraints(0,1 , 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(changeLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(plusButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(minusButton, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(vsego, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelBascket.add(vsegoText, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

            plusButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = productListTable.getSelectedRow();
                    if(selectedRow >= 0) {
                        selectedRow = productListTable.convertRowIndexToModel(selectedRow);
                        ListProducts listProducts = model.getListProductsAt(selectedRow);
                        listProducts.setCount(listProducts.getCount() + 1);
                        model.update(listProducts);
                        //Обновление суммы
                        summa = 0.0;
                        for (ListProducts product : listProductsList) {
                            summa = summa + product.getOrderPrice();
                        }
                        vsegoText.setText(String.valueOf(summa));
                    }
                }
            });
            minusButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = productListTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        selectedRow = productListTable.convertRowIndexToModel(selectedRow);
                        ListProducts listProducts = model.getListProductsAt(selectedRow);
                        listProducts.setCount(listProducts.getCount() - 1);
                        model.update(listProducts);
                        //Обновление суммы
                        summa = 0.0;
                        for (ListProducts product : listProductsList) {
                            summa = summa + product.getOrderPrice();
                        }
                        vsegoText.setText(String.valueOf(summa));

                    }
                }
            });
        deletButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productListTable.getSelectedRow();
                if (selectedRow >= 0) {
                    selectedRow = productListTable.convertRowIndexToModel(selectedRow);
                    listProductsList.remove(selectedRow);
                    model.removeRow(selectedRow);
                    //Обновление суммы
                    summa = 0.0;
                    for (ListProducts product : listProductsList) {
                        summa = summa + product.getOrderPrice();
                    }
                    vsegoText.setText(String.valueOf(summa));
                    //обновляем главное окно
                    revalidate();
                    repaint();
                }
            }
        });


 //________________________________________________ нижняя панель
        JPanel panelDown = new JPanel();
       // panelDown.setBackground(Color.GRAY);

        JButton saveButton = new JButton("Сохранить");

        panelDown.add(saveButton);
        saveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Order order1 = new Order(dataOrderText.getText(), new Person(namePersonText.getText(), adresDostavkiText.getText(), telefonNumberText.getText()),
                        discaunt, statucText.getText(), listProductsList);
                Integer x =  orderList.size() +1;
                System.out.println(x);
                orderList.put(x, order1);

                ObjectWrite whiterOrderList = new ObjectWrite();
                whiterOrderList.writer("orderList.dat", orderList);


                Application.startFlamePrace();
                dispose();

            }
        });

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
