package br.com.gustavofao.jsonapisample.Model.teste02;

import com.gustavofao.jsonapi.Annotatios.Type;
import com.gustavofao.jsonapi.Models.Resource;

@Type("comments")
public class Comment extends Resource {

    private String body;
    private Person author;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Person getPerson() {
        return author;
    }

    public void setPerson(Person author) {
        this.author = author;
    }
}
