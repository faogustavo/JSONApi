package br.com.gustavofao.jsonapisample.Model.teste01;

import com.gustavofao.jsonapi.Annotatios.Type;
import com.gustavofao.jsonapi.Models.Resource;

@Type("post")
public class Post extends Resource {

    public static Post newInstance(String id, String title, String content) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        return post;
    }

    public static Post newInstance(String id, String title, String content, Professional author) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        return post;
    }

    private String title;
    private String content;
    private Professional author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Professional getAuthor() {
        return author;
    }

    public void setAuthor(Professional author) {
        this.author = author;
    }
}
