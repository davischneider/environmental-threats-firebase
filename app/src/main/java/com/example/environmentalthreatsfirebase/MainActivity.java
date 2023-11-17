package com.example.environmentalthreatsfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddThreatButtonClick(View v) {
        Intent it = new Intent(getBaseContext(), AddThreat.class);
        startActivity(it);
    }
}