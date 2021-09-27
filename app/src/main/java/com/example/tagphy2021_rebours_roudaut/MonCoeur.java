package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MonCoeur extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);

        Log.d(TAG, "onCreate: ");
    }

    public void previous(View v) {
        this.onBackPressed();
    }

    public void next(View v){

        //FAIRE UN TRY avec création de fichier d'erreur???

        // Vérifier que l'age c'est un integer genre msg d'erreur si pas le cas!!
        // Vérifier que tous les champs sont renseignés
            Log.d(TAG, "start_test: ");
            Intent intent = new Intent(this, MonSuiviCardiaque.class);
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