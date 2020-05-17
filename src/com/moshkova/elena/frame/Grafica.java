package com.moshkova.elena.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;

public class Grafica extends JFrame{

    JPanel panel;

    public Grafica() {
     setTitle("My macet");
     setSize(300,300);
     //setLayout(new GridBagLayout());
     //setLocationByPlatform(true);

     panel = new JPanel();
     panel.setBackground(Color.CYAN);

     Font font = new Font("Verdana", Font.BOLD, 15); //шрифт

     JButton start = new JButton("+");
     start.setBackground(Color.MAGENTA);
     start.setForeground(Color.white);
     start.setFont(font);

   //  start.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     JButton stop = new JButton("-");
     stop.setBackground(new Color(252,137,172));

     JTextField textField = new JTextField(20);
     textField.setText("0");
        System.out.println(textField.getText());

     JLabel label = new JLabel("товар...");


     panel.add(label);
     panel.add(start);
     panel.add(stop);
     panel.add(textField);


    add(panel);


     start.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int x = Integer.parseInt(textField.getText());
            x++;
            textField.setText(String.valueOf(x));
         }
     });

     stop.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             int x = Integer.parseInt(textField.getText());
             if (x > 0) {
                 x--;
             }
             textField.setText(String.valueOf(x));
         }
     });
    }

}
