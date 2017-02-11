package com.ghmc.biswajeet.ghmcrating;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RatingActivity extends Activity {

    String LName;
    private TextView locality;
    private RatingBar ratingBar;
    private EditText suggestion;
    AreaRatingItem value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        LName = getIntent().getStringExtra("LocalityName");
        locality = (TextView) findViewById(R.id.locality_name);
        locality.setText("Name Of Locality: " + LName);
        ratingBar = (RatingBar) findViewById(R.id.rating_area);
        suggestion = (EditText) findViewById(R.id.suggestion);


        DBhelper db = new DBhelper(this);
        Log.d("Inseting to db", "values");


        // Read from the database


    }

    public void signout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(RatingActivity.this, LoginActivity.class));
    }

    public void submitRating(View view) {

        int rate = (int) ratingBar.getRating();
        Log.d("Rating", String.valueOf(rate));
        for (int i = 0; i < 5; i++) {
            if (Dummy.areas[i].getArea().equals(LName)) {
                Dummy.areas[i].addrating(rate);
                startActivity(new Intent(RatingActivity.this,ThankActivity.class));
                finish();
            }


        }

        // store it in variable
        //get the suggestion text
        //update them to database
        //kal kar le bc.. database ka o..hkkk.. 2 din h lol :P tikh hai tu paper likh le :P
    }

    public void bestarea(View view) {
        Log.d("bestarea", "area");
    }

    public void disperencies(View view) {
        startActivity(new Intent(this,DisperencyActivity.class));
    }
}
