package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerchange;
    private String[] iconName = { "Metre", "Celsius", "Kilograms"};
    private ArrayAdapter<String> arr_adapter;
    private List<String> data_list;
    private  String selectType;
    private EditText etInput;
    private TextView tvShow11,tvShow12,tvShow21,tvShow22,tvShow31,tvShow32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput=findViewById(R.id.et_input);
        spinnerchange=(Spinner)findViewById(R.id.spinner_change);
        tvShow11=findViewById(R.id.tv_show11);
        tvShow21=findViewById(R.id.tv_show21);
        tvShow31=findViewById(R.id.tv_show31);
        tvShow12=findViewById(R.id.tv_show12);
        tvShow22=findViewById(R.id.tv_show22);
        tvShow32=findViewById(R.id.tv_show32);
        //数据
        data_list = new ArrayList<String>();
        for (int i=0;i<iconName.length;i++)
            data_list.add(iconName[i]);
        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinnerchange.setAdapter(arr_adapter);
        /**选项选择监听*/
        spinnerchange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplication(), "点击了" + arr_adapter.getItem(position), Toast.LENGTH_SHORT).show();
                selectType = arr_adapter.getItem(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void onClickBtn1(View view) {
        if(!iconName[0].equals(selectType)){
            Toast.makeText(this,"Please select the correct conversion icon",Toast.LENGTH_SHORT).show();
            return;
        }

        String a = etInput.getText().toString();
        if (a.isEmpty()){
            Toast.makeText(this,"Please input your value ",Toast.LENGTH_SHORT).show();
            return;
        }
        clearText();
        double d= Double.parseDouble(a);

        double ft =d * 3.2808;
        double yc=d*39.3701;
        DecimalFormat df = new DecimalFormat("0.00");
        String foot = df.format(ft);
        String inch=df.format(yc);
        String metre=df.format(d*100);
        tvShow11.setText(metre);
        tvShow12.setText("Centimetre");
        tvShow21.setText(foot);
        tvShow22.setText("Foot");
        tvShow31.setText(inch);
        tvShow32.setText("inch");


    }

    public void onClickBtn2(View view) {
        if(!iconName[1].equals(selectType)){
            Toast.makeText(this,"Please select the correct conversion icon",Toast.LENGTH_SHORT).show();
            return;
        }

        String a = etInput.getText().toString();
        if (a.isEmpty()){
            Toast.makeText(this,"Please input your value ",Toast.LENGTH_SHORT).show();
            return;
        }
        clearText();
        double d= Double.parseDouble(a);
        DecimalFormat df = new DecimalFormat("0.00");
        String fahrenheit = df.format(1.8*d+32.0);
        String kelvin=df.format(d+273.15);
        tvShow11.setText(fahrenheit);
        tvShow12.setText("Fahrenheit");
        tvShow21.setText(kelvin);
        tvShow22.setText("Kelvin");

    }

    public void onClickBtn3(View view) {

        if(!iconName[2].equals(selectType)){
            Toast.makeText(this,"Please select the correct conversion icon",Toast.LENGTH_SHORT).show();
            return;
        }

        String a = etInput.getText().toString();
        if (a.isEmpty()){
            Toast.makeText(this,"Please input your value ",Toast.LENGTH_SHORT).show();
            return;
        }
        clearText();
        double d= Double.parseDouble(a);


        DecimalFormat df = new DecimalFormat("0.00");
        String gram = df.format(d*1000.0);
        String ounce=df.format(d*35.273968);
        String pound=df.format(d*2.2046);
        tvShow11.setText(gram);
        tvShow12.setText("Gram");
        tvShow21.setText(ounce);
        tvShow22.setText("Ounce(Oz)");
        tvShow31.setText(pound);
        tvShow32.setText("Pound(lb)");
    }

    private void clearText() {
        tvShow11.setText("");
        tvShow12.setText("");
        tvShow21.setText("");
        tvShow22.setText("");
        tvShow31.setText("");
        tvShow32.setText("");
    }
}