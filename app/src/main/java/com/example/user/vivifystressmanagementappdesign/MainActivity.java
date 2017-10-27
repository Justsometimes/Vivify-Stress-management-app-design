package com.example.user.vivifystressmanagementappdesign;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    //This gives button visual feedback, when pressed
    public static void buttonEffect(View button) {
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {

                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button7 = (Button) findViewById(R.id.btnProfile);

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnProfile));
                Intent profileContinue = new Intent(MainActivity.this, UserAreaActivity.class);
                MainActivity.this.startActivity(profileContinue);
            }
        });
        final Button button8 = (Button) findViewById(R.id.btnDiary);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnDiary));
            }
        });
        final Button button9 = (Button) findViewById(R.id.btnSettings);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnSettings));
                Intent settingsContinue = new Intent(MainActivity.this, Settings.class);
                MainActivity.this.startActivity(settingsContinue);
            }
        });
        final Button button10 = (Button) findViewById(R.id.btnLivevitals);
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnLivevitals));
                Intent vitalsContinue = new Intent(MainActivity.this, LiveVitalsActivity.class);
                MainActivity.this.startActivity(vitalsContinue);
            }
        });
        final Button button11 = (Button) findViewById(R.id.btnGroups);
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnGroups));
                Intent groupsContinue = new Intent(MainActivity.this, activity_group.class);
                MainActivity.this.startActivity(groupsContinue);

            }
        });
        final Button button12 = (Button) findViewById(R.id.btnCoach);
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnCoach));
            }
        });
        final Button button13 = (Button) findViewById(R.id.btnActivity);
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEffect(findViewById(R.id.btnActivity));
                Intent activityContinue = new Intent(MainActivity.this, ActivityActivity.class);
                MainActivity.this.startActivity(activityContinue);
            }
        });
        Button btn12 = (Button) findViewById(R.id.btnCoach);

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, e_coach.class));
            }
        });

    }

    // A native method that is implemented by the 'native-lib' native library,
    // which is packaged with this application.
    public native String stringFromJNI();
}
