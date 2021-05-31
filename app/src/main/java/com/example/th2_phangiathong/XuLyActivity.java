package com.example.th2_phangiathong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.th2_phangiathong.model.PhepToan;

public class XuLyActivity extends AppCompatActivity {
    double kq = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_ly);
        //Show icon backhome
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Đọc thông tin hesoa, hesob từ main gửi qua.
        Intent in = getIntent();
        //Đọc biến
        String a = in.getStringExtra("hesoa");
        String b = in.getStringExtra("hesob");
        String dau = in.getStringExtra("dau");
        try {
            if (dau.equals("+")) {
                double hsa = Double.parseDouble(a);
                double hsb = Double.parseDouble(b);
                kq = PhepToan.tong(hsa, hsb);
            } else if (dau.equals("-")) {
                double hsa = Double.parseDouble(a);
                double hsb = Double.parseDouble(b);
                kq = PhepToan.tru(hsa, hsb);
            }else if (dau.equals("*")) {
                double hsa = Double.parseDouble(a);
                double hsb = Double.parseDouble(b);
                kq = PhepToan.nhan(hsa, hsb);
            }else if (dau.equals("/")) {
                double hsa = Double.parseDouble(a);
                double hsb = Double.parseDouble(b);
                kq = PhepToan.chia(hsa, hsb);
            }else if (dau.equals("%")) {
                double hsa = Double.parseDouble(a);
                double hsb = Double.parseDouble(b);
                kq = PhepToan.chiadu(hsa, hsb);
            }
        }catch (Exception ie){
            Toast.makeText(this,"Nhập lỗi", Toast.LENGTH_SHORT).show();
        }
        //Tạo đối tượng Intent để trả về cho Main
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", kq); //Data trả về cho MainActivity
        setResult(RESULT_OK,resultIntent); //Kết quả xử lý ok
        //finish(); //Đóng Activity
    }
    //Icon backhome làm việc.
    //Nhận biết được mình nhấn Icon nào.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}