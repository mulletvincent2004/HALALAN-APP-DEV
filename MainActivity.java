package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int int_age;
    EditText et_age, et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_age = findViewById(R.id.age);
        et_name = findViewById(R.id.name);
    }

    public void submit(View view) {
        if (et_age.getText().toString().isEmpty() || et_name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your age and name.", Toast.LENGTH_SHORT).show();
        } else {
            int_age = Integer.parseInt(et_age.getText().toString());
            String name = et_name.getText().toString();

            if (int_age <= 17) {
                Toast.makeText(this, "You cannot vote.", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent(this, VotingActivity.class);
                i.putExtra("name", name);
                startActivity(i);
            }
        }
    }
}