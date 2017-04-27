package com.example.alanabundis.vectores;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    EditText Ep1i;
    EditText Ep1j;
    EditText Ep1k;
    EditText Ep2i;
    EditText Ep2j;
    EditText Ep2k;
    EditText Ep3i;
    EditText Ep3j;
    EditText Ep3k;
    TextView txtNoEx;
    TextView txtEx;
    TextView txtDif;
    double p1i;
    double p1j;
    double p1k;
    double p2i;
    double p2j;
    double p2k;
    double p3i;
    double p3j;
    double p3k;

    double mag1;
    double mag2;
    double noEx;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNoEx=(TextView)findViewById(R.id.noEx);
        txtEx=(TextView)findViewById(R.id.ex);
        txtDif=(TextView)findViewById(R.id.dif);
        calcular=(Button)findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Ep1i=(EditText) findViewById(R.id.p1i);
                    Ep1j=(EditText)findViewById(R.id.p1j);
                    Ep1k=(EditText)findViewById(R.id.p1k);
                    Ep2i=(EditText)findViewById(R.id.p2i);
                    Ep2j=(EditText)findViewById(R.id.p2j);
                    Ep2k=(EditText)findViewById(R.id.p2k);
                    Ep3i=(EditText)findViewById(R.id.p3i);
                    Ep3j=(EditText)findViewById(R.id.p3j);
                    Ep3k=(EditText)findViewById(R.id.p3k);

                    p1i=Double.parseDouble(Ep1i.getText().toString());
                    p1j=Double.parseDouble(Ep1j.getText().toString());
                    p1k=Double.parseDouble(Ep1k.getText().toString());
                    p2i=Double.parseDouble(Ep2i.getText().toString());
                    p2j=Double.parseDouble(Ep2j.getText().toString());
                    p2k=Double.parseDouble(Ep2k.getText().toString());
                    p3i=Double.parseDouble(Ep3i.getText().toString());
                    p3j=Double.parseDouble(Ep3j.getText().toString());
                    p3k=Double.parseDouble(Ep3k.getText().toString());

                    double[] v1={p1i-p2i,p1j-p2j,p1k-p2k};
                    double[] v2={p2i-p3i,p2j-p3j,p2k-p3k};
                    double[] v3={p1i-p3i,p1j-p3j,p1k-p3k};


                    mag1=Math.sqrt(Math.pow(v1[0],2)+Math.pow(v1[1],2)+Math.pow(v1[2],2));
                    mag2=Math.sqrt(Math.pow(v3[0],2)+Math.pow(v3[1],2)+Math.pow(v3[2],2));

                    noEx=mag1*mag2;
                    txtNoEx.setText(Double.toString(noEx));

                    double[] r1= {
                            (v1[1]*v2[2])-(v2[1]*v1[2]),
                            (v1[0]*v2[2])-(v2[0]*v1[2]),
                            (v1[0]*v2[1])-(v2[0]*v1[1])
                    };
                    double[] r2={
                            (v1[1]*v3[2])-(v3[1]*v1[2]),
                            (v1[0]*v3[2])-(v3[0]*v1[2]),
                            (v1[0]*v3[1])-(v3[0]*v1[1])
                    };

                    double res1 = Math.sqrt(Math.pow(r1[0],2)+Math.pow(r1[1],2)+Math.pow(r1[2],2));
                    double res2 = Math.sqrt((r2[0]*r2[0])-(r2[1]*r2[1])+(r2[2]*r2[2]));

                    double ex=res1;
                    txtEx.setText(Double.toString(ex));
                    double dif=noEx-ex;
                    txtDif.setText(Double.toString(dif));
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(),ex.toString(),Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
