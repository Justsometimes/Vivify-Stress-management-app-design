package com.example.user.vivifystressmanagementappdesign;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //public static void buttonEffect(View button){
    //  button.setOnTouchListener(new View.OnTouchListener() {

    //public boolean onTouch(View v, MotionEvent event) {
    //  switch (event.getAction()) {
    //    case MotionEvent.ACTION_DOWN: {
    //      v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
    //    v.invalidate();
    //  break;
    //}
    //case MotionEvent.ACTION_UP: {
    //  v.getBackground().clearColorFilter();
    //v.invalidate();
    // break;
    //}
    //}
    //return false;
    //}
    //});
    //}
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
