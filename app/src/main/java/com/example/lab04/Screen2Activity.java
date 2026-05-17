package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        TextView titleView = findViewById(R.id.text_title);
        TextView priorityView = findViewById(R.id.text_priority);
        TextView descriptionView = findViewById(R.id.text_description);
        Button backButton = findViewById(R.id.button_back);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String priority = intent.getStringExtra("priority");

        titleView.setText(safe(title));
        priorityView.setText("Priorite : " + safe(priority));
        descriptionView.setText("Description :\n" + safe(description));
        backButton.setOnClickListener(v -> finish());
    }

    private String safe(String value) {
        return (value == null || value.trim().isEmpty()) ? "-" : value.trim();
    }
}
