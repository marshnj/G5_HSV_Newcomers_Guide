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

public class Parks extends AppCompatActivity {
    ListView listView;

    MediaPlayer mpParks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parks);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file Parks */
        /* Original file name: Aventure - A Beautiful Garden (freetouse.com) */
        /* Music track: A Beautiful Garden by Aventure */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpParks = new MediaPlayer();
        mpParks = MediaPlayer.create(this, R.raw.parks);
        mpParks.setLooping(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Start the Parks.mp3 */

        mpParks.start();

        /* create names for guide for listview */

        String[] prks = new String[]{"Huntsville Botanical Garden", "Monte Sano State Park", "Big Spring Park", "Nature Trail-Green Mountain","Hays Nature Preserve", "Wade Mountain Nature Preserve",
                "Indian Creek Greenway", "Huntsville Parks & Recreation List", "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, prks);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpParks.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://hsvbg.org/")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.alapark.com/parks/monte-sano-state-park")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsville.org/listing/big-spring-international-park/862/")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.madisoncountyal.gov/services/green-mountain-nature-trail")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsville.org/blog/list/post/hays-nature-preserve-is-fun-all-seasons/")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.alltrails.com/parks/us/alabama/wade-mountain-nature-preserve")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.traillink.com/trail/indian-creek-greenway-(al)/")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsvilleal.gov/environment/parks-recreation/parks-and-nature/find-a-park/")));
                        break;
                    case 8:
                        startActivity(new Intent(Parks.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}