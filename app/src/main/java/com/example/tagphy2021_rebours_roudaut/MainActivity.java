package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




// ACTIVITE : CREER UN CALCUL D'IMC SI REP NON ET JE SAIS PAS A CONNAISSEZ VOUS VOTRE IMC
// PENSER A LAFFICHAGE DES RESULTATS AVEC LES DETAILS EN FONCTION DU SCORE
// LIEN VERS SITE WEB A LA FIN

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "QuizzProject";
    protected EditText accEditName;
    private Button accBtnStart;
    private Person person;

    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        accEditName = findViewById(R.id.accEditName);
        accBtnStart = findViewById(R.id.accBtnStart);


        //on restaure suite à onCreate
        if(savedInstanceState != null && savedInstanceState.containsKey(KEY_USERNAME)) {
            String username = savedInstanceState.getString(KEY_USERNAME);
            accEditName.setText(username);
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


    public void start_test(View v){

        if (accEditName.getText().toString().isEmpty()) {
            toast("Please complete all fields");
            vibrate(50);
        } else {
            person.setName(accEditName.getText().toString());
            Log.d(TAG, "start_test: " + this.person);
            Intent intent = new Intent(this, Profil.class);
            intent.putExtra("person", this.person);
            startActivity(intent);
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