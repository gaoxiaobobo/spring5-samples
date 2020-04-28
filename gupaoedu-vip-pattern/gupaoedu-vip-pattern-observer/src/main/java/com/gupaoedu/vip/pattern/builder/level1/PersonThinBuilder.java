package com.gupaoedu.vip.pattern.builder.level1;

import java.awt.*;

public class PersonThinBuilder extends PersonBuilder {

    public PersonThinBuilder(Graphics g) {
        super(g);
    }

    public void paint(Graphics g) {
        this.g = g;
        super.paint(g);
        buildHead();
        buildBody();
        buildLegLeft();
        buildLegRight();
    }


    @Override
    public void buildHead() {
        g.drawOval(50, 20, 30, 30);        //头
    }

    @Override
    public void buildBody() {
        g.drawRect(60, 50, 10, 50);        //身体
    }

    @Override
    public void buildArmLeft() {
        g.drawLine(60, 50, 40, 100);        //左手
    }

    @Override
    public void buildArmRight() {
        g.drawLine(70, 50, 90, 100);        //右手

    }

    @Override
    public void buildLegLeft() {
        g.drawLine(60, 100, 45, 150);        //左脚

    }

    @Override
    public void buildLegRight() {
        g.drawLine(70, 100, 85, 150);        //右脚
    }
}
