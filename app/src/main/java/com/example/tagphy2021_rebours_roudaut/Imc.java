package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Imc extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private TextView step4Q4ViewResult;
    private EditText step4Q2Weight;
    private EditText step4Q3Size;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Log.d(TAG, "onCreate: ");

        step4Q4ViewResult = findViewById(R.id.step4Q4ViewResult);
        step4Q2Weight = findViewById(R.id.step4Q2Weight);
        step4Q3Size = findViewById(R.id.step4Q3Size);
    }

    public void next(View v){

        // Vérifier que tous les champs sont renseignés
        Log.d(TAG, "start_test: ");
        Intent intent = new Intent(this, Resultats.class);
        startActivity(intent);
    }

    public void previous(View v) {
        this.onBackPressed();
    }

    public void toast(String msg) { Toast.makeText(this, msg,Toast.LENGTH_SHORT).show(); }
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
    public void calculImc(View v) {
        float result;
        String res = "RESULT";
        if (step4Q2Weight.getText().toString().isEmpty() || step4Q3Size.getText().toString().isEmpty()) {
            toast("Please complete all fields");
            vibrate(50);
        } else {
            result = (Float.parseFloat(String.valueOf(step4Q2Weight.getText())) / ((Float.parseFloat(String.valueOf(step4Q3Size.getText()))/100) * (Float.parseFloat(String.valueOf(step4Q3Size.getText())))/100) );
            res = Float.toString(result);
            step4Q4ViewResult.setText(res);
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