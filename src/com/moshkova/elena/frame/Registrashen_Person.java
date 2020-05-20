package com.moshkova.elena.frame;
import com.moshkova.elena.programma.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrashen_Person  extends JFrame{
    public Registrashen_Person() {
        //setTitle("Регистрация");
        //setSize(300, 300);
        setUndecorated(true);
        //setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel namePerson = new JLabel("Фамилия и имя:");
        JLabel adresDostavki = new JLabel("Адрес:");
        JLabel telefonNumber = new JLabel("Номер телефона:");
        JTextField namePersonText = new JTextField(20);
        JTextField adresDostavkiText = new JTextField();
        JTextField telefonNumberText = new JTextField();
        JButton saveButten = new JButton("Cохранить");

        add(namePerson, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(namePersonText, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(adresDostavki, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(adresDostavkiText, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(telefonNumber, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(telefonNumberText, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(saveButten, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        //pack();   //убирает лишнее пространство

       saveButten.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //int x = 23;
               //String name = "person" + "x";
               Person name = new Person(namePersonText.getText(),adresDostavkiText.getText(), telefonNumberText.getText());
           }
       } );
}
}
