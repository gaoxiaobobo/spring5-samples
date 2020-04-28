package com.gupaoedu.vip.pattern.builder.level1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DrawPerson extends JFrame {
    public static void main(String args[]) {
//        DrawPerson p = new DrawPerson();
        JFrame frame = new JFrame();

        PersonBuilder jp = new PersonThinBuilder(frame.getGraphics());


        JButton b = new JButton("fat");

        //布局的panel
        JPanel jpAll = new JPanel(new BorderLayout());
        jpAll.add(b, BorderLayout.NORTH);


        JLabel label = new JLabel();

        int counter = 0;
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo 覆盖中间的panel,用来调试，不用重启
//                JPanel tmp = new PersonFatBuilder();
                BufferedImage image = new BufferedImage(300, 300,BufferedImage.TYPE_INT_RGB);
                label.setIcon(null);
                label.revalidate();

                Graphics graphics = image.getGraphics();
//                PersonBuilder tmp = new PersonThinBuilder(graphics);

                PersonBuilder tmp = null;
                if(b.getText().equals("fat")){
                   tmp = new PersonFatBuilder(graphics);
                   b.setText("thin");
                }else {
                   tmp = new PersonThinBuilder(graphics);
                    b.setText("fat");
                }
                tmp.setPreferredSize(new Dimension(200, 380));

                PersonDirector director = new PersonDirector(tmp);
                director.CreatePerson();
//                if (graphics != null) {
//                    tmp.buildHead();
//                    tmp.buildBody();
//                    tmp.buildArmLeft();
//                    tmp.buildArmRight();
//                    System.out.println("i am pencil 22");
//                }


                label.setPreferredSize(new Dimension(400, 400));
                label.setIcon( new ImageIcon(image ));


                jpAll.remove(jp);
                jpAll.remove(label);//移除再画，否则会画出很多
                jpAll.add(label,BorderLayout.CENTER);
//                jpAll.add(tmp, BorderLayout.CENTER);//常规 paint

                frame.setContentPane(jpAll);
                SwingUtilities.updateComponentTreeUI(frame);
                System.out.println("click me");
            }
        });


        jpAll.add(jp, BorderLayout.CENTER);
        jp.setPreferredSize(new Dimension(200, 380));


        frame.setContentPane(jpAll);
        frame.setVisible(true);
        frame.setSize(400, 400);


    }
}
