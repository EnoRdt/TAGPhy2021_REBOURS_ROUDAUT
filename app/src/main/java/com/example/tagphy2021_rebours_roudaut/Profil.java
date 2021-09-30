package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private RadioButton step1Q1RbMan;
    private RadioButton step1Q1RbWoman;
    private RadioButton step1Q1RbOther;
    private EditText step1Q2EditText;

    private RadioGroup step1Q1RadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Log.d(TAG, "onCreate: ");

        step1Q1RbMan = findViewById(R.id.step1Q1RbMan);
        step1Q1RbWoman = findViewById(R.id.step1Q1RbWoman);
        step1Q1RbOther = findViewById(R.id.step1Q1RbOther);
        step1Q2EditText = findViewById(R.id.step1Q2EditText);

        step1Q1RadioGroup = findViewById(R.id.step1Q1RadioGroup);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Log.d(TAG, "onCreate: User name :" + name);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void next(View v){

        //FAIRE UN SCORE A PASSER GENRE IF TRUC --> repScore = un certain nb pour resultat final

        if (step1Q1RadioGroup.getCheckedRadioButtonId() != -1
            && !step1Q2EditText.getText().toString().isEmpty()) {

            Intent intent = new Intent(this, MonCoeur.class);
            Log.d(TAG, "next: " );
            //  intent.putExtra("score", finalScore);
            startActivity(intent);
        }
        else {
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