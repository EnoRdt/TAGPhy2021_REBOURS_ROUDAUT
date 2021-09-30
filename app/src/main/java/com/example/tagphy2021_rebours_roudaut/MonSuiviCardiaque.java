package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MonSuiviCardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private RadioButton step3Q1RbYes;
    private RadioButton step3Q1RbNo;
    private RadioButton step3Q2RbYes;
    private RadioButton step3Q2RbNo;
    private RadioButton step3Q3RbYes;
    private RadioButton step3Q3RbNo;

    private RadioGroup step3Q1RadioGroup;
    private RadioGroup step3Q2RadioGroup;
    private RadioGroup step3Q3RadioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_suivi_cardiaque);

        step3Q1RadioGroup = findViewById(R.id.step3Q1RadioGroup);
        step3Q2RadioGroup = findViewById(R.id.step3Q2RadioGroup);
        step3Q3RadioGroup = findViewById(R.id.step3Q3RadioGroup);

        Log.d(TAG, "onCreate: ");
    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void next(View v){

        if(step3Q1RadioGroup.getCheckedRadioButtonId() != -1 &&
                step3Q2RadioGroup.getCheckedRadioButtonId() != -1 &&
                step3Q3RadioGroup.getCheckedRadioButtonId() != -1)
        {
            Log.d(TAG, "next: ");
            Intent intent = new Intent(this, Imc.class);
            startActivity(intent);
        }
        else
        {
            toast("Please complete all fields");
        }
    }

    public void previous(View v) {
        this.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}