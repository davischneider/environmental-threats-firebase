package com.example.environmentalthreatsfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditThreat extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference();
    DatabaseReference threats = root.child(MainActivity.THREATS_KEY);

    EditText addressTextEdit;
    EditText dateTextEdit;
    EditText descriptionTextEdit;

    EnvironmentalThreat currentThreat;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_threat);

        addressTextEdit = findViewById(R.id.addressTextEdit);
        dateTextEdit = findViewById(R.id.dateTextEdit);
        descriptionTextEdit = findViewById(R.id.descriptionTextEdit);

        key = getIntent().getStringExtra("KEY");
        currentThreat = (EnvironmentalThreat) getIntent().getSerializableExtra("THR");

        addressTextEdit.setText(currentThreat.getAddress());
        dateTextEdit.setText(currentThreat.getDate());
        descriptionTextEdit.setText(currentThreat.getDescription());
    }

    public void onEditThreatButtonClick(View v) {
        currentThreat.setAddress(addressTextEdit.getText().toString());
        currentThreat.setDate(dateTextEdit.getText().toString());
        currentThreat.setDescription(descriptionTextEdit.getText().toString());
        threats.child(key).setValue(currentThreat);
        finish();
    }
}