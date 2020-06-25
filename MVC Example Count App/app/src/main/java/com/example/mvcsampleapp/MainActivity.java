package com.example.mvcsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private Model model;
    private Button button1, button2, button3;
    private TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model();
        model.addObserver(this);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setDataAtIndex(0);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model.setDataAtIndex(1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setDataAtIndex(2);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        button1.setText("COUNT : "+model.getDataAtIndex(0));
        button2.setText("COUNT : "+model.getDataAtIndex(1));
        button3.setText("COUNT : "+model.getDataAtIndex(2));

    }
}
