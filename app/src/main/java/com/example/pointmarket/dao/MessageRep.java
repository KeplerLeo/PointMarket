package com.example.pointmarket.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.pointmarket.model.Message;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

public class MessageRep {

    public String insert(Message mes) {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            try {
                mes.setId(realm.where(Message.class).max("id").intValue()+1);
            }catch (Exception ex) {
                mes.setId(1);
            }
            realm.insert(mes);
            realm.commitTransaction();
            return "Registro inserido com sucesso";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao inserir registro";
        }
    }

    public Integer delete(final Message message){
        try{
            Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    message.deleteFromRealm();
                }
            });
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public  Message getById(int i){
        Realm realm = Realm.getDefaultInstance();
        Message message =realm.where(Message.class).equalTo("id", i).findFirst();
        realm.where(Message.class).equalTo("id", i).findFirst();
        return message;
    }

    public List<Message> getAll(){
        Realm realm = Realm.getDefaultInstance();
        List<Message> messages = new ArrayList<>();
        messages.addAll(realm.where(Message.class).findAll());
        return messages;
    }

    public Message getFirst(){
        Realm realm = Realm.getDefaultInstance();
        Message message = new Message();
        message = realm.where(Message.class).findFirstAsync();
        return message;
    }
    public int update(Message message ){
        try{
            Realm realm = Realm.getDefaultInstance();
            Message t = realm.where(Message.class).equalTo("id",message.getId()).findFirst();
            realm.beginTransaction();
            t.setName(message.getName());
            t.setCourse(message.getCourse());
            t.setImage(message.getImage());
            realm.commitTransaction();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
