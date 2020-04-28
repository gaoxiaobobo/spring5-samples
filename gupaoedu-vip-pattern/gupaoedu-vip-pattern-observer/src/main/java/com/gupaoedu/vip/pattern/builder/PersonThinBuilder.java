package com.gupaoedu.vip.pattern.builder;

import javax.swing.*;
import java.awt.*;

public class PersonThinBuilder extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, 20, 30, 30);        //头
        g.drawRect(60, 50, 10, 50);        //身体
        g.drawLine(60, 50, 40, 100);        //左手
        g.drawLine(70, 50, 90, 100);        //右手
        g.drawLine(60, 100, 45, 150);        //左脚
        g.drawLine(70, 100, 85, 150);        //右脚
        this.setBackground(Color.CYAN);
    }

}
