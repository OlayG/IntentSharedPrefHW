package com.noname.intentsharedprefhw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Activity3 extends AppCompatActivity {
    private static final String TAG = "Activity3";
    // Declare person object
    Person person;

    // Declare sharedpref
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // init sharedPref
        preferences = getSharedPreferences(Constants.PERSON_PREF_FILE_KEY, MODE_PRIVATE);

        // get personJsonString from our preference
        String personJsonString = preferences.getString(Constants.PERSON_PREF_KEY, "");
        // print to logcat personJsonString
        Log.d(TAG, "onCreate: " + personJsonString);
        // convert personJsonString back to Person Object
        person = new Gson().fromJson(personJsonString, Person.class);

        Toast.makeText(this, person.getAboutMe(), Toast.LENGTH_LONG).show();
    }
}
