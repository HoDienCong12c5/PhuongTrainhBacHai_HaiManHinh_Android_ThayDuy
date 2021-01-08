package com.example.phuongtrinhbachai_haimanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KetQuan extends AppCompatActivity {

    EditText kqq;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_quan);
        Intent intent = getIntent();
        Bundle  args = intent.getBundleExtra("ten");
        String kq =args.getString("kq");
        kqq=(EditText)findViewById(R.id.txtNghiem);
        kqq.setText(kq);
        btnExit=(Button)findViewById(R.id.btnThoat);
        btnExit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}