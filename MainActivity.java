package com.example.attempt56;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addButton, showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        addButton = findViewById(R.id.addbutton);
        showButton = findViewById(R.id.showallbutton);
    }


    public void setAddButton(View v)
    {
        Intent addIntent = new Intent(MainActivity.this,addmyplace.class);
        startActivity(addIntent);

    }

    public void showAllMap(View v)
    {

        Intent getIntent = getIntent();
        ArrayList<LatLng> newArray = (ArrayList<LatLng>)getIntent.getSerializableExtra("array");

        Intent openmapIntent = new Intent(MainActivity.this,MapsActivity.class);
        openmapIntent.putExtra("array",newArray);

        startActivity(openmapIntent);

    }


}