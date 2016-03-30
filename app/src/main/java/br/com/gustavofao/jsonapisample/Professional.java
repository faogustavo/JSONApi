package br.com.gustavofao.jsonapisample;

import com.gustavofao.jsonapi.Annotations.SerialName;
import com.gustavofao.jsonapi.Annotations.Types;
import com.gustavofao.jsonapi.Models.Resource;

import java.util.Date;
import java.util.List;

@Types({"professionals", "freelancers", "self_employeds", "other_professionals"})
public class Professional extends Resource {

    private String email;
    private String phone;
    private String cnpj;
    private double latitude;
    private double longitude;
    private String name;
    private String about;
    private String photo;

    @SerialName("city-id")
    private int cityId;

    @SerialName("activity-list")
    private List<String> activityList;

    @SerialName("activity-humanized")
    private String activityHumanized;

    @SerialName("positive-votes-count")
    private int positiveVotes;

    @SerialName("negative-votes-count")
    private int negativeVotes;

    @SerialName("created-at")
    private Date createdAt;

    @SerialName("updated-at")
    private Date updatedAt;


    private boolean favorited;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
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

    public String getActivityHumanized() {
        return activityHumanized;
    }

    public void setActivityHumanized(String activityHumanized) {
        this.activityHumanized = activityHumanized;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<String> activityList) {
        this.activityList = activityList;
    }
}
