package com.example.environmentalthreatsfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class EditThreat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_threat);
    }

    public void onEditThreatButtonClick(View v) {
        finish();
    }
}