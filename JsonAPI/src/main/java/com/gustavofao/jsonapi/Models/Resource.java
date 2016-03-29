package com.gustavofao.jsonapi.Models;

import com.gustavofao.jsonapi.Annotatios.Excluded;
import com.gustavofao.jsonapi.Annotatios.Id;

public class Resource {

    @Id
    protected String id;
    protected Links links;

    @Excluded
    protected boolean hasAttributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public boolean hasAttributes() {
        return hasAttributes;
    }
}
