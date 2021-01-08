package com.example.phuongtrinhbachai_haimanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {
    EditText txta,txtsob,txtsoc;
    Button kq,btnExit;
    float a,b,c,x1,x2;
    float delta;
    String nghiem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txta = (EditText) findViewById(R.id.txtsoa);
        txtsob = (EditText) findViewById(R.id.txtsob);
        txtsoc = (EditText) findViewById(R.id.txtSoc);
        if (1 >0) {
            kq = (Button) findViewById(R.id.btnKetQua);
            btnExit = (Button) findViewById(R.id.btnThoat);
            kq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    a = txta.getText().toString() == null ? 0 : parseFloat(txta.getText().toString());
                    b = txtsob.getText().toString() == null ? 0 : parseFloat(txtsob.getText().toString());
                    c = txtsoc.getText().toString() == null ? 0 : parseFloat(txtsoc.getText().toString());
                    if (a == 0) {
                        if (b == 0) {
                            nghiem = "Phương trình vô nghiệm";
                        } else {
                            nghiem = "Phương trình có một nghiệm: x = " + (-c / b) + "";

                        }
                    }
                    else {
                        delta = b * b - 4 * a * c;
                        if (delta > 0) {
                            x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                            x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                            nghiem = "Phương trình có 2 nghiệm là: X1 =" + x1 + " và X2= " + x2 + " ";
                        }
                        else{
                            if (delta == 0) {
                                x1 = (-b / (2 * a));
                                nghiem="Phương trình có nghiệm kép:  X1=X2 ="+x1+"";
                            } else {
                                nghiem="Phương trình vô nghiệm!";
                            }
                        }

                    }

                    Intent i = new Intent(MainActivity.this, KetQuan.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("kq",nghiem);
                    i.putExtra("ten",bundle);
                    startActivity(i);
                }

            });
            btnExit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    
                    finish();
                }
            });

        }
    }

}