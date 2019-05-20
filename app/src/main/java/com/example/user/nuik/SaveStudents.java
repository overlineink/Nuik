package com.example.user.nuik;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SaveStudents extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextNum;
    private EditText editTextName;
    private EditText editTextName1;
    private EditText editTextpar;
    private EditText editTextspe;
    private EditText editTextann;
    private EditText editTextgrp;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_students);
        db = FirebaseFirestore.getInstance();
        editTextNum = findViewById(R.id.edittext_num);
        editTextName = findViewById(R.id.edittext_name);
        editTextName1 = findViewById(R.id.edittext_name1);
        editTextpar = findViewById(R.id.edittext_Parcours);
        editTextspe = findViewById(R.id.edittext_speci);
        editTextann = findViewById(R.id.edittext_ann);
        editTextgrp = findViewById(R.id.edittext_grp);
        findViewById(R.id.button_save).setOnClickListener(this);
        findViewById(R.id.textview_view_stu).setOnClickListener(this);


    }

    ///////////// Vérifier les chapms
    private boolean validateInputs(String num, String nom, String nom1, String par, String spc, String ann, String grp) {
        if (num.isEmpty()) {
            editTextNum.setError("Veuillez introduire le numéro d'inscription S'il vous plait");
            editTextNum.requestFocus();
            return true;
        }
        if (nom.isEmpty()) {
            editTextName.setError("Veuillez introduire le Nom  S'il vous plait");
            editTextName.requestFocus();
            return true;
        }
        if (nom1.isEmpty()) {
            editTextName1.setError("Veuillez introduire le Prénom  S'il vous plait");
            editTextName1.requestFocus();
            return true;
        }
        if (par.isEmpty()) {
            editTextpar.setError("Veuillez introduire le parcours courrant   S'il vous plait");
            editTextpar.requestFocus();
            return true;
        }
        if (spc.isEmpty()) {
            editTextspe.setError("Veuillez introduire la spécialité   S'il vous plait");
            editTextspe.requestFocus();
            return true;
        }
        if (ann.isEmpty()) {
            editTextann.setError("Veuillez introduire l'année  S'il vous plait");
            editTextann.requestFocus();
            return true;
        }
        if (grp.isEmpty()) {
            editTextgrp.setError("Veuillez introduire le groupe  S'il vous plait");
            editTextgrp.requestFocus();
            return true;
        }


        return false;
    }



    public void saveProduct() {
        String nume = editTextNum.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String name1 = editTextName1.getText().toString().trim();
        String prc = editTextpar.getText().toString().trim();
        String sc = editTextspe.getText().toString().trim();
        String an = editTextann.getText().toString().trim();
        String gr = editTextgrp.getText().toString().trim();

        if (!validateInputs(nume, name, name1, prc, sc, an, gr)) {

            CollectionReference dbStudent = db.collection("Students");
            Students students = new Students(nume, name, name1, prc, sc, an, gr);
            dbStudent.add(students)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(SaveStudents.this, "Student Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SaveStudents.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }
        editTextNum.setText("");
       editTextName.setText("");
          editTextName1.setText("");
       editTextpar.setText("");
         editTextspe.setText("");
        editTextann.setText("");
       editTextgrp.setText("");


    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_save:
                saveProduct();
                break;
            case R.id.textview_view_stu:
                startActivity(new Intent(this, StudentsActivity.class));
                break;
        }


    }


}
