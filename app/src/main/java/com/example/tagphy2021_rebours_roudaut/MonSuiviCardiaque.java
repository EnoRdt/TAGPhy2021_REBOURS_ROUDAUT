package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MonSuiviCardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private static final String KEY_TRANSFER = MainActivity.KEY_TRANSFER;

    private Person person;

    private SwitchCompat step3Q1Switch;
    private SwitchCompat step3Q2Switch;
    private SwitchCompat step3Q3Switch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_suivi_cardiaque);

        Log.d(TAG, "onCreate: ");

        step3Q1Switch = findViewById(R.id.step3Q1Switch);
        step3Q2Switch = findViewById(R.id.step3Q2Switch);
        step3Q3Switch = findViewById(R.id.step3Q3Switch);

        processIntentData();

        step3Q1Switch.setChecked(this.person.getStep3Q1());
        step3Q2Switch.setChecked(this.person.getStep3Q2());
        step3Q3Switch.setChecked(this.person.getStep3Q3());


    }


    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra(KEY_TRANSFER);
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Next or Previous Activity");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Next or Previous Activity");
        }
    }


    public void next(View v) {

        if (step3Q1Switch.isChecked()){this.person.setStep3Q1(Boolean.TRUE);}
        else{this.person.setStep3Q1(Boolean.FALSE);}
        if (step3Q2Switch.isChecked()){this.person.setStep3Q2(Boolean.TRUE);}
        else{this.person.setStep3Q2(Boolean.FALSE);}
        if (step3Q3Switch.isChecked()){this.person.setStep3Q3(Boolean.TRUE);}
        else{this.person.setStep3Q3(Boolean.FALSE);}

        Log.d(TAG, "next_test: ");
        Intent intent = new Intent(this, Imc.class);
        intent.putExtra(KEY_TRANSFER, this.person);
        MonSuiviCardiaque.super.finish();
        startActivity(intent);
    }

    public void previous(View v) {
        Intent intent = new Intent(this, MonCoeur.class);
        Log.d(TAG, "previous_test: " );
        intent.putExtra(KEY_TRANSFER, this.person);
        startActivity(intent);
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