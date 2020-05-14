package com.moshkova.elena.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_in extends JFrame {

    public Login_in() {
        setTitle("Вход в личный кабинет");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel login = new JLabel("Логин:");
        JLabel passvorld = new JLabel("Пароль:");
        JButton vhodButten = new JButton("Вход");
        JButton registrashenButten = new JButton("Регистрация");
        JTextField loginText = new JTextField(20);
        JPasswordField passwordText = new JPasswordField(20);

        add(login, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(loginText, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(passvorld, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(passwordText, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(registrashenButten, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(vhodButten, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));



        pack();   //убирает лишнее пространство
        registrashenButten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrashen_Person registrashen_person = new Registrashen_Person();
                registrashen_person.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registrashen_person.setVisible(true);
            }
        });
        vhodButten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grafica grafica = new Grafica();
                grafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                grafica.setVisible(true);
            }
        });

        ////////////////////////
       /* GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.9;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NORTH;
        c.insets = new Insets(10, 2, 3, 3);
        c.ipadx = 0;
        c.ipady = 0;

        */
    }
}
