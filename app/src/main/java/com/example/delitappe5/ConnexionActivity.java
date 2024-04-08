package com.example.delitappe5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ConnexionActivity extends AppCompatActivity {

    private EditText etPrenom;
    private EditText etMotDePasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // Initialisation des vues
        etPrenom = findViewById(R.id.et_prenom);
        etMotDePasse = findViewById(R.id.et_mot_de_passe);
        Button btnValider = findViewById(R.id.btn_valider);

        // Action du bouton "Valider"
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération des entrées de l'utilisateur
                String prenom = etPrenom.getText().toString();
                String motDePasse = etMotDePasse.getText().toString();

                // Ici vous pouvez valider les entrées si nécessaire

                // Passer à l'activité de recensement de délit
                Intent intent = new Intent(ConnexionActivity.this, RecensementDelitActivity.class);
                startActivity(intent);
            }
        });
    }
}
