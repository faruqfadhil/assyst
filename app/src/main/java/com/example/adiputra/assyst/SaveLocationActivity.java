package com.example.adiputra.assyst;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SaveLocationActivity extends AppCompatActivity {

    String location, latitude, longitude;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TextView LOCATION, LATITUDE, LONGITUDE;
        setContentView(R.layout.activity_save_location);

        final TextView LOCATION = (TextView) findViewById(R.id.tvLocationName2);
        final TextView LATITUDE = (TextView) findViewById(R.id.tvLatitude);
        final TextView LONGITUDE = (TextView) findViewById(R.id.tvLongitude);
        Button SAVE = (Button) findViewById(R.id.btnSave);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            LOCATION.setText(extras.getString("locationName"));
            LATITUDE.setText(extras.getString("latitude"));
            LONGITUDE.setText(extras.getString("longitude"));
        }

        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = LOCATION.getText().toString();
                latitude = LATITUDE.getText().toString();
                longitude = LONGITUDE.getText().toString();

                DatabaseOperations DB = new DatabaseOperations(ctx);
                DB.putInformation(DB, location, latitude, longitude);
                Toast.makeText(getBaseContext(), "Configuration Saved", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
