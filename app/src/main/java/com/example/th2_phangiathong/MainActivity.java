package com.example.th2_phangiathong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txta, txtb, txtkq;
    Button btnAdd, btnSub, btnnhan, btnchia, btnlamlai, btnchiadu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txta=findViewById(R.id.txta);
        txtb=findViewById(R.id.txtb);
        txtkq=findViewById(R.id.txtkq);
        btnAdd=findViewById(R.id.btnadd);
        btnSub=findViewById(R.id.btnsub);
        btnnhan=findViewById(R.id.btnnhan);
        btnchia=findViewById(R.id.btnchiahet);
        btnlamlai=findViewById(R.id.btnLamLai);
        btnchiadu=findViewById(R.id.btnchiadu);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cach 1
//                double a = Double.parseDouble(txta.getText().toString());
//                double b = Double.parseDouble(txtb.getText().toString());
//                txtkq.setText("" + PhepToan.tong(a,b));

                //Cach 2
                Intent in = new Intent(getApplicationContext(),XuLyActivity.class);
                //Làm sao truyền giá trị a, b này sang XuLyAcivity
                in.putExtra("hesoa", txta.getText().toString());
                in.putExtra("hesob", txtb.getText().toString());
                in.putExtra("dau", "+");
                startActivityForResult(in,100);
            }
        });

        //Làm dấu trừ
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),XuLyActivity.class);
                //Làm sao truyền giá trị a, b này sang XuLyAcivity
                in.putExtra("hesoa", txta.getText().toString());
                in.putExtra("hesob", txtb.getText().toString());
                in.putExtra("dau", "-");
                startActivityForResult(in,101);
            }
        });

        //Làm dấu nhân
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),XuLyActivity.class);
                //Làm sao truyền giá trị a, b này sang XuLyAcivity
                in.putExtra("hesoa", txta.getText().toString());
                in.putExtra("hesob", txtb.getText().toString());
                in.putExtra("dau", "*");
                startActivityForResult(in,102);
            }
        });

        //Làm dấu chia hết
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),XuLyActivity.class);
                //Làm sao truyền giá trị a, b này sang XuLyAcivity
                in.putExtra("hesoa", txta.getText().toString());
                in.putExtra("hesob", txtb.getText().toString());
                in.putExtra("dau", "/");
                startActivityForResult(in,103);
            }
        });

        //Làm dáu chia dư
        btnchiadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),XuLyActivity.class);
                //Làm sao truyền giá trị a, b này sang XuLyAcivity
                in.putExtra("hesoa", txta.getText().toString());
                in.putExtra("hesob", txtb.getText().toString());
                in.putExtra("dau", "%");
                startActivityForResult(in,104);
            }
        });

        btnlamlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txta.setText("");
                txtb.setText("");
                txtkq.setText("");

                txta.requestFocus();
            }
        });
    }

    //Hàm này dùng để nhận biêt được kết quả các biến mà bên XuLy gửi về
    //Observer design pattern
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==100) {
                if(resultCode==RESULT_OK) {
                    double kq = data.getDoubleExtra("result", 0);
                    txtkq.setText("" + kq);
                }else if(resultCode==RESULT_CANCELED) {
                    Toast.makeText(this,"Xử lý lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            if(requestCode==101) {
                if(resultCode==RESULT_OK) {
                    double kq = data.getDoubleExtra("result", 0);
                    txtkq.setText("" + kq);
                }else if(resultCode==RESULT_CANCELED) {
                    Toast.makeText(this,"Xử lý lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            if(requestCode==102) {
                if(resultCode==RESULT_OK) {
                    double kq = data.getDoubleExtra("result", 0);
                    txtkq.setText("" + kq);
                }else if(resultCode==RESULT_CANCELED) {
                    Toast.makeText(this,"Xử lý lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            if(requestCode==103) {
                if(resultCode==RESULT_OK) {
                    double kq = data.getDoubleExtra("result", 0);
                    txtkq.setText("" + kq);
                }else if(resultCode==RESULT_CANCELED) {
                    Toast.makeText(this,"Xử lý lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            if(requestCode==104) {
                if(resultCode==RESULT_OK) {
                    double kq = data.getDoubleExtra("result", 0);
                    txtkq.setText("" + kq);
                }else if(resultCode==RESULT_CANCELED) {
                    Toast.makeText(this,"Xử lý lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(this,ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}