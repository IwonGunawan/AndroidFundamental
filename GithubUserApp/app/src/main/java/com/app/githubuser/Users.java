package com.app.githubuser;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String username;
    private String name;
    private String location;
    private String repository;
    private String company;
    private int followers;
    private int following;
    private int avatar;



    public Users() {
    }


    protected Users(Parcel in) {
        username = in.readString();
        name = in.readString();
        location = in.readString();
        repository = in.readString();
        company = in.readString();
        followers = in.readInt();
        following = in.readInt();
        avatar = in.readInt();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(name);
        parcel.writeString(location);
        parcel.writeString(repository);
        parcel.writeString(company);
        parcel.writeInt(followers);
        parcel.writeInt(following);
        parcel.writeInt(avatar);
    }
}
