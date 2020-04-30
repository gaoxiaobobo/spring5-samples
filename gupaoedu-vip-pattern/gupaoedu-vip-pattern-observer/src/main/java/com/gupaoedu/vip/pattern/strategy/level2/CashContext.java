package com.gupaoedu.vip.pattern.strategy.level2;

import com.gupaoedu.vip.pattern.strategy.level1.CashNormal;
import com.gupaoedu.vip.pattern.strategy.level1.CashRebate;
import com.gupaoedu.vip.pattern.strategy.level1.CashReturn;
import com.gupaoedu.vip.pattern.strategy.level1.CashSuper;

public class CashContext {
    CashSuper cs = null;
    public CashContext(String type){
        switch (type){
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                cs = new CashReturn("300d","100d");
                break;
            case "打8折":
                cs = new CashRebate("0.8");
                break;
        }
    }
    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
