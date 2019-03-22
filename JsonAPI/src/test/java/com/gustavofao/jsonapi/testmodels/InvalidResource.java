package com.gustavofao.jsonapi.testmodels;

import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Models.Resource;

public class InvalidResource extends Resource {

    private String invalidField;

    public String getInvalidField() {
        return invalidField;
    }

    public void setInvalidField(String invalidField) {
        this.invalidField = invalidField;
    }
}
