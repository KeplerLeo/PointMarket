package com.example.pointmarket.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Message extends RealmObject implements Serializable, Parcelable {

    @PrimaryKey
    private int id;
    private String name;
    private String course;
    private String image;

    public Message() {
    }
    public Message(String name, String course, String image) {
        this(-1, name, course, image);
    }

    public Message(int _id, String name, String course, String image) {
        this.id = _id;
        this.name = name;
        this.course = course;
        this.image = image;
    }

    private Message(Parcel from){
        id = from.readInt();
        name = from.readString();
        course = from.readString();
        image = from.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(course);
        dest.writeString(image);
    }
    public static final Creator<Message>
            CREATOR = new Creator<Message>(){
        public Message createFromParcel(Parcel in){
            return new Message(in);
        }
        public Message[] newArray(int size){
            return new Message[size];
        }
    };

}