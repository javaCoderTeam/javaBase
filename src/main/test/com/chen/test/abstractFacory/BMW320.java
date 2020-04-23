package com.chen.test.abstractFacory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:19
 */
public class BMW320 implements BMWFactory {

    @Override
    public void buildBMW() {
      Container container = new BMW320Container();
      container.buildContainer();

      Engine engine = new BMW320Engine();
      engine.buildEngine();

    }
}
