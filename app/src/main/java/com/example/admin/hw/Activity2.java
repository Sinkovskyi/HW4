package com.example.admin.hw;

import android.content.Intent;
import android.service.chooser.ChooserTarget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Activity2 extends TopMenu implements View.OnClickListener{

    final int ANIM = 1;
    final int ALPHAUSE = 2;
    final int ROTATEUSE = 3;
    final int SCALEUSE = 4;
    final int TRANSLATEUSE = 5;


    ImageView imageView;
    Button nextActivityBotton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nextActivityBotton = (Button) findViewById(R.id.nextActivityBotton);
        imageView =(ImageView) findViewById(R.id.imageView);

        registerForContextMenu(imageView);
        nextActivityBotton.setOnClickListener(this);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.imageView:
                menu.add (0, ANIM,0, "Weeeeeeee");
                menu.add(0,ALPHAUSE,0,"ALPHAUSE");
                menu.add(0,ROTATEUSE,0,"ROTATEUSE");
                menu.add(0,SCALEUSE,0,"SCALEUSE");
                menu.add(0,TRANSLATEUSE,0, "TRANSLATEUSE");
                break;


        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()){
            case ANIM:
                anim  = AnimationUtils.loadAnimation(this, R.anim.anim);
                break;
            case ALPHAUSE:
                anim  = AnimationUtils.loadAnimation(this, R.anim.alphause);
                break;
            case ROTATEUSE:
                anim  = AnimationUtils.loadAnimation(this, R.anim.rotateuse);
                break;
            case SCALEUSE:
                anim  = AnimationUtils.loadAnimation(this, R.anim.scaleuse);
                break;
            case TRANSLATEUSE:
                anim  = AnimationUtils.loadAnimation(this, R.anim.translateuse);
                break;

        }
        imageView.startAnimation(anim);
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent questionIntent;
        switch (view.getId()) {
            case R.id.nextActivityBotton:
                questionIntent = new Intent(Activity2.this, Activity3.class);
                startActivityForResult(questionIntent, 0);
                overridePendingTransition(R.anim.start_next_activity,R.anim.finish_this_activity);
                break;
            default:
                break;
        }
    }
}
