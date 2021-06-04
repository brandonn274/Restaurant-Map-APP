package com.example.attempt56;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.attempt56.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    ArrayList<LatLng> arrayList2 = new ArrayList<>();
    LatLng KFCSpringvale = new LatLng(145.1579,37.9336);
    LatLng McdonaldsSpringvale = new LatLng(145.1512,37.9618);
    LatLng NandosSpringvale = new LatLng(145.1560,37.9351);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList2.add(KFCSpringvale);
        arrayList2.add(McdonaldsSpringvale);
        arrayList2.add(NandosSpringvale);

        Intent intent = getIntent();
        ArrayList<LatLng> thisarray = (ArrayList<LatLng>)intent.getSerializableExtra("array");

//        for(int i =0; i<thisarray.size();i++)
//        {
//            arrayList2.set(i, thisarray.get(i));
//            i++;
//        }




        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


            for (int i = 0; i <= arrayList2.size(); i++) {
                mMap.addMarker(new MarkerOptions().position(arrayList2.get(i)).title("Marker"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList2.get(i)));

            }




        // Add a marker in Sydney and move the camera

    }
}