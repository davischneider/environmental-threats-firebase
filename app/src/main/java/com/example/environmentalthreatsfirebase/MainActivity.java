package com.example.environmentalthreatsfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String THREATS_KEY = "threats";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference();
    DatabaseReference threats = root.child(THREATS_KEY);
    FirebaseListAdapter<EnvironmentalThreat> listAdapter;
    ListView threatsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threatsList = findViewById(R.id.threatsList);

        FirebaseListOptions<EnvironmentalThreat> options = new FirebaseListOptions.Builder<EnvironmentalThreat>()
                .setQuery(threats, EnvironmentalThreat.class)
                .setLayout(R.layout.threat_item)
                .build();

        listAdapter = new FirebaseListAdapter<EnvironmentalThreat>(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull EnvironmentalThreat model, int position) {
                TextView addressItemText = v.findViewById(R.id.addressItemText);
                TextView dateItemText =  v.findViewById(R.id.dateItemText);
                ImageView imageItem = v.findViewById(R.id.imageItem);
                addressItemText.setText(model.getAddress());
                dateItemText.setText(model.getDate());
                if (model.getImage() != null) {
                    byte imageData[] = Base64.decode(model.getImage(), Base64.DEFAULT);
                    Bitmap img = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
                    imageItem.setImageBitmap(img);
                }
            }
        };

        threatsList.setAdapter(listAdapter);
        threatsList.setOnItemLongClickListener((parent, view, position, id) -> {
            DatabaseReference item = listAdapter.getRef(position);
            item.removeValue();

            return false;
        });

        threatsList.setOnItemClickListener((parent, view, position, id) -> {
            DatabaseReference item = listAdapter.getRef(position);
            changeToUpdate(item.getKey(), listAdapter.getItem(position));
        });

        listAdapter.startListening();
    }

    public void onAddThreatButtonClick(View v) {
        Intent it = new Intent(getBaseContext(), AddThreat.class);
        startActivity(it);
    }

    public void changeToUpdate(String key, EnvironmentalThreat t){
        Intent it = new Intent(getBaseContext(), EditThreat.class);
        it.putExtra("KEY", key);
        it.putExtra("THR", t);
        startActivity(it);
    }
}