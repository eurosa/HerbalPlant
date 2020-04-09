package com.ranx.xcosx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsActivity extends AppCompatActivity {

    public TextView textView;
    public String title;
    public ImageView imageView;
    public String subTitle;
    public TextView stvTitle;
    FloatingActionButton myFab;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
        *
        *
        * Showing add hear
        *
        * */
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewDetails);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    /*
    *
    *
    *
    *
    * */




    textView=findViewById(R.id.textTitle);
        stvTitle=findViewById(R.id.subtitle);
        imageView=findViewById(R.id.image_view);

        myFab = findViewById(R.id.toolbar1);
        myFab.setImageResource(R.drawable.ic_arrow_point_to_back);
        //    myFab.setBackgroundColor(getResources().getColor(R.color.browser_actions_bg_grey));
        // myFab.setIcon(R.drawable.world_map);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });




        /* change the color of status bar*******************************************************
        *
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.design_default_color_primary_dark));
        }


        //--------------------------------------------------------------------------------------------------
/*
        Toolbar toolbar = findViewById(R.id.toolbarDetails);
       // toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        */
        //--------------------------------------------------------------------------------------

        Intent in = getIntent();

        title = in.getStringExtra("title");
        subTitle=in.getStringExtra("subTitle");
        //String picture = in.getStringExtra("image_draw");

       // Bundle extras = getIntent().getExtras();
        String fileName = in.getStringExtra("image_draw");

        Bitmap receivedimage =in.getParcelableExtra("image_draw");
        receivedimage = Bitmap.createScaledBitmap(receivedimage , 260, 260, false);
        //File filePath = getFileStreamPath(fileName);
      //  Drawable d = Drawable.createFromPath(filePath.toString());
        imageView.setImageBitmap(receivedimage);



       // Toast.makeText(this, "Heljdlsd "+title, Toast.LENGTH_SHORT).show();
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        stvTitle.setTextColor(Color.parseColor("#FFFFFF"));

        textView.setText(title);
        stvTitle.setText(subTitle);

        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


}
