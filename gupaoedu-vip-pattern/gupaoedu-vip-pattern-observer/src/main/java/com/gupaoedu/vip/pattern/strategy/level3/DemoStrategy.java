package com.gupaoedu.vip.pattern.strategy.level3;




import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://blog.csdn.net/xietansheng/article/details/72814552
 */
public class DemoStrategy extends Applet {
    public DemoStrategy() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(gridbag);


        JLabel lblTotalType =  new JLabel("计算方式");
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(new Item("com.gupaoedu.vip.pattern.strategy.level1.CashNormal", "正常收费"));
        comboBox.addItem(new Item("com.gupaoedu.vip.pattern.strategy.level1.CashReturn 300,100", "满300返100"));
        comboBox.addItem(new Item("com.gupaoedu.vip.pattern.strategy.level1.CashRebate 0.8", "打8折"));
//        comboBox.addItem(new Item(0.5, "打5折"));
//        comboBox.setMaximumRowCount(3);
        comboBox.setPrototypeDisplayValue(" None of the above ");
        comboBox.addActionListener(e -> {
            JComboBox c = (JComboBox) e.getSource();
            Item item = (Item) c.getSelectedItem();
            System.out.println(item.getId() + " : " + item.getDescription());
        });


        JLabel lblPrice = new JLabel("单价");
        JTextField tfPrice = new JTextField(10);

        JLabel lblNumber = new JLabel("数量");
        JTextField tfNumber = new JTextField(10);

        JLabel lblTotal = new JLabel("总计");
        JLabel lblTotalNum = new JLabel("0");


        JTextArea textArea = new JTextArea("", 5, 20);
        textArea.setPreferredSize(new Dimension(300, 100));

        AtomicReference<Double> total = new AtomicReference<>(0.0);
        JButton btConfirm = new JButton("确定");
        btConfirm.addActionListener(e -> {
            String price = tfPrice.getText();
            String number = tfNumber.getText();
            Item item = (Item) comboBox.getSelectedItem();

            CashContext cashSuper = new CashContext(item.getId());
            double totalPrice = cashSuper.getResult(Double.parseDouble(price)*Double.parseDouble(number));
            total.updateAndGet(v -> new Double((double) (v + totalPrice)));

            lblTotalNum.setText(String.valueOf(total));
            textArea.append("单价1:"+price + " 数量:"+number+" "+item.getDescription()+" 合计:"+totalPrice+"\n");

        });
        JButton btReset = new JButton("重置");
        btReset.addActionListener(e -> {
            tfPrice.setText("");
            tfNumber.setText("");
            textArea.setText("");
            lblTotalNum.setText("0");
            total.updateAndGet(v -> new Double(0));
            comboBox.setSelectedIndex(0);
            System.out.println("count");

        });

        JButton b = new JButton("refresh");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                tfPrice.setText("xxxxx445");
//                comboBox.removeAllItems();
//                comboBox.addItem(new Item(1, "-"));
//                comboBox.addItem(new Item(2, "X"));
//                comboBox.addItem(new Item(3, "Y"));
//                comboBox.addItem(new Item(4, "44"));
                System.out.println("ok");

            }
        });

//        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(b, gc);
        add(b);

//        gc.weightx = 1;
        gc.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(lblPrice,gc);
        gridbag.setConstraints(tfPrice,gc);
        gc.gridwidth = GridBagConstraints.REMAINDER;//最后一个组件占满，换行
        gridbag.setConstraints(btConfirm,gc);
        add(lblPrice);
        add(tfPrice);
        add(btConfirm);

        gc.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(lblNumber,gc);
        gridbag.setConstraints(tfNumber,gc);
        gc.gridwidth = GridBagConstraints.REMAINDER;//最后一个组件占满，换行
        gridbag.setConstraints(btReset,gc);
        add(lblNumber);
        add(tfNumber);
        add(btReset);

        gc.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(lblTotalType,gc);
        gc.gridwidth = GridBagConstraints.REMAINDER;//最后一个组件占满，换行
        gridbag.setConstraints(comboBox,gc);
        add(lblTotalType);
        add(comboBox);

        gc.gridwidth = GridBagConstraints.REMAINDER;//最后一个组件占满，换行
        gridbag.setConstraints(textArea,gc);
        add(textArea);

        gc.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(lblTotal,gc);
        gc.gridwidth = GridBagConstraints.REMAINDER;//最后一个组件占满，换行
        gridbag.setConstraints(lblTotalNum,gc);
        add(lblTotal);
        add(lblTotalNum);

    }

    public static void main(String[] args) {
        DemoStrategy demo = new DemoStrategy();
        Frame frame = new Frame();
        frame.add(demo);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}

class Item {

    private String id;
    private String description;

    public Item(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}

