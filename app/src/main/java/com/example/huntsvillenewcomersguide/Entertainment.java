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

public class Entertainment extends AppCompatActivity {
    ListView listView;
    MediaPlayer mpEntertainment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entertainment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file entertainment*/
        /* Original file name: Moavii - Downtown (freetouse.com) */
        /* Music track: Downtown by Moavii */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpEntertainment = new MediaPlayer();
        mpEntertainment = MediaPlayer.create(this, R.raw.entertainment);
        mpEntertainment.setLooping(true);

        /* Start the entertainment.mp3 */

        mpEntertainment.start();

        /* create names for guide for listview */

        String[] ent = new String[]{"Pints & Pixels", "SiP", "Levity Live", "Bumpers Billiards","Civil Axe Throwing", "Huntsville Aquatics Center", "Huntsville Escape Rooms", "List of Huntsville Entertainments", "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, ent);
        listView.setAdapter(adapter);

        /* Set on click listener for listview */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpEntertainment.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.pintsandpixels.pub/")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://siploungehuntsville.com/")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://levitylive.com/huntsville/")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://bumpershuntsville.com/")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.axethrowingguide.com/location/civil-axe-throwing-hunstville-alabama/")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsvilleal.gov/environment/parks-recreation/recreation/aquatics/huntsville-aquatics-center/")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.theescape.com/huntsville-escape-rooms/")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://cm.hsvchamber.org/list/category/amusement-attractions-entertainment-791")));
                        break;
                    case 8:
                        startActivity(new Intent(Entertainment.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}