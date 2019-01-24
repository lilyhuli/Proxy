package cn.lilyhuli;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        /**
         * 静态代理
         */
        Humen humenProxy  = new HumenProxy();
        humenProxy.eat(" rice");
        /**
         * 通用的 DynamicProxy 类包装了 HumenImpl 实例，
         * 然后调用了Jdk的代理工厂方法实例化了一个具体的代理类。最后调用代理的 eat() 方法。
         *         JDK动态代理
         */

        Humen humen = new HumenImpl();
        DynamicProxy dynamicProxy = new  DynamicProxy(humen);
        Humen o  = dynamicProxy.getProxy();
        /**Humen o = (Humen)Proxy.newProxyInstance(
                humen.getClass().getClassLoader(),
                humen.getClass().getInterfaces(),
                dynamicProxy
        );*/
        o.eat("   rice");

    }
}
