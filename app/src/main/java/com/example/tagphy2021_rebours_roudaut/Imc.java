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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Imc extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private static final String KEY_TRANSFER = MainActivity.KEY_TRANSFER;

    private RadioGroup step4Q1RadioGroup;
    private RadioButton step4Q1RbYes;
    private RadioButton step4Q1RbNo;

    private TextView step4Q1;
    private TextView step4Q1Ask;
    private TextView step4Q4ViewResult;
    private TextView step4Q2;
    private TextView step4Q2Bis;
    private TextView step4Q3;
    private TextView step4Q4;
    private TextView step4Q2Ask;
    private TextView step4Q2AskBis;
    private TextView step4Q3Ask;
    private TextView step4Q4Rep;

    private EditText step4Q2Weight;
    private EditText step4Q3Size;
    private EditText step4Q2Imc;

    private ImageButton step4ImgButton;

    private Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Log.d(TAG, "onCreate: ");

        step4Q1RadioGroup = findViewById(R.id.step4Q1RadioGroup);
        step4Q1RbYes = findViewById(R.id.step4Q1RbYes);
        step4Q1RbNo = findViewById(R.id.step4Q1RbNo);
        step4Q1 = findViewById(R.id.step4Q1);
        step4Q1Ask = findViewById(R.id.step4Q1Ask);
        step4Q4ViewResult = findViewById(R.id.step4Q4ViewResult);
        step4Q2 = findViewById(R.id.step4Q2);
        step4Q2Bis = findViewById(R.id.step4Q2Bis);
        step4Q3 = findViewById(R.id.step4Q3);
        step4Q4 = findViewById(R.id.step4Q4);
        step4Q2Ask = findViewById(R.id.step4Q2Ask);
        step4Q2AskBis = findViewById(R.id.step4Q2AskBis);
        step4Q3Ask = findViewById(R.id.step4Q3Ask);
        step4Q4Rep = findViewById(R.id.step4Q4Rep);
        step4Q2Weight = findViewById(R.id.step4Q2Weight);
        step4Q3Size = findViewById(R.id.step4Q3Size);
        step4Q2Imc = findViewById(R.id.step4Q2Imc);
        step4ImgButton = findViewById(R.id.step4ImgButton);

        processIntentData();

        if(person.getStep4Q1()==Reponse.YES){step4Q1RbYes.setChecked(true);}
        else if(person.getStep4Q1()==Reponse.NO){step4Q1RbNo.setChecked(true);}

        if(!person.getStep4Imc().equals(person.DEFAULT_IMC)){step4Q2Imc.setText(person.getStep4Imc());}
        if(!person.getStep4Q2Weight().equals(person.DEFAULT_WEIGHT)){step4Q2Weight.setText(person.getStep4Q2Weight());}
        if(!person.getStep4Q3Size().equals(person.DEFAULT_SIZE)){step4Q3Size.setText(person.getStep4Q3Size());}
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

    public void check(View v) {
        if (step4Q1RadioGroup.getCheckedRadioButtonId() != -1) {
            if (step4Q1RbYes.isChecked()) {

                step4Q2Bis.setVisibility(View.VISIBLE);
                step4Q2AskBis.setVisibility(View.VISIBLE);
                step4Q2Imc.setVisibility(View.VISIBLE);
                step4Q2.setVisibility(View.GONE);
                step4Q3.setVisibility(View.GONE);
                step4Q4.setVisibility(View.GONE);
                step4Q2Ask.setVisibility(View.GONE);
                step4Q3Ask.setVisibility(View.GONE);
                step4Q4Rep.setVisibility(View.GONE);
                step4Q2Weight.setVisibility(View.GONE);
                step4Q3Size.setVisibility(View.GONE);
                step4ImgButton.setVisibility(View.GONE);
                step4Q4ViewResult.setVisibility(View.GONE);
            }
            else if (step4Q1RbNo.isChecked()){

                step4Q2Bis.setVisibility(View.GONE);
                step4Q2AskBis.setVisibility(View.GONE);
                step4Q2Imc.setVisibility(View.GONE);
                step4Q2.setVisibility(View.VISIBLE);
                step4Q3.setVisibility(View.VISIBLE);
                step4Q4.setVisibility(View.VISIBLE);
                step4Q2Ask.setVisibility(View.VISIBLE);
                step4Q3Ask.setVisibility(View.VISIBLE);
                step4Q2Weight.setVisibility(View.VISIBLE);
                step4Q3Size.setVisibility(View.VISIBLE);
                step4ImgButton.setVisibility(View.VISIBLE);
                step4Q4ViewResult.setVisibility(View.VISIBLE);
                step4Q4Rep.setVisibility(View.VISIBLE);
            }
        }
    }

    public void calculImc(View v){
        float result;
        String res = "RESULT";

        if (step4Q2Weight.getText().toString().isEmpty() || step4Q3Size.getText().toString().isEmpty()) {
            toast("Please complete all fields");
            vibrate(50);
        } else {
            result = (Float.parseFloat(String.valueOf(step4Q2Weight.getText())) / ((Float.parseFloat(String.valueOf(step4Q3Size.getText())) / 100) * (Float.parseFloat(String.valueOf(step4Q3Size.getText()))) / 100));
            res = Float.toString(result);
            step4Q4ViewResult.setText(res);
        }
    }

    public void next(View v){

        if (step4Q1RadioGroup.getCheckedRadioButtonId() != -1) {
            if (step4Q1RbYes.isChecked()){

                if (step4Q2Imc.getText().toString().isEmpty()){
                    toast("Please complete all fields");
                    vibrate(50);
                }
                else {
                    if(step4Q1RbYes.isChecked()){person.setStep4Q1(Reponse.YES);}
                    else {person.setStep4Q1(Reponse.NO);}
                    person.setStep4Imc(step4Q2Imc.getText().toString());

                    Log.d(TAG, "next_test: ");
                    Intent intent = new Intent(this, Resultats.class);
                    intent.putExtra(KEY_TRANSFER, this.person);
                    startActivity(intent);
                }
            }
            else {
                if (step4Q2Weight.getText().toString().isEmpty() || step4Q3Size.getText().toString().isEmpty()) {
                    toast("Please complete all fields");
                    vibrate(50);
                } else {
                    person.setStep4Q2Weight(step4Q2Weight.getText().toString());
                    person.setStep4Q3Size(step4Q3Size.getText().toString());
                    person.setStep4Imc(step4Q4ViewResult.getText().toString());
                    Log.d(TAG, "next_test: ");
                    Intent intent = new Intent(this, Resultats.class);
                    intent.putExtra(KEY_TRANSFER, this.person);
                    startActivity(intent);
                }
            }
        }
        else {
            toast("Please complete all fields");
            vibrate(50);
        }
    }

    public void previous(View v) {
        Intent intent = new Intent(this, MonSuiviCardiaque.class);
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