package com.gupaoedu.vip.pattern.builder;

import javax.swing.*;
import java.awt.*;

public class PersonFatBuilder extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, 20, 30, 30);        //头
        g.drawOval(45, 50, 40, 50);        //身体
        g.drawLine(60 - 10, 50, 40 - 10, 100);        //左手
        g.drawLine(70 + 10, 50, 90 + 10, 100);        //右手
        g.drawLine(60, 100, 45, 150);        //左脚
//        g.drawLine(70, 100, 85, 150);        //右脚

        this.setBackground(Color.RED);
        this.setForeground(Color.BLACK);

    }

}
