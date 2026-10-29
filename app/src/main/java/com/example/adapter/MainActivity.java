package com.example.adapter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

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
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recyclerview);

        ArrayList<Item> myList = new ArrayList<Item>();
        Item item = new Item("house", "9");
        myList.add(item);
        myList.remove(1);
        item = myList.get(1);

        for (int i = 0; i < myList.size() ; i++)
            System.out.println(myList.get(i).toString());

        for (Item currentItem : myList)
            System.out.println(currentItem.toString());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apples", 50);
        map.put("Bananas", 30);
        if (map.containsKey("Bananas")) {

        }
        Integer removedValue = map.remove("Apples");

        for (String i : map.keySet() /* map.values()*/ ) {

            System.out.println(i);

        }


        MyAdapter adapter = new MyAdapter(myList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}