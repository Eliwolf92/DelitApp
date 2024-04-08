package com.example.delitappe5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bouton "Anonyme"
        Button btnAnonyme = findViewById(R.id.btn_anonyme);
        btnAnonyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers la page de connexion anonyme
                startActivity(new Intent(MainActivity.this, ConnexionAnonymeActivity.class));
            }
        });

        // Bouton "Inscription"
        Button btnInscription = findViewById(R.id.btn_inscription);
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers la page d'inscription
                startActivity(new Intent(MainActivity.this, InscriptionActivity.class));
            }
        });

        // Bouton "Connexion"
        Button btnConnexion = findViewById(R.id.btn_connexion);
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers la page de connexion
                startActivity(new Intent(MainActivity.this, ConnexionActivity.class));
            }
        });
    }
}
