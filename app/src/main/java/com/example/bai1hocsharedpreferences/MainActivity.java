package com.example.bai1hocsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSaveData, btnLoadData;
    private TextView tvName;
    private TextView tvAddress;
    private TextView tvAge;
    private TextView tvWeight;
    private RadioButton rbtMale;
    private RadioButton rbtFemale;


    private final String SHARED_PREFERENCES_NAME="ManhTuong";
    private final String MY_NAME="my_name";
    private final String ADDRESS="address";
    private final String SEX="sex";
    private final String AGE="age";
    private final String WEIGHT="weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        addEvents();
    }

    private void addControls() {
        btnSaveData=findViewById(R.id.btnSaveData);
        tvName=findViewById(R.id.tvName);
        tvAddress=findViewById(R.id.tvAddress);
        tvAge=findViewById(R.id.tvAge);
        tvWeight=findViewById(R.id.tvWeight);
        rbtFemale=findViewById(R.id.rbtFemale);
        rbtMale=findViewById(R.id.rbtFemale);
        btnLoadData=findViewById(R.id.btnLoadData);
    }

    private void addEvents() {
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySaveData();
            }
        });

        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLoadData();
            }
        });
    }

    private void xuLySaveData() {
        // khai báo 1 find với tên ....
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPreferences.edit();  // mở file được khai báo ở trên

        // put du liệu vào file
        editor.putString(MY_NAME,"Nguyễn Mạnh Tưởng");
        editor.putString(ADDRESS,"Thanh Mai - Thanh Oai - Hà nội");
        editor.putInt(AGE,34);
        editor.putBoolean(SEX,true); // true là Male, false là female
        editor.putFloat(WEIGHT,65.5f);
        editor.apply();  //

        Toast.makeText(MainActivity.this, "Gui du lieu thanh công", Toast.LENGTH_SHORT).show();
    }

    private void xuLyLoadData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);

        tvName.setText(sharedPreferences.getString(MY_NAME,"").toString());
        tvAddress.setText(sharedPreferences.getString(ADDRESS,"").toString());
        tvAge.setText(""+sharedPreferences.getInt(AGE,0));
        tvWeight.setText(""+sharedPreferences.getFloat(WEIGHT,0.0f));
        if(sharedPreferences.getBoolean(SEX,true)){
            rbtMale.setChecked(true);
        } else rbtFemale.setChecked(true);

    }

}
