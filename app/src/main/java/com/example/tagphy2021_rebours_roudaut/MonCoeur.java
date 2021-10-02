package com.example.tagphy2021_rebours_roudaut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MonCoeur extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private static final String KEY_TRANSFER = MainActivity.KEY_TRANSFER;

    private Person person;

    private Spinner step2Q5Spinner;

    private RadioGroup step2Q1RadioGroup;
    private RadioGroup step2Q2RadioGroup;
    private RadioGroup step2Q3RadioGroup;
    private RadioGroup step2Q4RadioGroup;

    private RadioButton step2Q1RbYes;
    private RadioButton step2Q1RbNo;
    private RadioButton step2Q2RbYes;
    private RadioButton step2Q2RbNo;
    private RadioButton step2Q3RbYes;
    private RadioButton step2Q3RbNo;
    private RadioButton step2Q4RbYes;
    private RadioButton step2Q4RbNo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);

        Log.d(TAG, "onCreate: ");

        step2Q5Spinner = findViewById(R.id.step2Q5Spinner);

        step2Q1RadioGroup = findViewById(R.id.step2Q1RadioGroup);
        step2Q2RadioGroup = findViewById(R.id.step2Q2RadioGroup);
        step2Q3RadioGroup = findViewById(R.id.step2Q3RadioGroup);
        step2Q4RadioGroup = findViewById(R.id.step2Q4RadioGroup);

        step2Q1RbYes = findViewById(R.id.step2Q1RbYes);
        step2Q1RbNo = findViewById(R.id.step2Q1RbNo);
        step2Q2RbYes = findViewById(R.id.step2Q2RbYes);
        step2Q2RbNo = findViewById(R.id.step2Q2RbNo);
        step2Q3RbYes = findViewById(R.id.step2Q3RbYes);
        step2Q3RbNo = findViewById(R.id.step2Q3RbNo);
        step2Q4RbYes = findViewById(R.id.step2Q4RbYes);
        step2Q4RbNo = findViewById(R.id.step2Q4RbNo);

        processIntentData();

        if(person.getStep2Q1()==Reponse.YES){step2Q1RbYes.setChecked(true);}
        else if(person.getStep2Q1()==Reponse.NO){step2Q1RbNo.setChecked(true);}

        if(person.getStep2Q2()==Reponse.YES){step2Q2RbYes.setChecked(true);}
        else if(person.getStep2Q2()==Reponse.NO){step2Q2RbNo.setChecked(true);}

        if(person.getStep2Q3()==Reponse.YES){step2Q3RbYes.setChecked(true);}
        else if(person.getStep2Q3()==Reponse.NO){step2Q3RbNo.setChecked(true);}

        if(person.getStep2Q4()==Reponse.YES){step2Q4RbYes.setChecked(true);}
        else if(person.getStep2Q4()==Reponse.NO){step2Q4RbNo.setChecked(true);}


        if(person.getStep2Q5()=="Yes" || person.getStep2Q5()=="Non"){step2Q5Spinner.setSelection(1);}
        else if(person.getStep2Q5()=="I do not know" || person.getStep2Q5()=="Je ne sais pas"){step2Q5Spinner.setSelection(2);}
        else{step2Q5Spinner.setSelection(0);};


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

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void vibrate(long duration_ms) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(duration_ms < 1)
            duration_ms = 1;
        if(v != null && v.hasVibrator()) {
            // Attention changement comportement avec API >= 26 (cf doc)
            if(Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                v.vibrate(duration_ms);
            }
        }
        // sinon il n'y a pas de mécanisme de vibration
    }

    public void previous(View v) {
        Intent intent = new Intent(this, Profil.class);
        Log.d(TAG, "previous_test: " );
        intent.putExtra(KEY_TRANSFER, this.person);
        startActivity(intent);
    }

    public void next(View v){

        if (step2Q1RadioGroup.getCheckedRadioButtonId() != -1 &&
                step2Q2RadioGroup.getCheckedRadioButtonId() != -1 &&
                step2Q3RadioGroup.getCheckedRadioButtonId() != -1 &&
                step2Q4RadioGroup.getCheckedRadioButtonId() != -1)
        {

            if(step2Q1RbYes.isChecked()){person.setStep2Q1(Reponse.YES);}
            else {person.setStep2Q1(Reponse.NO);}
            if(step2Q2RbYes.isChecked()){person.setStep2Q2(Reponse.YES);}
            else {person.setStep2Q2(Reponse.NO);}
            if(step2Q3RbYes.isChecked()){person.setStep2Q3(Reponse.YES);}
            else {person.setStep2Q3(Reponse.NO);}
            if(step2Q4RbYes.isChecked()){person.setStep2Q4(Reponse.YES);}
            else {person.setStep2Q4(Reponse.NO);}

            person.setStep2Q5(step2Q5Spinner.getSelectedItem().toString());

            Log.d(TAG, "next_test: ");
            Intent intent = new Intent(this, MonSuiviCardiaque.class);
            intent.putExtra(KEY_TRANSFER, this.person);
            startActivity(intent);
        }
        else {
            toast("Please complete all fields");
            vibrate(50);

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