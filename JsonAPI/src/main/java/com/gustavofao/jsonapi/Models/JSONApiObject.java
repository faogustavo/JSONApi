package com.gustavofao.jsonapi.Models;

import java.util.ArrayList;
import java.util.List;

public class JSONApiObject {

    private List<Resource> data;
    private Links links;
    private boolean hasErrors = true;
    private List<ErrorModel> errors;

    public JSONApiObject() {
        data = new ArrayList<>();
    }

    public List<Resource> getData() {
        return data;
    }

    public Resource getData(int position) {
        return data.get(position);
    }

    public void setData(List<Resource> data) {
        this.data = data;
    }

    public void addData(Resource resource) {
        data.add(resource);
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public boolean hasErrors() {
        return hasErrors;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }
}
