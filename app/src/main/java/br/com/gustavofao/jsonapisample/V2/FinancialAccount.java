package br.com.gustavofao.jsonapisample.V2;

import com.gustavofao.jsonapi.Annotations.SerialName;
import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Models.Resource;

import java.util.Date;

@Type("financial-accounts")
public class FinancialAccount extends Resource {

    private String name;
    private String status;

    @SerialName("created-at") private Date createdAt;
    @SerialName("pdated-at") private Date updatedAt;
    @SerialName("default") private boolean defautlAccount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isDefautlAccount() {
        return defautlAccount;
    }

    public void setDefautlAccount(boolean defautlAccount) {
        this.defautlAccount = defautlAccount;
    }
}
