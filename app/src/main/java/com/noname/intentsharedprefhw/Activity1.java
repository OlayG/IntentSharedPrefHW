package com.noname.intentsharedprefhw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    // Declare person object
    Person person;
    // Declare views from the R.layout.activity_1
    EditText etName, etDob;
    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        // Init person object
        person = new Person();

        // Init views from the R.layout.activity_1
        etName = findViewById(R.id.et_name);
        etDob = findViewById(R.id.et_dob);
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_next);


        // Since we are in the first Activity we don't need a back button
        btnBack.setVisibility(View.GONE);

        // Set onclick listener for btnNext
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Load values from EditTexts into a variable
                String name = etName.getText().toString();
                String dob = etDob.getText().toString();

                // Load values into Person Object
                person.setName(name);
                person.setDob(dob);

                // Load Activity2 and pass Person Object
                Intent intent = new Intent(Activity1.this, Activity2.class);
                intent.putExtra(Constants.PERSON_KEY, person);
                startActivity(intent);
            }
        });

    }
}
