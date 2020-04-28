package com.gupaoedu.vip.pattern.builder.level1;

import javax.swing.*;
import java.awt.*;

public abstract class PersonBuilder extends JPanel {
    protected Graphics g;
    public PersonBuilder(Graphics g){
        this.g = g;
    }
    public abstract void buildHead();
    public abstract void buildBody();
    public abstract void buildArmLeft();
    public abstract void buildArmRight();
    public abstract void buildLegLeft();
    public abstract void buildLegRight();
}
