package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtwt , edthtft , edthtin;
        Button btn;
        TextView res,fbmi;
        LinearLayout llid;

        llid=findViewById(R.id.llid);
        edtwt=findViewById(R.id.wt);
        edthtft=findViewById(R.id.htft);
        edthtin=findViewById(R.id.htin);
        btn=findViewById(R.id.btn);
        res=findViewById(R.id.res);
        fbmi=findViewById(R.id.fbmi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt=Integer.parseInt(edtwt.getText().toString());

                int ft=Integer.parseInt(edthtft.getText().toString());

                int in=Integer.parseInt(edthtin.getText().toString());

                int totalin=(ft*12)+in;
                double totalcm=totalin*2.53;
                double totalm=totalcm/100;

                double bmi=wt/(totalm*totalm);
                fbmi.setText(String.valueOf(bmi));
                if(bmi>18.5 && bmi<24.9 )
                {
                    res.setText("You are fit");
                    llid.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
                else if(bmi<18.5) {
                    res.setText("Underweight");
                    llid.setBackgroundColor(getResources().getColor(R.color.underweight));
                }
                else if(bmi>25 && bmi<29.9) {
                    res.setText("Overweight");
                    llid.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }
                else {
                    res.setText("Obesity");
                    llid.setBackgroundColor(getResources().getColor(R.color.obesity));
                }
            }
        });



    }
}