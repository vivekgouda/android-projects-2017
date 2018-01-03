package com.gouda.vivek.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItem = new ArrayList<>();

//        ListItem item1 = new ListItem("Movie 1","It about some crazy...","Wow ! Great !");
//        ListItem item2 = new ListItem("Movie 2","It about some you...","Wow !");

        for (int i=0 ; i<10 ; i++) {

            ListItem list = new ListItem(
                    "Item" + i+1,
                    "Description",
                    "Excellent"
            );
        }

//        listItem.add(item1);
//        listItem.add(item2);

        adapter = new MyAdapter(this,listItem);
        recyclerView.setAdapter(adapter);
    }
}
