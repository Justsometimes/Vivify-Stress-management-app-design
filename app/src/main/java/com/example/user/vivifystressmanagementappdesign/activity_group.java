package com.example.user.vivifystressmanagementappdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class activity_group extends AppCompatActivity {
    //Array of possible groups
    String[] groupArray = {"Family","Friends","Work","Other","Groups","Must","Fill","List","To","Display","Scrollability","Of","This","List","Almost","There","Just","A","Bit","More","Finally","Finished"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        ArrayAdapter adaptergroup = new ArrayAdapter<>(this,
                R.layout.activity_grouplist, groupArray);

        ListView listView = (ListView) findViewById(R.id.group_list);
        listView.setAdapter(adaptergroup);
    }
}
