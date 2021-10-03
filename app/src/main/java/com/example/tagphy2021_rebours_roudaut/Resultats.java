package com.example.tagphy2021_rebours_roudaut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultats extends AppCompatActivity {
    public static final String TAG = MainActivity.TAG;
    private static final String KEY_TRANSFER = MainActivity.KEY_TRANSFER;

    private Person person;

    private Reponse reponse;

    private Button resBtnWeb;
    private Button resBtnFinish;

    private TextView infosPersos;

    private TextView resultsStep2Q1Rep;
    private TextView resultsStep2Q2Rep;
    private TextView resultsStep2Q3Rep;
    private TextView resultsStep2Q4Rep;
    private TextView resultsStep2Q5Rep;
    private TextView resultsStep2Tips;

    private TextView resultsStep3Q1Rep;
    private TextView resultsStep3Q2Rep;
    private TextView resultsStep3Q3Rep;
    private TextView resultsStep3Tips;

    private TextView resultsStep4IMC;
    private TextView resultsStep4IMCRep;
    private TextView resultsStep4Tips;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        Log.d(TAG, "onCreate: ");

        resBtnWeb = findViewById(R.id.resBtnWeb);
        resBtnFinish = findViewById(R.id.resBtnFinish);

        infosPersos = findViewById(R.id.infosPersos);

        resultsStep2Q1Rep = findViewById(R.id.resultsStep2Q1Rep);
        resultsStep2Q2Rep = findViewById(R.id.resultsStep2Q2Rep);
        resultsStep2Q3Rep = findViewById(R.id.resultsStep2Q3Rep);
        resultsStep2Q4Rep = findViewById(R.id.resultsStep2Q4Rep);
        resultsStep2Q5Rep = findViewById(R.id.resultsStep2Q5Rep);
        resultsStep2Tips = findViewById(R.id.resultsStep2Tips);

        resultsStep3Q1Rep = findViewById(R.id.resultsStep3Q1Rep);
        resultsStep3Q2Rep = findViewById(R.id.resultsStep3Q2Rep);
        resultsStep3Q3Rep = findViewById(R.id.resultsStep3Q3Rep);
        resultsStep3Tips = findViewById(R.id.resultsStep3Tips);

        resultsStep4IMC = findViewById(R.id.resultsStep4IMC);
        resultsStep4IMCRep = findViewById(R.id.resultsStep4IMCRep);
        resultsStep4Tips = findViewById(R.id.resultsStep4Tips);

        processIntentData();

        infosPersos.setText(person.getName()+", "+this.person.getGenre().toString()+", "+person.getAge()+" ans");

        resultsStep2Q1Rep.setText(this.person.getStep2Q1().toString());
        resultsStep2Q2Rep.setText(this.person.getStep2Q2().toString());
        resultsStep2Q3Rep.setText(this.person.getStep2Q3().toString());
        resultsStep2Q4Rep.setText(this.person.getStep2Q4().toString());
        resultsStep2Q5Rep.setText(person.getStep2Q5());

        if (this.person.getStep3Q1() == true) {
            resultsStep3Q1Rep.setText("Yes");
            //R.string.clé
        }
        if (this.person.getStep3Q2() == true) {
            resultsStep3Q1Rep.setText("Yes");
            //R.string.clé
        }
        if (this.person.getStep3Q3() == true) {
            resultsStep3Q1Rep.setText("Yes");
            //R.string.clé
        }

        resultsStep4IMC.setText(this.person.getStep4Imc());


        resBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://fedecardio.org/je-me-teste/"));
                startActivity(intent);
            }
        });

        resBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resultats.super.finish();
            }
        });

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