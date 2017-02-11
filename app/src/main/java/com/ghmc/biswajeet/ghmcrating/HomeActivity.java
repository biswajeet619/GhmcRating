package com.ghmc.biswajeet.ghmcrating;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends Activity {

    String LocalityName;
    Spinner spinner;
    ArrayAdapter<CharSequence>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.Location_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"\t selected",Toast.LENGTH_SHORT).show();
                LocalityName=parent.getItemAtPosition(position).toString();
                Intent intent=new Intent(getBaseContext(),RatingActivity.class);
                intent.putExtra("LocalityName",LocalityName);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void submit(View view) {
        Intent intent = new Intent(this,RatingActivity.class);
    }

    public void bestarea(View view) {
        startActivity(new Intent(HomeActivity.this,BestAreaActivity.class));
    }
}
