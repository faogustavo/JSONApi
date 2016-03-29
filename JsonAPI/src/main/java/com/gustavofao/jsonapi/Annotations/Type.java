package com.gustavofao.jsonapi.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Type {
    String value();
}
