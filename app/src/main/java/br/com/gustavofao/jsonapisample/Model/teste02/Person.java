package br.com.gustavofao.jsonapisample.Model.teste02;

import com.gustavofao.jsonapi.Annotations.SerialName;
import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Models.Resource;

@Type("people")
public class Person extends Resource {

    @SerialName("first-name") private String firstName;
    @SerialName("last-name") private String lastName;
    private String twitter;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
