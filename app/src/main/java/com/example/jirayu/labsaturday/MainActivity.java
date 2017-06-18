package com.example.jirayu.labsaturday;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    String[] contry;
    Spinner spinnerCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCountry = (Spinner)findViewById(R.id.spinner);
        contry = getResources().getStringArray(R.array.country_array);
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>
                (this,android.R.layout.simple_dropdown_item_1line,contry);//เอาcountry มายัดไว้นี่
        spinnerCountry.setAdapter(adapterCountry);//แล้วเอามายับไว้นี่ต่อ
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//สร้างที่เราเลือก
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String CountryName = contry[position];//ถ้าไม่ได้เลือก
              //Toast.makeText(MainActivity.this,contry[position],Toast.LENGTH_LONG).show();  //Toast ที่มันเด้งขึ้นมา แสดงที่เราเลือก

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {   }
        });


         Button buttonCountry = (Button) findViewById(R.id.button);//เรียกใช้ปุ่ม
           buttonCountry.setOnClickListener(new View.OnClickListener() {//สร้างonclick
               @Override
               public void onClick(View v) {
                   String CountryName = spinnerCountry.getSelectedItem().toString();//แปลเป็นstring
                  /* Toast.makeText(MainActivity.this,CountryName,Toast.LENGTH_LONG).show(); //แสดงในหน้า เมื่อกดปุ่ม
                   ////
                   AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                   builder.setTitle("country");
                   builder.setMessage(CountryName);

                   builder.show(); //เด้งหน้าใชว์เป็นคำที่เลือก
                    ////
                   */
                   Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                   intent.putExtra("spinner",CountryName);
                   startActivity(intent);



              }
           });

        }



    }

