package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MonCoeur extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private RadioButton step2Q1RbYes;
    private RadioButton step2Q1RbNo;
    private RadioButton step2Q2RbYes;
    private RadioButton step2Q2RbNo;
    private RadioButton step2Q3RbYes;
    private RadioButton step2Q3RbNo;
    private RadioButton step2Q4RbYes;
    private RadioButton step2Q4RbNo;

    private Spinner step2Q5Spinner;
    private Spinner step2Q6Spinner;

    private RadioGroup step2Q1RadioGroup;
    private RadioGroup step2Q2RadioGroup;
    private RadioGroup step2Q3RadioGroup;
    private RadioGroup step2Q4RadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);

        Log.d(TAG, "onCreate: ");

        step2Q1RbYes = findViewById(R.id.step2Q1RbYes);
        step2Q1RbNo = findViewById(R.id.step2Q1RbNo);
        step2Q2RbYes = findViewById(R.id.step2Q2RbYes);
        step2Q2RbNo = findViewById(R.id.step2Q2RbNo);
        step2Q3RbYes = findViewById(R.id.step2Q3RbYes);
        step2Q3RbNo = findViewById(R.id.step2Q3RbNo);
        step2Q4RbYes = findViewById(R.id.step2Q4RbYes);
        step2Q4RbNo = findViewById(R.id.step2Q4RbNo);

        step2Q5Spinner = findViewById(R.id.step2Q5Spinner);
        step2Q6Spinner = findViewById(R.id.step2Q6Spinner);

        step2Q1RadioGroup = findViewById(R.id.step2Q1RadioGroup);
        step2Q2RadioGroup = findViewById(R.id.step2Q2RadioGroup);
        step2Q3RadioGroup = findViewById(R.id.step2Q3RadioGroup);
        step2Q4RadioGroup = findViewById(R.id.step2Q4RadioGroup);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void previous(View v) {
        this.onBackPressed();
    }

    public void next(View v){

        //FAIRE UN TRY avec création de fichier d'erreur???

        if (step2Q1RadioGroup.getCheckedRadioButtonId() != -1 &&
                step2Q2RadioGroup.getCheckedRadioButtonId() != -1 &&
                step2Q3RadioGroup.getCheckedRadioButtonId() != -1 &&
                step2Q4RadioGroup.getCheckedRadioButtonId() != -1)
        {
            Log.d(TAG, "next: ");
            Intent intent = new Intent(this, MonSuiviCardiaque.class);
            startActivity(intent);
        }
        else {
            toast("Please complete all fields");

        }
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