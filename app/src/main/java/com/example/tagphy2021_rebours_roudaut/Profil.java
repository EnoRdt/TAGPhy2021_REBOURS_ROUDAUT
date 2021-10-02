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
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private static final String KEY_TRANSFER = MainActivity.KEY_TRANSFER;

    private Person person;

    private EditText step1Q2EditText;
    private RadioGroup step1Q1RadioGroup;
    private RadioButton step1Q1RbMan;
    private RadioButton step1Q1RbWoman;
    private RadioButton step1Q1RbOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Log.d(TAG, "onCreate: ");


        step1Q2EditText = findViewById(R.id.step1Q2EditText);
        step1Q1RadioGroup = findViewById(R.id.step1Q1RadioGroup);
        step1Q1RbMan = findViewById(R.id.step1Q1RbMan);
        step1Q1RbWoman = findViewById(R.id.step1Q1RbWoman);
        step1Q1RbOther = findViewById(R.id.step1Q1RbOther);

        processIntentData();


        Log.d(TAG, "onCreate: " );
    }

    //Sauvegarde :
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putString(KEY_TRANSFER, editName.getText().toString());
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

    public void next(View v){


        if (step1Q1RadioGroup.getCheckedRadioButtonId() != -1
            && !step1Q2EditText.getText().toString().isEmpty())
        {

            if(step1Q1RbMan.isChecked()){person.setGenre(Genre.MAN);}
            else if(step1Q1RbWoman.isChecked()){person.setGenre(Genre.WOMAN);}
            else {person.setGenre(Genre.OTHER);}

            person.setAge(step1Q2EditText.getText().toString());

            Intent intent = new Intent(this, MonCoeur.class);
            Log.d(TAG, "next_test: " );
            intent.putExtra(KEY_TRANSFER, this.person);
            startActivity(intent);
        }
        else {
            toast("Please complete all fields");
            vibrate(50);
        }

    }


    public void previous(View v) {
        Intent intent = new Intent(this, MainActivity.class);
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