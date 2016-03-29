package com.gustavofao.jsonapi.Annotatios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Type {
    String value();
}
