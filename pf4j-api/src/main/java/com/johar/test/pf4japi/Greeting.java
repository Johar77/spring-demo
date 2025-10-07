package com.johar.test.pf4japi;

import org.pf4j.ExtensionPoint;

public interface Greeting extends ExtensionPoint {

    String greet();
}
