package br.com.gustavofao.jsonapisample.Model.teste01;

import com.gustavofao.jsonapi.Annotatios.SerialName;
import com.gustavofao.jsonapi.Annotatios.Type;
import com.gustavofao.jsonapi.Models.Resource;

import java.util.List;

@Type("all_types")
public class AllTypes extends Resource {

    private String mString;
    private double mDouble;
    private float mFloat;
    private int mInteger;
    private boolean mBoolean;
    private long mLong;
    @SerialName("CharacterField")
    private char mChar;
    private List<Integer> mList;
    private Professional professional;

    public String getmString() {
        return mString;
    }

    public void setmString(String mString) {
        this.mString = mString;
    }

    public double getmDouble() {
        return mDouble;
    }

    public void setmDouble(double mDouble) {
        this.mDouble = mDouble;
    }

    public float getmFloat() {
        return mFloat;
    }

    public void setmFloat(float mFloat) {
        this.mFloat = mFloat;
    }

    public int getmInteger() {
        return mInteger;
    }

    public void setmInteger(int mInteger) {
        this.mInteger = mInteger;
    }

    public boolean ismBoolean() {
        return mBoolean;
    }

    public void setmBoolean(boolean mBoolean) {
        this.mBoolean = mBoolean;
    }

    public long getmLong() {
        return mLong;
    }

    public void setmLong(long mLong) {
        this.mLong = mLong;
    }

    public char getmChar() {
        return mChar;
    }

    public void setmChar(char mChar) {
        this.mChar = mChar;
    }

    public List<Integer> getmList() {
        return mList;
    }

    public void setmList(List<Integer> mList) {
        this.mList = mList;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
