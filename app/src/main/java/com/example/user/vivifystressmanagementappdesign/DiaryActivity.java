package com.example.user.vivifystressmanagementappdesign;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiaryActivity extends AppCompatActivity {

//TODO this activity still misses a method + app element that can delete diary entries
    ListView listView;
    String formattedDate;

    private String dirGet() {
        PackageManager m = getPackageManager();
        String s = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }
        return s;
    }


    //Retrieves all non directory files in the getFilesDir() space an returns them in a List<File>
    public List<File> diaryEntryRetrieval(){
        List<File> result = new ArrayList<File>();
        for(File file : getFilesDir().listFiles()){
            if(!file.isDirectory()){
                result.add(file);
            }
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c.getTime());
        listView = (ListView) findViewById(R.id.listv);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                String item = (String) adapter.getItemAtPosition(position);
                Intent editNoteContinue = new Intent(DiaryActivity.this, OpenDiaryEntryActivity.class);
                editNoteContinue.putExtra("PASSED_FILENAME", item);
                DiaryActivity.this.startActivity(editNoteContinue);
            }

        });
        List<File> listOfDiaryFiles = diaryEntryRetrieval();

        System.out.println("onCreate;");
        if (listOfDiaryFiles.size() > 0) {
            Button newNotebtn = (Button) findViewById(R.id.btnNewNote);
            Boolean todayExists =false;
            String compareString =formattedDate;
            for (File file : listOfDiaryFiles){
                System.out.println("Compare this\n"+file.getName()+"\n"+compareString);
                if(file.getName().equals(compareString)){
                    System.out.println("mikon");
                    todayExists = true;
                    break;
                }
            }
            if (todayExists){
                newNotebtn.setText("Edit today\'s entry...");
                System.out.println("text was set");
            }else if(!todayExists && !newNotebtn.getText().equals("Make entry...")){
                newNotebtn.setText("Make entry...");
            }
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
            listView.setAdapter(itemsAdapter);
            //At the moment, the diary entries are not sorted in the list on date.
            for (int i = 0; i < listOfDiaryFiles.size(); i++) {
                if (listOfDiaryFiles.get(i).isFile()) {
                    /*TextView tv = new TextView(this);*/
                    String entryName = listOfDiaryFiles.get(i).getName();
                    itemsAdapter.add(entryName);
                    /*tv.setText(entryName.substring(0, entryName.length() - 5));*/
                    System.out.println(entryName + " was added to the diary list");
                }
            }
            itemsAdapter.notifyDataSetChanged();
        } else {
            System.out.println("There are no diary entries found in the diaryEntries folder");
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void editNote(View view){
        Intent editNoteContinue = new Intent(DiaryActivity.this, OpenDiaryEntryActivity.class);
        editNoteContinue.putExtra("PASSED_FILENAME", formattedDate);
        DiaryActivity.this.startActivity(editNoteContinue);
    }

}
