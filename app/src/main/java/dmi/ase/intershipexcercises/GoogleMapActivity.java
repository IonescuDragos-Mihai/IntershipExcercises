package dmi.ase.intershipexcercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        MapView mapView=findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync((OnMapReadyCallback)this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coord=new LatLng(46.7676919,23.5709693);
        googleMap.addMarker(new MarkerOptions().position(coord).title("Cluj Arena").snippet("Bun venit la cluj arena"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord,16));
    }
}