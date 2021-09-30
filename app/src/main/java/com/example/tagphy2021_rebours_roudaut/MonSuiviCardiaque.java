package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MonSuiviCardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private Person person;

    private Switch step3Q1Switch;
    private Switch step3Q2Switch;
    private Switch step3Q3Switch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_suivi_cardiaque);

        step3Q1Switch = findViewById(R.id.step3Q1Switch);
        step3Q2Switch = findViewById(R.id.step3Q2Switch);
        step3Q3Switch = findViewById(R.id.step3Q3Switch);

        Log.d(TAG, "onCreate: ");
    }


    public void next(View v) {
        Log.d(TAG, "next: ");
        Intent intent = new Intent(this, Imc.class);
        startActivity(intent);
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