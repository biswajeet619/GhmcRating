package com.ghmc.biswajeet.ghmcrating;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisperencyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disperency);
    }

    public void garbage(View view) {
        startActivity(new Intent(this,ComplainActivity.class));
    }

    public void roads(View view) {
        startActivity(new Intent(this,ComplainActivity.class));
    }

    public void deadanimals(View view) {
        startActivity(new Intent(this,ComplainActivity.class));
    }

    public void complain(View view) {
        startActivity(new Intent(this,ComplainActivity.class));
    }
}
