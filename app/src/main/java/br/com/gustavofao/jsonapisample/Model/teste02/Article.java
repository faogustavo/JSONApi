package br.com.gustavofao.jsonapisample.Model.teste02;

import com.gustavofao.jsonapi.Annotations.Excluded;
import com.gustavofao.jsonapi.Annotations.SerialName;
import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Models.JSONList;
import com.gustavofao.jsonapi.Models.Resource;

@Type("articles")
public class Article extends Resource {

    private String title;
    private JSONList<Comment> comments;
    @Excluded private String blah;

    @SerialName("author")
    private Person person;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public JSONList<Comment> getComments() {
        return comments;
    }

    public void setComments(JSONList<Comment> comments) {
        this.comments = comments;
    }
}
