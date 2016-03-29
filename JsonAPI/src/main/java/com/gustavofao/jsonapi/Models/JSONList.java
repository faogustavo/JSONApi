package com.gustavofao.jsonapi.Models;

import java.util.ArrayList;

public class JSONList<T extends Resource> extends ArrayList<T> {

    private Links links;

    public JSONList() {}

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

}
