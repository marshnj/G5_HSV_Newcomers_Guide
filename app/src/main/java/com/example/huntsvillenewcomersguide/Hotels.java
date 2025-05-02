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

public class Hotels extends AppCompatActivity {
    ListView listView;

    MediaPlayer mpHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotels);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file hotels */
        /* Original file name: Chill Pulse - Office Jam (freetouse.com) */
        /* Music track: Office Jam by Chill Pulse */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpHotels = new MediaPlayer();
        mpHotels = MediaPlayer.create(this, R.raw.hotels);
        mpHotels.setLooping(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Start the hotels.mp3 */

        mpHotels.start();

        /* create names for guide for listview */

        String[] hots = new String[]{"Drury Inn & Suites", "Hampton Inn Providence", "Hampton Inn Research Park",
                "Hampton Inn Downtown", "The Westin Huntsville", "Homewood Suites Village of Providence",
                "Springhill Suites Huntsville Downtown", "Hotel Listing",
                "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, hots);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpHotels.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.tripadvisor.com/Hotel_Review-g30620-d13667966-Reviews-Drury_Inn_Suites_Huntsville_at_the_Space_Rocket_Center-Huntsville_Alabama.html")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.tripadvisor.com/Hotel_Review-g30620-d10333854-Reviews-Hampton_Inn_Huntsville_village_Of_Providence-Huntsville_Alabama.html")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.tripadvisor.com/Hotel_Review-g30620-d3869816-Reviews-Hampton_Inn_Suites_Huntsville_Research_Park_Area-Huntsville_Alabama.html")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.tripadvisor.com/Hotel_Review-g30620-d23692322-Reviews-Hampton_Inn_Suites_Huntsville_Downtown-Huntsville_Alabama.html")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.marriott.com/en-us/hotels/hsvwi-the-westin-huntsville/overview/")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.hilton.com/en/hotels/hsvhwhw-homewood-suites-huntsville-village-of-providence/")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.tripadvisor.com/Hotel_Review-g30620-d2665589-Reviews-Doubletree_Suites_By_Hilton_Hotel_Huntsville_South-Huntsville_Alabama.html")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsville.org/hotels-lodging/")));
                        break;
                    case 8:
                        startActivity(new Intent(Hotels.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}