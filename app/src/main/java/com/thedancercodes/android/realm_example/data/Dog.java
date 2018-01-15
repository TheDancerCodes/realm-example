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
}
