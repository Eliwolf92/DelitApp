package com.example.delitappe5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InscriptionActivity extends AppCompatActivity {

    private EditText etPrenom;
    private EditText etNom;
    private EditText etEmail;
    private EditText etTelephone;
    private EditText etMotDePasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Initialisation des vues
        etPrenom = findViewById(R.id.et_prenom);
        etNom = findViewById(R.id.et_nom);
        etEmail = findViewById(R.id.et_email);
        etTelephone = findViewById(R.id.et_telephone);
        etMotDePasse = findViewById(R.id.et_mot_de_passe);
        Button btnValider = findViewById(R.id.btn_valider_inscription);

        // Action du bouton "Valider"
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération des valeurs saisies par l'utilisateur
                String prenom = etPrenom.getText().toString();
                String nom = etNom.getText().toString();
                String email = etEmail.getText().toString();
                String telephone = etTelephone.getText().toString();
                String motDePasse = etMotDePasse.getText().toString();

                // Envoi des données à l'API
                enregistrerUtilisateur(prenom, nom, email, telephone, motDePasse);
            }
        });
    }

    // Méthode pour envoyer les données à l'API
    private void enregistrerUtilisateur(String prenom, String nom, String email, String telephone, String motDePasse) {
        OkHttpClient client = new OkHttpClient();

        // Création du corps de la requête
        RequestBody requestBody = new FormBody.Builder()
                .add("prenom", prenom)
                .add("nom", nom)
                .add("email", email)
                .add("telephone", telephone)
                .add("motDePasse", motDePasse)
                .build();

        // Création de la requête
        Request request = new Request.Builder()
                .url("URL_DE_VOTRE_API")
                .post(requestBody)
                .build();

        // Envoi de la requête à l'API
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Gérer les cas d'échec de la requête
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InscriptionActivity.this, "Erreur lors de l'enregistrement de l'utilisateur", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Gérer la réponse de l'API
                if (response.isSuccessful()) {
                    // L'utilisateur a été enregistré avec succès
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InscriptionActivity.this, "Utilisateur enregistré avec succès", Toast.LENGTH_SHORT).show();
                            // Vous pouvez rediriger l'utilisateur vers une autre activité ici si nécessaire
                        }
                    });
                } else {
                    // Gérer les cas où la réponse de l'API n'est pas réussie
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InscriptionActivity.this, "Erreur lors de l'enregistrement de l'utilisateur", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
