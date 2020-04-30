package com.gupaoedu.vip.pattern.strategy.level3;

import com.gupaoedu.vip.pattern.strategy.level1.CashSuper;

import java.lang.reflect.Constructor;

public class CashContext {
    CashSuper cs = null;

    public static void main(String[] args) {
        String type = "com.gupaoedu.vip.pattern.strategy.level1.CashNormal";
        String type2 = "com.gupaoedu.vip.pattern.strategy.level1.CashReturn 300,100";
        String type3 = "com.gupaoedu.vip.pattern.strategy.level1.CashRebate 0.8";
        System.out.println(type.split(" ").length);
        System.out.println(type2.split(" ")[1].split(",")[0]);
        System.out.println(type3.split(" ").length);
        CashContext cs = new CashContext(type2);
        System.out.println(cs.getResult(1000));

    }

    /**
     * 利用反射实例化对象，消除switch判断
     *
     * @param type 类的全路径名
     * @throws ClassNotFoundException
     */
    public CashContext(String type) {
        try {
            //没有参数
            if (type.split(" ").length == 1) {
                Class<?> cls = Class.forName(type);
                cs = (CashSuper) cls.newInstance();
            } else {
                String[] args = type.split(" ")[1].split(",");
                cs = (CashSuper)getInstance(type.split(" ")[0], (Object[]) args);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }

    private Object getInstance(String className, Object[] args) throws Exception {
        Class<?>  newClass = Class.forName(className);
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        Constructor cons = newClass.getConstructor(argsClass);
        return cons.newInstance(args);
    }
}
