package com.example.admin.hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity3 extends TopMenu implements View.OnClickListener{

    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        imageView1 = (ImageView )findViewById(R.id.imageView1);
        imageView2 = (ImageView )findViewById(R.id.imageView2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Animation anim=null;
        switch (view.getId()) {
            case R.id.imageView1:
                anim = AnimationUtils.loadAnimation(this, R.anim.set_activity3);
                break;
            case R.id.imageView2:
                anim = AnimationUtils.loadAnimation(this, R.anim.set2_activity3);
                break;
            default:
                break;
        }
        imageView1.startAnimation(anim);
        imageView2.startAnimation(anim);
    }

}
