package com.noname.intentsharedprefhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    // Declare person object
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        person = (Person) getIntent().getSerializableExtra(Constants.PERSON_KEY);

    }
}
