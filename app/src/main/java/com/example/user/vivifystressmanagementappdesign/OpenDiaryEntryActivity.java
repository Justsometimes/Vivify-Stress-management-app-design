package com.example.user.vivifystressmanagementappdesign;

import android.app.ActionBar;
import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class OpenDiaryEntryActivity extends AppCompatActivity {
/*
This is the activity that opens when the user either create or edits a diary entry
Ideally the save and open methods would have their own java classes, but the creation of this app was a little rushed.
If you want to rewrite this part of the app, I recommend using this site I found a little to late (after finishing)
https://www.androidauthority.com/lets-build-a-simple-text-editor-for-android-773774/
*/

    MultiAutoCompleteTextView noteText;
    String filename;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_diary_entry);
        noteText = (MultiAutoCompleteTextView) findViewById(R.id.mACTv);
        TextView tvEntryTitle = (TextView) findViewById(R.id.tvEntryTitle);
        filename = getIntent().getStringExtra("PASSED_FILENAME");

        if(filename != null){
            tvEntryTitle.setText(filename);
            //TODO buffered reader
            try {
                BufferedReader reader = new BufferedReader(new FileReader(getFilesDir() + File.separator + filename));
                String line;
                MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView) findViewById(R.id.mACTv);
                while((line = reader.readLine()) != null){
                    mactv.setText(line);
                }
            } catch (IOException e){
                e.getStackTrace();
                System.out.println("Something went wrong during the content extraction of the old entry");
            }
        }else{
            Calendar c = Calendar.getInstance();
            String formattedDate;
            System.out.println("Current time => " + c.getTime());
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            formattedDate = df.format(c.getTime());
            filename = formattedDate;
        }
    }

    //Instead of creating a button listener in the java file, you can also create an android:onClick
    //action in the xml file that will trigger the given method
    public void saveButton(View view){
        String noteEntryText = noteText.getText().toString();

        try {
            PrintWriter writer = new PrintWriter(getFilesDir()+ File.separator+filename);
            String userText = ((MultiAutoCompleteTextView) findViewById(R.id.mACTv)).getText().toString();
            writer.print(userText);
            writer.close();
            Toast.makeText(this, "Entry Saved!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent editNoteContinue = new Intent(OpenDiaryEntryActivity.this, DiaryActivity.class);
        OpenDiaryEntryActivity.this.startActivity(editNoteContinue);
        System.out.println("Entry: "+filename+" has been saved.");
    }

    //This button simple returns to the diary activity discarding current changes made when opened again
    //TODO why doesnt this work, it is identical to the save button!?
    public void cancelButton(View view){
        Intent editNoteContinue = new Intent(OpenDiaryEntryActivity.this, DiaryActivity.class);
        OpenDiaryEntryActivity.this.startActivity(editNoteContinue);
        System.out.println("Entry has been discarded");
    }

}
