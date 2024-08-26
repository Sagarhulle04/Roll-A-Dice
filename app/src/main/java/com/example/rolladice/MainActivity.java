package com.example.rolladice;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int id = 0, id1 = 0;
    private Animation fadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView i, j;
        Button b, b1;
        TextView t, t1, t2;

        i = findViewById(R.id.imageView);
        j = findViewById(R.id.imageView2);
        b = findViewById(R.id.button);
        b1 = findViewById(R.id.button2);
        t = findViewById(R.id.textView);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);

        // Load the fade-in animation
        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int n = r.nextInt(6) + 1;

                switch (n) {
                    case 1: {
                        i.setImageResource(R.drawable.dice1);
                        id = 1;
                        break;
                    }
                    case 2: {
                        i.setImageResource(R.drawable.dice2);
                        id = 2;
                        break;
                    }
                    case 3: {
                        i.setImageResource(R.drawable.dice3);
                        id = 3;
                        break;
                    }
                    case 4: {
                        i.setImageResource(R.drawable.dice4);
                        id = 4;
                        break;
                    }
                    case 5: {
                        i.setImageResource(R.drawable.dice5);
                        id = 5;
                        break;
                    }
                    case 6: {
                        i.setImageResource(R.drawable.dice6);
                        id = 6;
                        break;
                    }
                }
                i.startAnimation(fadeInAnimation);  // Start the animation
                t.setText(id + "");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int n = r.nextInt(6) + 1;

                switch (n) {
                    case 1: {
                        j.setImageResource(R.drawable.dice1);
                        id1 = 1;
                        break;
                    }
                    case 2: {
                        j.setImageResource(R.drawable.dice2);
                        id1 = 2;
                        break;
                    }
                    case 3: {
                        j.setImageResource(R.drawable.dice3);
                        id1 = 3;
                        break;
                    }
                    case 4: {
                        j.setImageResource(R.drawable.dice4);
                        id1 = 4;
                        break;
                    }
                    case 5: {
                        j.setImageResource(R.drawable.dice5);
                        id1 = 5;
                        break;
                    }
                    case 6: {
                        j.setImageResource(R.drawable.dice6);
                        id1 = 6;
                        break;
                    }
                }
                j.startAnimation(fadeInAnimation);  // Start the animation
                t1.setText(id1 + "");

                if (id > id1) {
                    t2.setText("Player 1 is Winner");
                } else if (id < id1) {
                    t2.setText("Player 2 is Winner");
                } else {
                    t2.setText("Match Draw");
                }
            }
        });
    }
}
