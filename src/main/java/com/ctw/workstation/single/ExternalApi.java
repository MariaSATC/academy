package com.ctw.workstation.single;

import io.vertx.core.eventbus.DeliveryContext;

public interface ExternalApi {

    String sayHelloFromOuterSpace(String name);
    String sayHelloFromOuterSpace();

    DeliveryContext<Object> hello(ExternalRequest externalRequest);
}
