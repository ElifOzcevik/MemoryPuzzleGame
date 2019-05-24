package com.example.elifozcevik.memorypuzzle;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RadioButton easy,normal,hard;
    String level="";
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easy=findViewById(R.id.radioButton3);
        normal=findViewById(R.id.radioButton);
        hard=findViewById(R.id.radioButton2);


    }

    public void start(View v){
        EditText boardSize=findViewById(R.id.editText);
        Intent myintent=new Intent(this, BoardActivity.class);
        int n=Integer.parseInt(boardSize.getText().toString());

        if (easy.isChecked()){
            level="easy";
            myintent.putExtra("level",level);

        }

        if (normal.isChecked()){
            level="normal";
            myintent.putExtra("level",level);

        }

        if (hard.isChecked()){
            level="hard";
            myintent.putExtra("level",level);

        }




        if(n<2 || n>8 || n%2!=0){
            Toast.makeText(this, "Input value must be in range 2-8 and pair", Toast.LENGTH_SHORT).show();
            return;
        }

        myintent.putExtra("boardSize",n);
        startActivity(myintent);
    }


}
