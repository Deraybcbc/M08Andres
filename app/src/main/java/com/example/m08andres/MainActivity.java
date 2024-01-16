package com.example.m08andres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Lista> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        listado = new ArrayList<>();
        listado.add(new Lista("Andres","Orellana","Barcelona"));
            listado.add(new Lista("Gio","Tipan","Rabat"));
            listado.add(new Lista("Pablo","Jiménez","Madrid"));
            listado.add(new Lista("Jheremy","Pinto","Sucre"));
            listado.add(new Lista("Kevin","Deray","Ambato"));

            CustomAdapter customAdapter = new CustomAdapter(listado, this);
            RecyclerView reciclerView = findViewById(R.id.recyclerView);
            reciclerView.setHasFixedSize(true);
            reciclerView.setLayoutManager(new LinearLayoutManager(this));
            reciclerView.setAdapter(customAdapter);
    }
}