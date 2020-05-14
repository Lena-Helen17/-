package com.moshkova.elena.frame;

import java.awt.*;
import javax.swing.*;

public class Paint extends JPanel{
    String text;

    public Paint(String t) {
        text = t;
    }

    public void painComponent(Graphics g) {
        g.drawString(text,50,50);
    }


}
