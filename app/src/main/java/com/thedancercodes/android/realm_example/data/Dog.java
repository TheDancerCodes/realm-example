package com.thedancercodes.android.realm_example.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by TheDancerCodes on 15/01/2018.
 */

public class Dog extends RealmObject {

    // Fields of the Dog Object
    @PrimaryKey
    private int dogId;
    private String name;
    private int age;

    // A no arguments constructor.
    public Dog() {
    }

    public Dog(int dogId, String name, int age) {
        this.dogId = dogId;
        this.name = name;
        this.age = age;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    // How the information will be displayed when we log the information in the application
    public String toString() {
        return "Dog{" +
                "dogId=" + dogId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
