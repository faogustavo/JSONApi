package com.gustavofao.jsonapi.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface SerialName {
    String value();
}
