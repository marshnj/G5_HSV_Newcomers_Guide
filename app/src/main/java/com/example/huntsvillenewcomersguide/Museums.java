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

public class Museums extends AppCompatActivity {
    ListView listView;

    MediaPlayer mpMuseums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_museums);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file Museums */
        /* Original file name: Pufino - Thoughtful (freetouse.com) */
        /* Music track: Thoughtful by Pufino */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpMuseums = new MediaPlayer();
        mpMuseums = MediaPlayer.create(this, R.raw.museums);
        mpMuseums.setLooping(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Start the Museums.mp3 */

        mpMuseums.start();

        /* create names for guide for listview */

        String[] muse = new String[]{"Space and Rocket Center", "U.S. Veterans Memorial Museum", "Lowe Mill Arts & Entertainment", "Huntsville Museum Of Art","Earlyworks Museum Complex", "North Alabama Railroad Museum",
                "Weeden House Museum", "Huntsville Museums List", "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, muse);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpMuseums.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.rocketcenter.com/")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.memorialmuseum.org/")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://lowemill.art/")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://hsvmuseum.org/")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://earlyworks.com/")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://narm.info/")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.artshuntsville.org/listing/weeden-house-museum/")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.tripadvisor.com/Attractions-g30620-Activities-c49-Huntsville_Alabama.html")));
                        break;
                    case 8:
                        startActivity(new Intent(Museums.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}