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

public class Restaurants extends AppCompatActivity {
    ListView listView;

    MediaPlayer mpRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restaurants);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        /* Create a MediaPlayer set to loop for .mp3 file Restaurants */
        /* Original file name: Pufino - Avocado(freetouse.com) */
        /* Music track: Avocado by Pufino */
        /* Source: https://freetouse.com/music */
        /* No Copyright Vlog Music for Video */

        mpRestaurants = new MediaPlayer();
        mpRestaurants = MediaPlayer.create(this, R.raw.restaurants);
        mpRestaurants.setLooping(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Start the Restaurants.mp3 */

        mpRestaurants.start();

        /* create names for guide for listview */
        String[] rest = new String[]{"Connors Steak & Seafood", "Hildegard's German Cuisine", "Cotton Row", "The Boot Pizzeria","Blue Plate Cafe",
                "Twin Peaks", "Ol Heidelberg Cafe", "Huntsville Restaurants List", "Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, rest);
        listView.setAdapter(adapter);
 
        /* Set on click listener for listview */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Set up ListView switch */
                /* Turn off the music and go to the screen for the list item */

                mpRestaurants.pause();

                switch(position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.connorsrestaurant.com/huntsville-al-steakhouse.html")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://hildegardsgermancuisine.net/")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.cottonrowrestaurant.com/")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://thebootpizzeria.com/")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://blueplatecafe.com/")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://twinpeaksrestaurant.com/")));
                        break;
                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.olheidelberg.com/")));
                        break;
                    case 7:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.huntsville.org/restaurants-breweries/all/")));
                        break;
                    case 8:
                        startActivity(new Intent(Restaurants.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}