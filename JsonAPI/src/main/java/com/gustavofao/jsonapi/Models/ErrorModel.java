package com.gustavofao.jsonapi.Models;

/**
 * Created by Gustavo Fão Valvassori on 21/04/2016.
 * Propósito: ${CURSOR}
 */
public class ErrorModel {

    private String status;
    private String title;
    private String detail;
    private ErrorSource source;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ErrorSource getSource() {
        return source;
    }

    public void setSource(ErrorSource source) {
        this.source = source;
    }
}
