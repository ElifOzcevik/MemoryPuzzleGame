package com.example.elifozcevik.memorypuzzle;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BoardActivity extends AppCompatActivity {

    private int n;
    Button [][] board;
    Button b1,b2;
    TextView text, text2;


    char [] symbols;
    CountDownTimer timer1,timer2;
    int count=0;
    String level="";
    int ms=0;
    Random rand;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Intent myintent=getIntent();
        n=myintent.getIntExtra("boardSize",0);
        level=myintent.getStringExtra("level");
        LinearLayout rootLayout=findViewById(R.id.rootLay);


            rand=new Random();
            board=new Button[n][n];
            symbols=new char[n*n];




        if(n==2) {
            if(level.equals("easy")){
                for(int i=0;i<n*n;i++){
                    symbols[i]=(char)(65+i/2);

                }
                ms=6000;
            }
            else if(level.equals("normal"))  {
                for(int i=0;i<n*n;i++){
                    symbols[i]=(char)(65+i/2);

                }
                ms=4000;
            }
            else {
                for(int i=0;i<n*n;i++){
                    symbols[i]=(char)(65+i/2);

                }
                ms=2000;
            }
        }


        else if(n==4) {
                if(level.equals("easy")){
                                                    for(int i=0;i<n*n;i++){
                                                        symbols[i]=(char)(65+i/6);

                                                                         }
                                                     ms=6000;
                                                    }
                 else if(level.equals("normal"))  {
                                                    for(int i=0;i<n*n;i++){
                                                        symbols[i]=(char)(65+i/4);

                                                    }
                                                     ms=4000;
                                                }
                 else {
                            for(int i=0;i<n*n;i++){
                             symbols[i]=(char)(65+i/2);

                                                 }
                              ms=2000;
                        }
              }

         else {
                                if(level.equals("easy")){
                                    for(int i=0;i<n*n;i++){
                                        symbols[i]=(char)(65+i/8);
                                    }
                                    ms=6000;
                                }
                                else if(level.equals("normal"))  {
                                    for(int i=0;i<n*n;i++){
                                        symbols[i]=(char)(65+i/6);
                                    }
                                    ms=4000;
                                }
                                else {
                                    for(int i=0;i<n*n;i++){
                                        symbols[i]=(char)(65+i/2);
                                    }
                                    ms=2000;
                                }
                                }



            for(int i=0;i<10000;i++){
                int r1=rand.nextInt(n*n);
                int r2=rand.nextInt(n*n);
                char c=symbols[r1];
                symbols[r1]=symbols[r2];
                symbols[r2]=c;
            }

        int k=0;
            LinearLayout textLay= new LinearLayout(this);
            LinearLayout textLay2= new LinearLayout(this);
            textLay.setOrientation(LinearLayout.VERTICAL);
            textLay.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            textLay.setGravity(Gravity.CENTER);
            textLay2.setOrientation(LinearLayout.VERTICAL);
            textLay2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            textLay2.setGravity(Gravity.BOTTOM);
            text=new TextView(this);
            text2=new TextView(this);
            text2.setTextSize(30);
            text.setTextSize(30);

            textLay.addView(text);
            textLay2.addView(text2);
            rootLayout.addView(textLay);

        for(int i=0;i<n;i++){
            LinearLayout mylay=new LinearLayout(this);
            mylay.setOrientation(LinearLayout.HORIZONTAL);
            mylay.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            mylay.setGravity(Gravity.CENTER);
            for(int j=0;j<n;j++){
                Button b=new Button(this);
               // b.setTag(symboles.charAt(k)+"");
                b.setTag(symbols[k]+"");
                b.setTextSize(20);
                b.setLayoutParams(new LinearLayout.LayoutParams(100,120));
                mylay.addView(b);
                board[i][j]=b;
                k++;
            }

            rootLayout.addView(mylay);

        }
        rootLayout.addView(textLay2);
            timer2=new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    b1.setText("");
                    b2.setText("");
                    b1=b2=null;
                }
            };

            timer1=new CountDownTimer(ms,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            board[i][j].setText(" ");
                        }
                    }
                }
            };


    }
                protected  void onStart(){
                    super.onStart();
                   for(int i=0;i<n;i++){
                       for(int j=0;j<n;j++){
                            board[i][j].setText(board[i][j].getTag().toString());
                            timer1.start();
                                         }
                                        }
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            board[i][j].setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {

                                    count++;
                                    text.setText("Hamle sayısı "+count);


                                    Button b=(Button)v;
                                    if(b1==null){
                                        b1=b;
                                        b1.setText(b1.getTag().toString());
                                    }
                                    else  if(b2==null){
                                        b2=b;
                                        b2.setText(b2.getTag().toString());
                                        if (b1.getText().toString().equals(b2.getText().toString())){
                                            b1.setTextColor(Color.RED);
                                            b2.setTextColor(Color.RED);

                                            b1=b2=null;
                                        }
                                        else{
                                            timer2.start();
                                        }

                                    }

                                }

                            });
                        }

                    }

        }

}