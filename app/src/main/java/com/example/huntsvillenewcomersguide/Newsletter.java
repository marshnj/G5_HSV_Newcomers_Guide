package com.example.huntsvillenewcomersguide;

import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Newsletter extends AppCompatActivity {
    ListView listView;
    private EditText firstnameEditText;
    private EditText lastnameEditText;
    private EditText emailaddressEditText;
    private EditText phonenumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newsletter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstnameEditText = findViewById(R.id.edit1);
        lastnameEditText = findViewById(R.id.edit2);
        emailaddressEditText = findViewById(R.id.edit3);
        phonenumberEditText = findViewById(R.id.edit4);

        String[] news = new String[]{"Home Screen"};
        listView=findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, news);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        startActivity(new Intent(Newsletter.this, MainActivity.class));
                        break;
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String savedFirstname = sharedPreferences.getString("user_firstname", "");
        String savedLastname = sharedPreferences.getString("user_lastname", "");
        String savedEmail = sharedPreferences.getString("user_email", "");
        String savedPhone = sharedPreferences.getString("user_phone", "");
        firstnameEditText.setText(savedFirstname);
        lastnameEditText.setText(savedLastname);
        emailaddressEditText.setText(savedEmail);
        phonenumberEditText.setText(savedPhone);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_firstname", firstnameEditText.getText().toString());
        editor.putString("user_lastname", lastnameEditText.getText().toString());
        editor.putString("user_email", emailaddressEditText.getText().toString());
        editor.putString("user_phone", phonenumberEditText.getText().toString());
        editor.apply();

    }
}