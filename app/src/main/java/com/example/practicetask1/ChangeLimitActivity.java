package com.example.practicetask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeLimitActivity extends AppCompatActivity {
    private TextView textLimit;
    private EditText inputLimit;
    private Button changeLimit;
    private Button goBack;
    private TextView textError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_limit);
        SetUi();
        String newLimit = getIntent().getStringExtra("limit");
        if(newLimit!=null){
            textLimit.setText(newLimit);
        }
        changeLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputLimit.getText().toString().length() !=0){
                    try{
                        Integer num = Integer.parseInt(inputLimit.getText().toString());
                        textLimit.setText(Integer.toString(num));
                        inputLimit.setText("");
                        textError.setText("");
                    }catch(NumberFormatException e){
                        textError.setText("It should be an integer!!!");
                    }
                }
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeLimitActivity.this,MainActivity.class);
                intent.putExtra("NewLimit",textLimit.getText().toString());
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChangeLimitActivity.this, MainActivity.class);
        intent.putExtra("NewLimit", textLimit.getText().toString());
        startActivity(intent);
        super.onBackPressed();
    }
    private void SetUi(){
        textLimit = findViewById(R.id.textLimit);
        inputLimit = findViewById(R.id.inputText);
        changeLimit = findViewById(R.id.LimitButton);
        goBack = findViewById(R.id.GoBack);
        textError = findViewById(R.id.textError);
    }
}