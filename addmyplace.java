package com.example.attempt56;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addmyplace extends AppCompatActivity {

    EditText name,location;
    Button save, showOnMap, currentlocation;
    String thename;
    Double longtitudes, latitudes;
    ArrayList<LatLng> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmyplace);

        location=findViewById(R.id.locationame);
        name= findViewById(R.id.placename);
        save= findViewById(R.id.savebutton);
        showOnMap=findViewById(R.id.showmap);
        currentlocation = findViewById(R.id.currentlocationbutton);
        arrayList = new ArrayList<LatLng>();


        Places.initialize(getApplicationContext(), getString(R.string.api_key));

        location.setFocusable(false);

        currentlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showAuto();





            }
        });


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAuto();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){
            Place place = Autocomplete.getPlaceFromIntent(data);
            location.setText(place.getAddress());
            name.setText(place.getName());
            latitudes = place.getLatLng().latitude;
            longtitudes =place.getLatLng().longitude;
            thename= place.getName();

            LatLng places = new LatLng(latitudes,longtitudes);
            arrayList.add(places);









        }
        else if ( resultCode == AutocompleteActivity.RESULT_ERROR)
        {
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getApplicationContext(),status.getStatusMessage(),Toast.LENGTH_SHORT).show();
        }
    }



    public void setShowOnMap(View V)
    {
        Intent mapIntent = new Intent(addmyplace.this,singlelocation.class);
        mapIntent.putExtra("lat",latitudes);
        mapIntent.putExtra("longt",longtitudes);
        mapIntent.putExtra("name",thename);
        startActivity(mapIntent);
    }

    public void showAuto()
    {
        List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS
                ,Place.Field.LAT_LNG, Place.Field.NAME);

        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldList).build(addmyplace.this);
        startActivityForResult(intent,100);


    }

    public void SaveButton(View v)
    {




        Intent newIntent = new Intent(addmyplace.this,MainActivity.class);
        newIntent.putExtra("array",arrayList);
        startActivity(newIntent);





    }
}