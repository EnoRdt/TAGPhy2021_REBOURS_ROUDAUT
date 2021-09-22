package com.example.tagphy2021_rebours_roudaut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




// ACTIVITE : CREER UN CALCUL D'IMC SI REP NON ET JE SAIS PAS A CONNAISSEZ VOUS VOTRE IMC
// PENSER A LAFFICHAGE DES RESULTATS AVEC LES DETAILS EN FONCTION DU SCORE

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "QuizzProject";
    protected EditText accEditName;
    private Button accBtnStart;

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


    public void start_test(View v){

        //FAIRE UN TRY avec création de fichier d'erreur???

        // Vérifier que nom c'est un string genre msg d'erreur si pas le cas!!

        if (accEditName.getText().toString().isEmpty()) {
            toast("Please complete all fields");}
        else {
            Log.d(TAG, "start_test: " + accEditName.getText().toString());
            Intent intent = new Intent(this, Profil.class);
            intent.putExtra("name", accEditName.getText().toString());
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