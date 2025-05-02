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

public class Realestate extends AppCompatActivity {
    ListView listView;

    MediaPlayer mpRealEstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_realestate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Create a MediaPlayer set to loop for .mp3 file RealEstate */
        /* Original file name: Aylex - Real Estate (freetouse.com) */
        /* Music track: Real Estate by Aylex */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpRealEstate = new MediaPlayer();
        mpRealEstate = MediaPlayer.create(this, R.raw.realestate);
        mpRealEstate.setLooping(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Start the RealEstate.mp3 */

        mpRealEstate.start();

        /* create names for guide for listview */

        String[] real = new String[]{
                "Tyra Team",
                "Judy Perry",
                "Jan Wells",
                "Johnny Carlyle",
                "Modern Lending",
                "Redstone Federal Credit Union",
                "FirstBank Mortgage",
                "Realtors & Real Estate Agents",
                "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, real);
        listView.setAdapter(adapter);

        /* Set on click listener for listview */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpRealEstate.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.remax.com/real-estate-teams/tyra-team-huntsville-al/101892742")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.judyperryrealestate.com/")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.legend-realty.com/jan-wells/")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.valleymls.com/Office/BHHSRiseRealEstate-497894")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://modernloans.com/locations/alabama/huntsville/")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.redfcu.org/personal/loans/mortgages/buy/?utm_source=google&utm_medium=cpc&utm_campaign=mortgage&utm_term=al_search&gad_source=1&gbraid=0AAAAADo0IYybUHBLnf9lwmJFC6IUdHgXu&gclid=CjwKCAjwwqfABhBcEiwAZJjC3umjRBPZIJk_t6Am_ElQBL-TB99nZ18GbVk3HMZXe9xAPbD9TttikxoCpsQQAvD_BwE")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.fbmortgageloans.com/branch/huntsville-franklin-street/")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.realtor.com/realestateagents/huntsville_al")));
                        break;
                    case 8:
                        startActivity(new Intent(Realestate.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}