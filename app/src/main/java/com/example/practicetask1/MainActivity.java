package com.example.practicetask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button increaseBtn;
    private Button decreaseBtn;
    private Button resetBtn;
    private Button GoToNextActivity;
    private TextView limitText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUI();

        String newLimit = getIntent().getStringExtra("NewLimit");
        if(newLimit!=null){
            limitText.setText(newLimit);
        }

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(textView.getText().toString()) < Integer.parseInt(limitText.getText().toString())){
                    String newText = Integer.toString(Integer.parseInt(textView.getText().toString())+1);
                    textView.setText(newText);
                }
            }
        });
        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(textView.getText().toString())!=0){
                    String newText = Integer.toString(Integer.parseInt(textView.getText().toString())-1);
                    textView.setText(newText);
                }
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("0");
            }
        });
        GoToNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChangeLimitActivity.class);
                intent.putExtra("limit",limitText.getText());
                startActivity(intent);
            }
        });
    }

    private void SetUI(){
        textView = findViewById(R.id.textView);
        increaseBtn = findViewById(R.id.increase);
        decreaseBtn = findViewById(R.id.decrease);
        resetBtn = findViewById(R.id.reset);
        GoToNextActivity = findViewById(R.id.GoToLimitActivity);
        limitText = findViewById(R.id.LimitText);

    }
}