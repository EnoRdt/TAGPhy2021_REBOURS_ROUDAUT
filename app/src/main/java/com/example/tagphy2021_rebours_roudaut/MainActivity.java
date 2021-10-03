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
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "QuizzProject";
    protected EditText accEditName;
    private Person person;


    public static final String KEY_TRANSFER = "TransferPerson";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        accEditName = findViewById(R.id.accEditName);

        processIntentData();
        if (this.person == null){this.person = new Person();}
        else {accEditName.setText(this.person.getName());}

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



    public void toast(int msg) {
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
            toast(R.string.toast);
            vibrate(50);
        } else {
            this.person.setName(accEditName.getText().toString());
            Log.d(TAG, "start_test: " );
            Intent intent = new Intent(this, Profil.class);
            intent.putExtra(KEY_TRANSFER, this.person);
            MainActivity.super.finish();
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