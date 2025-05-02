package com.example.huntsvillenewcomersguide;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Government extends AppCompatActivity {
    ListView listView;
    MediaPlayer mpGovernment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_government);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file apartments */
        /* Original file name: Aylex - Business (freetouse.com) */
        /* Music track: Business by Aylex */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpGovernment = new MediaPlayer();
        mpGovernment = MediaPlayer.create(this, R.raw.government);
        mpGovernment.setLooping(true);

        /* Start the government.mp3 */

        mpGovernment.start();

        /* create names for guide for listview */

        String[] gov = new String[]{"Department of Motor Vehicles", "City Clerk (Voter Registration)","Huntsville Utility", "Huntsville Garbage Collection", "Tax Collector",
                "Tax Assessor","City of Huntsville Website", "County Department Listing", "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, gov);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpGovernment.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.madisoncountyal.gov/departments/license-department/drivers")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsvilleal.gov/government/voting-elections/")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.hsvutil.org/")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsvilleal.gov/residents/trash-recycling/residential-trash-collection/")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.madisoncountyal.gov/departments/tax-collector")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.madisoncountyal.gov/departments/tax-assessor/")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsvilleal.gov/")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.madisoncountyal.gov/departments/department-listing/")));
                        break;
                    case 8:
                        startActivity(new Intent(Government.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}