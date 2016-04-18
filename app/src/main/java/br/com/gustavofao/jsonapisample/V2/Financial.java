package br.com.gustavofao.jsonapisample.V2;

import com.gustavofao.jsonapi.Annotations.Excluded;
import com.gustavofao.jsonapi.Annotations.SerialName;
import com.gustavofao.jsonapi.Annotations.Types;
import com.gustavofao.jsonapi.Models.Resource;

import java.util.Date;
import java.util.List;

@Types({"financials", "expenses", "incomes"})
public class Financial extends Resource {

    @Excluded
    public static final String include = "contact,account";

    @Excluded
    public static final String TAG = "financial_tag";
    @Excluded
    public static final String INCOMES = "Income";
    @Excluded
    public static final String EXPENSES = "Expense";
    @Excluded
    public static final String TOTAL = "Total";

    private String description;
    private double amount;
    private boolean paid;
    private Date date;
    private List<String> tags;

    @SerialName("type") private String financialType;
    @SerialName("expires-on") private Date expiresOn;

    private Contact contact;
    private FinancialAccount account;

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public FinancialAccount getAccount() {
        return account;
    }

    public void setAccount(FinancialAccount account) {
        this.account = account;
    }
}
