package com.example.adiputra.assyst;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements View.OnClickListener {

    public MapFragment() {
        // Required empty public constructor
    }

    MapView mMapView;
    private GoogleMap googleMap;
    public CharSequence locationName;
    public Double latitude;
    public Double longitude;

    //Button btnSaveLocation;
    //AutoCompleteTextView fromLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        final Button btnSaveLoc = (Button) rootView.findViewById(R.id.btnSaveLocation);
        btnSaveLoc.setVisibility(View.GONE);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    return;
                }
                googleMap.setMyLocationEnabled(true);



                // For dropping a marker at a point on the Map
                //LatLng myLocation = new LatLng(-7.276401,112.794887);
                //googleMap.addMarker(new MarkerOptions().position(myLocation).title("EEPIS").snippet("pens joss!!!"));

                // For zooming automatically to the location of the marker
                //CameraPosition cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(15).build();
                //googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


        //Search Locate Manually
        PlaceAutocompleteFragment places = (PlaceAutocompleteFragment)
                getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        places.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                btnSaveLoc.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(),place.getAddress(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(),place.getLatLng().toString(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(),place.getViewport().toString(),Toast.LENGTH_SHORT).show();

                locationName = place.getName();
                latitude = place.getLatLng().latitude;
                longitude = place.getLatLng().longitude;

                LatLng mySearch = place.getLatLng();
                googleMap.addMarker(new MarkerOptions().position(mySearch).title(place.getName().toString()).snippet(place.getAddress().toString()));
                CameraPosition cameraPosition = new CameraPosition.Builder().target(mySearch).zoom(20).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            }
            @Override
            public void onError(Status status) {
                Toast.makeText(getActivity(),status.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        //Filter Search
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_NONE)
                .build();
        places.setFilter(typeFilter);

        //Define Button btnSaveLocation
        btnSaveLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),locationName,Toast.LENGTH_LONG).show();
                //Toast.makeText(getActivity(),latitude.toString(),Toast.LENGTH_LONG).show();
                Intent saveLocation = new Intent(getActivity(), SaveLocationActivity.class);
                saveLocation.putExtra("locationName", locationName);
                saveLocation.putExtra("latitude", latitude.toString());
                saveLocation.putExtra("longitude", longitude.toString());
                startActivity(saveLocation);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"Pindah Halaman",Toast.LENGTH_LONG).show();
    }
}
