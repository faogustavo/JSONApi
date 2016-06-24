package br.com.gustavofao.jsonapisample.V2;

import android.os.Parcel;
import android.os.Parcelable;

import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Models.Resource;

@Type("person")
public class Person extends Resource implements Parcelable {

    private String name;
    private String firstName;
    private String pseudo;
    private String city;
    private String email;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // =============================================================================================
    // Parcelable Interface

    public final static Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        public Person createFromParcel(final Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(final int size) {
            return new Person[size];
        }
    };

    public Person(final Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeString(firstName);
        dest.writeString(pseudo);
        dest.writeString(email);
        dest.writeString(city);
    }

    private void readFromParcel(final Parcel in) {
        setId(in.readString());
        name = in.readString();
        firstName = in.readString();
        pseudo = in.readString();
        email = in.readString();
        city = in.readString();
    }
}