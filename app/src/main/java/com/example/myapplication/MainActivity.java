package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int rating[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    String[] description = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞에 소녀들", "해변에서"};
    Integer[] imgBtn = {R.id.pic1, R.id.pic2, R.id.pic3, R.id.pic4, R.id.pic5, R.id.pic6, R.id.pic7, R.id.pic8, R.id.pic9};
    ImageButton imageButtons[] = new ImageButton[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            setTitle("명화 선호도 투표");
            return insets;
        });


        for (int i = 0; i < 9; i++) {
            imageButtons[i] = (ImageButton) findViewById(imgBtn[i]);
            imageButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseRating(view);
                }
            });
        }

        Button resultBtn = (Button) findViewById(R.id.btn_result);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ResultActivity.class);
                Integer index = checkHighestRatingImage();
                intent.putExtra("ratings",rating);
                intent.putExtra("index",index.toString());
                startActivity(intent);
            }
        });
    }
        public void increaseRating(View v){
            int id = v.getId();
            if (id == R.id.pic1) {
                if (rating[0] < 10)
                {rating[0]++;
                Toast.makeText(getApplicationContext(),description[0] +": "+rating[0]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic2) {
                if (rating[1] < 10)
                {rating[1] = rating[1] + 1;
                    Toast.makeText(getApplicationContext(),description[1] +": "+rating[1]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic3) {
                if (rating[2] < 10)
                {rating[2]++;
                    Toast.makeText(getApplicationContext(),description[2] +": "+rating[2]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic4) {
                if (rating[3] < 10)
                {rating[3]++;
                    Toast.makeText(getApplicationContext(),description[3] +": "+rating[3]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic5) {
                if (rating[4] < 10)
                {rating[4]++;
                    Toast.makeText(getApplicationContext(),description[4] +": "+rating[4]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic6) {
                if (rating[5] < 10)
                {rating[5]++;
                    Toast.makeText(getApplicationContext(),description[5] +": "+rating[5]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic7) {
                if (rating[6] < 10)
                {rating[6]++;
                    Toast.makeText(getApplicationContext(),description[6] +": "+rating[6]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic8) {
                if (rating[7] < 10)
                {rating[7]++;
                    Toast.makeText(getApplicationContext(),description[7] +": "+rating[7]+"표",Toast.LENGTH_SHORT).show();}
            } else if (id == R.id.pic9) {
                if (rating[8] < 10)
                {rating[8]++;
                    Toast.makeText(getApplicationContext(),description[8] + ": "+rating[8]+"표",Toast.LENGTH_SHORT).show();}
            }
        }

    private int checkHighestRatingImage(){
        int highest = 0;
        int index = 0;
        for(int i = 0; i < 9; i++){
            if(rating[i] > highest) {
                index = i;
                highest = rating[i];
            }
        }
        return index;
    }
}