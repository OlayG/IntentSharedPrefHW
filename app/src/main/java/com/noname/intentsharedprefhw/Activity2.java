package com.noname.intentsharedprefhw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    // Declare person object
    Person person;

    // Declare sharedpref
    SharedPreferences preferences;

    // Declare views
    EditText etAboutMe;
    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // init person object
        person = (Person) getIntent().getSerializableExtra(Constants.PERSON_KEY);

        // init sharedpref
        preferences = getSharedPreferences(Constants.PERSON_PREF_FILE_KEY, MODE_PRIVATE);

        // init views
        etAboutMe = findViewById(R.id.et_about_me);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                // This closes the current activity and goes to the previous in stack if any
                finish();
                break;
            case R.id.btn_next:
                // Save Person Object and Go to Activity3
                savePerson();
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
                break;
        }
    }

    private void savePerson() {
        // Update person object with new info
        String aboutMe = etAboutMe.getText().toString();
        person.setAboutMe(aboutMe);

        // Convert Person Object to a json String
        String personJsonString = new Gson().toJson(person);

        // Access the sharedpref editor so we can save this personJsonString
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.PERSON_PREF_KEY, personJsonString);
        editor.apply();
    }
}
