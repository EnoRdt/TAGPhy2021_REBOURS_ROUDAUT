package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Log.d(TAG, "onCreate: ");

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Log.d(TAG, "onCreate: User name :" + name);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void next(View v){

        //FAIRE UN TRY avec création de fichier d'erreur sauf si boolean???

        //if blabla pour msg d'erreur toast si pas rempli

        //FAIRE UN SCORE A PASSER GENRE IF TRUC --> repScore = un certain nb pour resultat final

        // Vérifier que age c'est un integer genre msg d'erreur si pas le cas!!

        int finalScore = 0 ;
        int repScore = -1;

        Intent intent = new Intent(this, MonCoeur.class);

        finalScore = finalScore + repScore;
        Log.d(TAG, "next: score : " + finalScore);
        intent.putExtra("score", finalScore);
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