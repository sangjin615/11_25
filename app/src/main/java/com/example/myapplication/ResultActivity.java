package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    String[] description = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞에 소녀들", "해변에서"};
    int[] imageFileId = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};

    int[] ratingbar = {R.id.ratingBar1,R.id.ratingBar2,R.id.ratingBar3,R.id.ratingBar4,R.id.ratingBar5,R.id.ratingBar6,R.id.ratingBar7,R.id.ratingBar8,R.id.ratingBar9};
    RatingBar[] ratingBars = new RatingBar[9];
    int index;
    int[] ratings;

    ImageView resultImg;
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표결과");

        Button returnBtn = (Button) findViewById(R.id.btnReturn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        index = Integer.parseInt(intent.getStringExtra("index"));
        ratings = intent.getIntArrayExtra("ratings");

        for(int i = 0; i < 9; i++){
            ratingBars[i] = (RatingBar) findViewById(ratingbar[i]);
            ratingBars[i].setRating(ratings[i]);
        }

        resultImg = (ImageView) findViewById(R.id.resultImg);
        result = (TextView) findViewById(R.id.result);

        resultImg.setImageResource(imageFileId[index]);
        result.setText(description[index]);

    }
}
