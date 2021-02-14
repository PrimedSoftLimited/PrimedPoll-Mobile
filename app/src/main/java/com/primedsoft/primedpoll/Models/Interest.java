package com.primedsoft.primedpoll.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Interest implements Parcelable {
    @SerializedName("interest")
    private String interest;
    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private String id;

    public Interest() {
    }

    public Interest(Parcel in) {
        interest = in.readString();
        title = in.readString();
        id = in.readString();
    }

    public static final Creator<Interest> CREATOR = new Creator<Interest>() {
        @Override
        public Interest createFromParcel(Parcel in) {
            return new Interest(in);
        }

        @Override
        public Interest[] newArray(int size) {
            return new Interest[size];
        }
    };

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(interest);
        dest.writeString(title);
        dest.writeString(id);
    }
}
