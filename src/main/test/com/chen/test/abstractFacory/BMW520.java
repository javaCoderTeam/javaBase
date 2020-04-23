package com.chen.test.abstractFacory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:19
 */
public class BMW520 implements BMWFactory {

    @Override
    public void buildBMW() {
      Container container = new BMW520Container();
      container.buildContainer();

      Engine engine = new BMW520Engine();
      engine.buildEngine();

    }
}
