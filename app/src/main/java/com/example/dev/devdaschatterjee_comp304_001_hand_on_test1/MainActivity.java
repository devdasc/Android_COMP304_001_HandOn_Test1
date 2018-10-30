package com.example.dev.devdaschatterjee_comp304_001_hand_on_test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button1;
    private ImageView imageView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        imageView=findViewById(R.id.imageView);
        button1=findViewById(R.id.button1);

    }
    public void onSelectExercise(View v){
        Intent intent=new Intent(this,BrainActivity.class);
        startActivity(intent);
    }
}
