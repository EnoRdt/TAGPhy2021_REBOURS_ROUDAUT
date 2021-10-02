package com.example.tagphy2021_rebours_roudaut;

import androidx.annotation.NonNull;
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
    private static final String KEY_TRANSFER = MainActivity.KEY_TRANSFER;

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

        processIntentData();

        Log.d(TAG, "onCreate: ");
    }

    //Sauvegarde :
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
      //  outState.putString(KEY_TRANSFER, editName.getText().toString());
    }

    //Restauration :
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(KEY_TRANSFER)) {
            String pokename = savedInstanceState.getString(KEY_TRANSFER);
           // editName.setText(pokename);
        }
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

        if (step3Q1Switch.isChecked()){person.setStep3Q1(true);}
        if (step3Q1Switch.isChecked()){person.setStep3Q2(true);}
        if (step3Q1Switch.isChecked()){person.setStep3Q3(true);}

        Log.d(TAG, "next_test: ");
        Intent intent = new Intent(this, Imc.class);
        intent.putExtra(KEY_TRANSFER, this.person);
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