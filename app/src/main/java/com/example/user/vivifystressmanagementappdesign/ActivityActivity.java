package com.example.user.vivifystressmanagementappdesign;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
    }

    //Instead of creating a button listener in the java file, you can also create an android:onClick
    //action in the xml file that will trigger the given method

    public void showAlert(View view) {

        //This is the template for the alertDialog aka popup message. This is not active outside of
        //of the app yet though. Additionally you'll have to move this bit of code (or refer to it)
        //somewhere else where you'd want to run it instead of just having it attached to this button.

        AlertDialog.Builder statusMeassureAD = new AlertDialog.Builder(this);
        statusMeassureAD.setMessage("yo what the fuck up, kontpiraat here");
        statusMeassureAD.setNegativeButton("I'm Dying!", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i){

                //Ofcourse here you want to do something else and pass variables to somewhere and
                //open another appropriate activity

                dialog.dismiss();
            }
        })
                .setNeutralButton("Not much", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i){
                //...
                dialog.dismiss();
            }
        })
                .setPositiveButton("Wazzaah!", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i){
                //...
                dialog.dismiss();
            }
        })
                .setTitle("some nice ass you got there")
                //.setIcon()   can be used to put a little icon in the top left of the window.
                //You can set this icon image by putting the image in the drawable folder and
                //refering to it with R.drawable.[IMAGE NAME]
                .create();
        statusMeassureAD.show();
    }
}
