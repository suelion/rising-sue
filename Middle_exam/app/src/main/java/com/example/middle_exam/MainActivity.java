package com.example.middle_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView tv_operator, tv_res;
    private EditText et_operand1, et_operand2;
    private Button button;
    private GridLayout grid_num;
    private String[][] arr_num={{"7", "8", "9"}, {"4", "5", "6"}, {"1", "2", "3"}, {"0", "="}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cal);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        tv_operator = (TextView) findViewById(R.id.tv_operator);
        tv_res = (TextView) findViewById(R.id.tv_res);
        et_operand1= (EditText) findViewById(R.id.et_operand1);
        et_operand2= (EditText) findViewById(R.id.et_operand2);
        button = (Button) findViewById(R.id.Button);
        grid_num = (GridLayout) findViewById(R.id.grid_num);


        //789, 456, 123, 0= 순서로 배열
        for(int i = 0; i<4; i++){
            for(String s : arr_num[i]){
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.numeric_btn, null);
                ((Button)layout.findViewById(R.id.btn_num)).setText(s);
                grid_num.addView(layout);
            }
        }

        //지우기(AC) 버튼
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.numeric_btn, null);
        ((Button)layout.findViewById(R.id.btn_num)).setText(R.string.btn_ac);
        grid_num.addView(layout);

        //계산
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() != R.id.Button){
                    return;
                }
                //숫자를 입력하지 않고 =버튼을 누르면 다시 입력하라는 경고문!?!
                if(et_operand1.getText().length()<=0 || et_operand2.getText().length()<=0){
                    Toast.makeText(MainActivity.this,R.string.put_num, Toast.LENGTH_SHORT).show();
                    return;
                }

                int i1 = Integer.parseInt(et_operand1.getText().toString());
                int i2 = Integer.parseInt(et_operand2.getText().toString());

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.rbtn_sub:
                        tv_res.setText(String.valueOf(i1 - i2));
                        break;
                    case R.id.rbtn_sum:
                        tv_res.setText(String.valueOf(i1 + i2));
                        break;
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getId() == R.id.radio_group) {
                    switch (i) {
                        case R.id.rbtn_sum:
                            tv_operator.setText("+");
                            break;
                        case R.id.rbtn_sub:
                            tv_operator.setText("-");
                            break;
                    }
                }
            }
        });
    }
}