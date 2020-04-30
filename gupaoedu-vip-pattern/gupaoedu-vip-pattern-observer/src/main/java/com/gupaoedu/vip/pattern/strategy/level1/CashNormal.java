package com.gupaoedu.vip.pattern.strategy.level1;

public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
