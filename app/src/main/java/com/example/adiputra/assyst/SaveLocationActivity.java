package com.example.adiputra.assyst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaveLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_location);

        TextView tvLoc = (TextView) findViewById(R.id.tvLocationName2);
        TextView tvLat = (TextView) findViewById(R.id.tvLatitude);
        TextView tvLong = (TextView) findViewById(R.id.tvLongitude);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            tvLoc.setText(extras.getString("locationName"));
            tvLat.setText(extras.getString("latitude"));
            tvLong.setText(extras.getString("longitude"));
            //double tvCoor = getIntent().getExtras().getDouble("Intent");
            //double lng = Double.valueOf(bundle.getString("longitude"));
        }

    }
}
