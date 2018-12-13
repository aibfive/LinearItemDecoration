package com.sandu.linearitemdecoration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        List<String> list = new ArrayList<>();
        list.add("数据----->1");
        list.add("数据----->2");
        list.add("数据----->3");
        list.add("数据----->4");
        list.add("数据----->5");
        list.add("数据----->6");
        list.add("数据----->7");
        recyclerView.setAdapter(new RecyclerViewAdapter(this, list));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new LinearItemDecoration(this));
    }
}
