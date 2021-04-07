package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mtextview;
    Button mbutton;
    LocationManager locmgr;
    List<String> locProviders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loc_provider_list);

        mtextview = findViewById(R.id.txtOutput);
        mbutton = findViewById(R.id.button);
        locmgr = (LocationManager)getSystemService(LOCATION_SERVICE);

        locProviders = locmgr.getAllProviders();


        mbutton.setOnClickListener(new View.OnClickListener() {
            String s = "";
            @Override
            public void onClick(View v) {


            for( String a: locProviders) {
                int i=0;
                s += "Loc.Provider " + locProviders.get(i) + "\n"
                        + "status : " + locmgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
                i++;
                mtextview.setText(s);
            }

            /*for (int i = 0; i < locProviders.size(); i++) {
                s += "Loc.Provider " + locProviders.get(i) + "\n"
                        + "status : " + locmgr.isProviderEnabled(locProviders.get(i)) + "\n\n";

            } */

            }
        });


    }
}