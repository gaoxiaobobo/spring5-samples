package com.gupaoedu.vip.pattern.builder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPerson extends JFrame {
    public DrawPerson() {
        final Panel panel = new Panel();
        final Panel2 panel2 = new Panel2();
        //设置宽度，不然没有探件，只是一条线
        panel.setPreferredSize(new Dimension(200,380));
        panel2.setPreferredSize(new Dimension(200,380));

        JButton b = new JButton("push me");

        //布局的panel
        JPanel jpAll = new JPanel(new BorderLayout());
        jpAll.add(panel, BorderLayout.WEST);
        jpAll.add(panel2, BorderLayout.EAST);

        jpAll.add(b,BorderLayout.NORTH);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo 重绘jpanel,用来调试，不用重启
                jpAll.revalidate();
                jpAll.repaint();
                System.out.println("click me");
            }
        });

        //容器中添加组件
        getContentPane().add(jpAll);
//        this.setContentPane(jpAll);

        this.setVisible(true);
        this.setSize(400, 400);


    }


    class Panel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            g.drawOval(50, 20, 30, 30);        //头
            g.drawRect(60, 50, 10, 50);        //身体
            g.drawLine(60, 50, 40, 100);        //左手
            g.drawLine(70, 50, 90, 100);        //右手
            g.drawLine(60, 100, 45, 150);        //左脚
//            g.drawLine(70, 100, 85, 150);        //右脚
            this.setBackground(Color.CYAN);
//            this.setForeground(Color.BLACK);

        }
    }

    class Panel2 extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            g.drawOval(50, 20, 30, 30);        //头
            g.drawOval(45, 50, 40, 50);        //身体
            g.drawLine(60 - 10, 50, 40 - 10, 100);        //左手
            g.drawLine(70 + 10, 50, 90 + 10, 100);        //右手
            g.drawLine(60, 100, 45, 150);        //左脚
            g.drawLine(70, 100, 85, 150);        //右脚

            this.setBackground(Color.RED);
            this.setForeground(Color.BLACK);

        }
    }
    public static JPanel getPanel(){

        return new PersonThinBuilder();
    }
    public static void main(String args[]) {
//        DrawPerson p = new DrawPerson();
        JFrame frame = new JFrame();
        JPanel jp = new PersonThinBuilder();

        JButton b = new JButton("push me");

        //布局的panel
        JPanel jpAll = new JPanel(new BorderLayout());
        jpAll.add(b,BorderLayout.NORTH);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo 覆盖中间的panel,用来调试，不用重启
//                JPanel tmp = new PersonFatBuilder();
                JPanel tmp = new PersonThinBuilder();
                tmp.setPreferredSize(new Dimension(200,380));
                jpAll.add(tmp, BorderLayout.CENTER);

                frame.setContentPane(jpAll);
                SwingUtilities.updateComponentTreeUI(frame);
                System.out.println("click me");
            }
        });


        jpAll.add(jp, BorderLayout.CENTER);
        jp.setPreferredSize(new Dimension(200,380));


        frame.setContentPane(jpAll);
        frame.setVisible(true);
        frame.setSize(400,400);
    }
}
