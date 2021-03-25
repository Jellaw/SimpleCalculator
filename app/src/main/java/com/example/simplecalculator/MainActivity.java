package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button cal;
    private EditText edt1, edt2;
    private TextView result;
    private Spinner spinner;
    Float a,b,rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        spinner.setOnItemSelectedListener(this);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Float.parseFloat(edt1.getText().toString());
                b= Float.parseFloat(edt2.getText().toString());
                int i = spinner.getSelectedItemPosition();
                if (i==0) rel = a+b;
                if (i==1) rel = a-b;
                if (i==2) rel = a*b;
                if (i==3){
                    if(b==0){
                        Toast.makeText(getApplicationContext(), "Nhap lai b khac 0 " , Toast.LENGTH_LONG).show();
                        result.setText("N/A");
                    } else {
                        rel = a/b;
                        result.setText(rel.toString());
                    }
                } else
                result.setText(rel.toString());
            }
        });
    }
    private void init(){
        cal = findViewById(R.id.Addbutton);
        edt1 = findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
        spinner = findViewById(R.id.spinner);
        result = findViewById(R.id.result);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(adapterView.getContext(), "Selected: " + i, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}