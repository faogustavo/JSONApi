package com.gustavofao.jsonapi.Models;

/**
 * Created by Gustavo Fão Valvassori on 21/04/2016.
 * Propósito: ${CURSOR}
 */
public class ErrorSource {

    private String pointer;
    private String parameter;

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
