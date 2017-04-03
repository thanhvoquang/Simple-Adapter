package com.example.vothanhquang.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<HashMap<String, String>> alData;
    HashMap<String, String> hashMap;
    //du lieu
    String[] name = {"Thanh", "Tuong", "Bao", "Thuc", "Chung"};
    String[] language = {"iOS", "Android", "PHP", "GameUnity", "C"};
    String[] rate = {"Good", "Good", "Good", "Good", "Good"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        listView = (ListView) this.findViewById(R.id.listView);
        alData = new ArrayList<>();
        //gan vao arraylist
        for (int i = 0; i < name.length; i++) {
            hashMap = new HashMap<>();
            hashMap.put("name", name[i]);
            hashMap.put("language", language[i]);
            hashMap.put("rate", rate[i]);
            alData.add(hashMap);
        }
        //gan vao adapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, alData, R.layout.item_child, new String[]{"name",
                "language", "rate"},
                new int[]{R.id.TextView_Name, R.id.TextView_Language, R.id.TextView_Rate});
        //tu adapter gan vao listview
        listView.setAdapter(simpleAdapter);
        //su kien khi click vao 1 item listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, name[position]+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
