package com.example.huntsvillenewcomersguide;

import android.content.Intent;
import android.media.MediaPlayer;
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

public class MainActivity extends AppCompatActivity {
    ListView listView;
    MediaPlayer mpHuntsville;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file huntsville*/
        /* Original file name: Aylex - Engineering (freetouse.com) */
        /* Music track: Engineering by Aylex */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpHuntsville = new MediaPlayer();
        mpHuntsville = MediaPlayer.create(this, R.raw.huntsville);
        mpHuntsville.setLooping(true);

        /* Display Huntsville Logo */

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Start the huntsville.mp3 */

        mpHuntsville.start();

        /* create names for guide for listview */

        String[] guide = new String[]{"Apartments", "Entertainment", "Government Offices",
                "Hotels","Museums", "Parks", "Real Estate Companies", "Restaurants", "Sign up for Newsletter"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, guide);
        listView.setAdapter(adapter);

        /* Set on click listener for listview */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpHuntsville.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, Apartments.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Entertainment.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Government.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Hotels.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, Museums.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, Parks.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, Realestate.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, Restaurants.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, Newsletter.class));
                        break;
                }
            }
        });
    }
}