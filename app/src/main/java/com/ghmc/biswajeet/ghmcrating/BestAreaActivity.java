package com.ghmc.biswajeet.ghmcrating;

import android.app.Activity;
import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;

public class BestAreaActivity extends Activity {

    private GridView itemListGridView;
    private ItemAdapter itemAdapter;
    private ArrayList<AreaRatingItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_area);
        itemListGridView  = (GridView)findViewById(R.id.area_list);
        items = new ArrayList<AreaRatingItem>();
        Collections.addAll(items, Dummy.areas);

        //ho gya.. ab firebase kal ya parso me kar le bc haan bc ek aur doubt ismey nahi

        itemAdapter  = new ItemAdapter(this,items);


        itemListGridView.setAdapter(itemAdapter);
    }
}
