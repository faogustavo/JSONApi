package br.com.gustavofao.jsonapisample.Model.teste01;

import com.gustavofao.jsonapi.Annotatios.Type;
import com.gustavofao.jsonapi.Models.Resource;

import java.util.Date;
import java.util.List;

@Type("professional")
public class Professional extends Resource {

    private int city_id;
    private int positive_votes_count;
    private int negative_votes_count;
    private double latitude;
    private double longitude;
    private boolean favorited;
    private String email;
    private String phone;
    private String cnpj;
    private String name;
    private String about;
    private String photo;
    private String activity_humanized;
    private Date created_at;
    private Date updated_at;
    private List<String> activity_list;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getPositive_votes_count() {
        return positive_votes_count;
    }

    public void setPositive_votes_count(int positive_votes_count) {
        this.positive_votes_count = positive_votes_count;
    }

    public int getNegative_votes_count() {
        return negative_votes_count;
    }

    public void setNegative_votes_count(int negative_votes_count) {
        this.negative_votes_count = negative_votes_count;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getActivity_humanized() {
        return activity_humanized;
    }

    public void setActivity_humanized(String activity_humanized) {
        this.activity_humanized = activity_humanized;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<String> getActivity_list() {
        return activity_list;
    }

    public void setActivity_list(List<String> activity_list) {
        this.activity_list = activity_list;
    }
}
