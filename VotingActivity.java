package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VotingActivity extends AppCompatActivity {
    EditText etPresident;
    EditText etVicePresident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        etPresident = findViewById(R.id.editTextPresident);
        etVicePresident = findViewById(R.id.editTextVicePresident);

        // Retrieve the name from the intent
        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            String name = intent.getStringExtra("name");

            // Display the name in a TextView
            TextView tvName = findViewById(R.id.textViewName);
            tvName.setText("Hello " + name);
        }
    }

    public void goToResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);

        // Pass the selected President and Vice President to ResultActivity
        intent.putExtra("president", etPresident.getText().toString());
        intent.putExtra("vicePresident", etVicePresident.getText().toString());

        startActivity(intent);
    }
}