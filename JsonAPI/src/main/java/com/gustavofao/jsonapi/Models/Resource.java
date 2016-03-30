package com.gustavofao.jsonapi.Models;

import com.gustavofao.jsonapi.Annotations.Excluded;
import com.gustavofao.jsonapi.Annotations.Id;
import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Annotations.Types;

public class Resource {

    @Id
    private String id;
    private Links links;

    @Excluded
    private String type;

    @Excluded
    protected boolean hasAttributes;

    public String getId() {
        return id;
    }

    public String getType() {
        if (Resource.class.getAnnotation(Type.class) != null)
            return Resource.class.getAnnotation(Type.class).value();
        return type;
    }

    public boolean hasAttributes() {
        return hasAttributes;
    }

    public Links getLinks() {
        return links;
    }
}
