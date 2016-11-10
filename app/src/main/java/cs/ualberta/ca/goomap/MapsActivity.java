package cs.ualberta.ca.goomap;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/**
* needs <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">AIzaSyBWEu3kQ94V2TWPexnjmYM84WGdz9tl3S4</string>
* in resources to properly search
*/
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        // Add a marker in Edmonton and move the camera
        LatLng Edmonton = new LatLng(53.52676, -113.52715);

        Circle towncircle = googleMap.addCircle(new CircleOptions()
                .center(new LatLng( 53.54565 ,-113.49026))
                .radius(500)
                .strokeColor(Color.RED));
        //.fillColor(Color.BLUE));

        Circle circle = googleMap.addCircle(new CircleOptions()
                .center(new LatLng(53.52676, -113.52715))
                .radius(500)
                .strokeColor(Color.RED));
                //.fillColor(Color.BLUE));
        mMap.addMarker(new MarkerOptions().position(Edmonton).title("Marker in Edmonton"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Edmonton));
    }
}
