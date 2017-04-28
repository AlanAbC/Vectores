package com.example.alanabundis.vectores;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    double ex;
    double dif;
    Button calcular;
    ProgressBar bar;
    int flag;
    Handler handler = new Handler(){
       @Override
        public void handleMessage(Message msg){
           if (flag == 10){
               Log.i("bandera",flag + "Calculando");
               txtNoEx.setText("Area no exacta: "+ Double.toString(noEx));
               txtEx.setText("Area Exacta: "+ Double.toString(ex));
               txtDif.setText("Diferencia: "+ Double.toString(dif));
               flag=0;
           }else{
               bar.incrementProgressBy(10);
               flag ++;
               Log.i("bandera", flag + "");
           }


       }
    };
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
                    bar = (ProgressBar)findViewById(R.id.progress);
                    p1i=Double.parseDouble(Ep1i.getText().toString());
                    p1j=Double.parseDouble(Ep1j.getText().toString());
                    p1k=Double.parseDouble(Ep1k.getText().toString());
                    p2i=Double.parseDouble(Ep2i.getText().toString());
                    p2j=Double.parseDouble(Ep2j.getText().toString());
                    p2k=Double.parseDouble(Ep2k.getText().toString());
                    p3i=Double.parseDouble(Ep3i.getText().toString());
                    p3j=Double.parseDouble(Ep3j.getText().toString());
                    p3k=Double.parseDouble(Ep3k.getText().toString());
                    bar.setVisibility(View.VISIBLE);

                    Thread hilo = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            double[] v1={p1i-p2i,p1j-p2j,p1k-p2k};
                            handler.sendMessage(handler.obtainMessage());
                            double[] v2={p2i-p3i,p2j-p3j,p2k-p3k};
                            handler.sendMessage(handler.obtainMessage());
                            double[] v3={p1i-p3i,p1j-p3j,p1k-p3k};
                            handler.sendMessage(handler.obtainMessage());


                            mag1=Math.sqrt(Math.pow(v1[0],2)+Math.pow(v1[1],2)+Math.pow(v1[2],2));
                            handler.sendMessage(handler.obtainMessage());
                            mag2=Math.sqrt(Math.pow(v3[0],2)+Math.pow(v3[1],2)+Math.pow(v3[2],2));
                            handler.sendMessage(handler.obtainMessage());

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Toast.makeText(getApplicationContext(), "Ocurrio algun error", Toast.LENGTH_SHORT).show();
                            }

                            noEx=mag1*mag2;
                            handler.sendMessage(handler.obtainMessage());

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Toast.makeText(getApplicationContext(), "Ocurrio algun error", Toast.LENGTH_SHORT).show();
                            }

                            double[] r1= {
                                    (v1[1]*v2[2])-(v2[1]*v1[2]),
                                    (v1[0]*v2[2])-(v2[0]*v1[2]),
                                    (v1[0]*v2[1])-(v2[0]*v1[1])
                            };
                            handler.sendMessage(handler.obtainMessage());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Toast.makeText(getApplicationContext(), "Ocurrio algun error", Toast.LENGTH_SHORT).show();
                            }

                            double[] r2={
                                    (v1[1]*v3[2])-(v3[1]*v1[2]),
                                    (v1[0]*v3[2])-(v3[0]*v1[2]),
                                    (v1[0]*v3[1])-(v3[0]*v1[1])
                            };
                            handler.sendMessage(handler.obtainMessage());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Toast.makeText(getApplicationContext(), "Ocurrio algun error", Toast.LENGTH_SHORT).show();
                            }


                            double res1 = Math.sqrt(Math.pow(r1[0],2)+Math.pow(r1[1],2)+Math.pow(r1[2],2));
                            handler.sendMessage(handler.obtainMessage());
                            double res2 = Math.sqrt((r2[0]*r2[0])-(r2[1]*r2[1])+(r2[2]*r2[2]));
                            handler.sendMessage(handler.obtainMessage());

                            ex=res1;
                            handler.sendMessage(handler.obtainMessage());

                            dif=noEx-ex;
                            handler.sendMessage(handler.obtainMessage());

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Toast.makeText(getApplicationContext(), "Ocurrio algun error", Toast.LENGTH_SHORT).show();
                            }
                            handler.sendMessage(handler.obtainMessage());
                            handler.sendMessage(handler.obtainMessage());

                        }
                    });
                    hilo.start();
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(),ex.toString(),Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
